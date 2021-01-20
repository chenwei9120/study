package com.bit.netty.hello;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName EchoServerOutHandler1.java
 * @Description TODO
 * @createTime 2020年01月14日 13:46:00
 */
//@ChannelHandler.Sharable
public class EchoServerOutHandler2 extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ctx.writeAndFlush("EchoServerOutHandler2:-----------------" + msg.toString() , promise);
    }

}