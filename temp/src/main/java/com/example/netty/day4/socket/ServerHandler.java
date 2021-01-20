package com.example.netty.day4.socket;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * @author 张飞老师
 */
public class ServerHandler extends SimpleChannelHandler{
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
//		ChannelBuffer buffer = (ChannelBuffer) e.getMessage();
//		byte[] bs = buffer.array();
		System.out.println("server receive data: " + e.getMessage());
	}
}