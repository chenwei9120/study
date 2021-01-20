package com.bit.netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ChatClientHandler.java
 * @Description TODO
 * @createTime 2019年12月19日 01:14:00
 */
public class ChatClientHandler2 extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("ChatClientHandler2 print" + msg.trim());
    }
}