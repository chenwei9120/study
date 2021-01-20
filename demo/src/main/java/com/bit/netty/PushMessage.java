package com.bit.netty;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName PushMessage.java
 * @Description TODO
 * @createTime 2020年02月01日 00:52:00
 */
@Slf4j
public class PushMessage {
    private void pushMessage(ChannelHandlerContext ctx, Object message) {
        try {
            ChannelFuture cf = ctx.writeAndFlush(message);
            //异步使用观察者模式接收推送结果
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) {
                    if (future.isSuccess()) {
                        log.debug("send success.");
                        //logger.debug("send success.");
                    } else {
                        //throw new PushException("Failed to send message.");
                    }
                    Throwable cause = future.cause();
                    if (cause != null) {
                        //throw new PushException(cause);
                    }
                }
            });
        } catch (Exception e) {
        } catch (Throwable e) {
        }
    }
}