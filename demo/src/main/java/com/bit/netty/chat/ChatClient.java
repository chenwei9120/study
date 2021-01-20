package com.bit.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ChatClient.java
 * @Description TODO
 * @createTime 2019年12月19日 01:12:00
 */
public class ChatClient {
    public static void main(String[] args) throws Exception {
        //客户端需要一个事件循环组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建客户端启动对象
            //注意客户端使用的不是 ServerBootstrap 而是 Bootstrap
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decoder", new StringDecoder())
                                    .addLast("encode", new StringEncoder())
                                    .addLast(new ChatClientHandler())
                                    .addLast(new ChatClientHandler2());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 10010).sync();
            Channel channel = channelFuture.channel();
            channel.writeAndFlush("Hello, Server");
            channel.closeFuture().sync();
            //将输入信息发送到服务端
//            System.out.println("===============" + channel.localAddress() + "===============");
//            Scanner scanner = new Scanner(System.in);
//            while (scanner.hasNextLine()) {
//                String msg = scanner.nextLine();
//                channel.writeAndFlush(msg);//.closeFuture().sync();
//            }
        } finally {
            group.shutdownGracefully();
        }
    }
}