/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.bit.netty.hello;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;

/**
 * Handler implementation for the echo server.
 */
//@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client " + ctx.channel().remoteAddress() + " connected");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg == null) {
            return;
        }
        if (msg instanceof ByteBuffer) {
            ByteBuf in = (ByteBuf) msg;
            System.out.println("handler1 received: " + in.toString(CharsetUtil.UTF_8));
        } else if (msg instanceof String) {
            ctx.writeAndFlush("handler1 收到消息--" + msg + System.lineSeparator());
            ctx.fireChannelRead(msg);
            System.out.println("handler1 received: " + msg);
        }
//        ctx.write(Unpooled.wrappedBuffer("Hello, this is server response China.".getBytes()));
//        ctx.write("chnnel id =" + ctx.channel().id().asShortText() + ";tid=" + Thread.currentThread().getId());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
