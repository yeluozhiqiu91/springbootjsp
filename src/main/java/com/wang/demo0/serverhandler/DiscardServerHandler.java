package com.wang.demo0.serverhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author: wangliujie
 * @Date: 2019/5/29 11:25
 */
public class DiscardServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // Discard the received data silently.
//        ((ByteBuf) msg).release();
        ByteBuf in = (ByteBuf) msg;
        while (in.isReadable()) {
            System.out.print((char) in.readByte());
            System.out.flush();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
