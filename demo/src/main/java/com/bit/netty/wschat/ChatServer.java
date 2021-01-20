package com.bit.netty.wschat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ChatServer.java
 * @Description TODO
 * @createTime 2020年01月30日 15:02:00
 */
public class ChatServer {
    private int port;

    public ChatServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(4);
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("http-decodec", new HttpRequestDecoder());
                            pipeline.addLast("http-aggregator", new HttpObjectAggregator(65536));
                            pipeline.addLast("http-encodec", new HttpResponseEncoder());
                            pipeline.addLast("http-chunked", new ChunkedWriteHandler());
                            pipeline.addLast("http-request", new HttpRequestHandler("/ws"));
                            pipeline.addLast("WebSocket-protocol", new WebSocketServerProtocolHandler("/ws"));
                            pipeline.addLast("WebSocket-request", new TextWebSocketFrameHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            System.out.println("弹幕程序 启动了" + port);
            // 绑定端口，开始接收进来的连接
            ChannelFuture f = b.bind(port).sync();
            //ChannelFuture f = b.bind(port).syncUninterruptibly();
            // 等待服务器  socket 关闭 。
            // 在这个例子中，这不会发生，但你可以优雅地关闭你的服务器。
            f.channel().closeFuture().sync();


        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            System.out.println("弹幕程序 关闭了");
        }
    }

    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new ChatServer(port).run();
    }
}