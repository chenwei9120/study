package com.bit.netty.chat;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ChatServerHandler.java
 * @Description TODO
 * @createTime 2019年12月19日 01:03:00
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channel.write("write method debug");
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + " 上线了" + sdf.format(new Date()) + "\n");
        channelGroup.add(channel);
        System.out.println(channel.remoteAddress() + " 上线了" + sdf.format(new Date()) + "\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + " 下线了" + sdf.format(new Date()) + "\n");
        System.out.println(channel.remoteAddress() + " 上线了" + sdf.format(new Date()) + "\n");
        System.out.println("channelGroup size=" + channelGroup.size());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch->{
            if(channel != ch) {
                ch.writeAndFlush("[客户端]" + channel.remoteAddress() + " 发送了消息" + msg + "\n");
            } else {
                ch.writeAndFlush("[自己]发送了" + msg + "\n");
            }
        });
        System.out.println("[客户端]" + channel.remoteAddress() + " 发送了消息" + msg + "\n");
    }
}
