package com.ftiger.www.common.netty.pipeline;

import com.ftiger.www.common.netty.handler.TextWebSocketFrameHandler;
import com.ftiger.www.game.protocol.GameServerOuterClass;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.stereotype.Component;

/**
 * @author soulxy
 * @version \$Id: ${FILE.name}, v 0.1 2017年08月03 下午4:16 soulxy Exp $
 */
@Component
public class ChannelServerInitializer extends ChannelInitializer<Channel> {


  @Override
  protected void initChannel(Channel channel) throws Exception {
    ChannelPipeline pipeline = channel.pipeline();
    // pipeline.addLast(new IdleStateHandler(5, 0, 0));
    pipeline.addLast(new HttpServerCodec());
    pipeline.addLast(new ChunkedWriteHandler());
    pipeline.addLast(new HttpObjectAggregator(64 * 1024));
    pipeline.addLast(new WebSocketServerCompressionHandler());
    pipeline.addLast(new WebSocketServerProtocolHandler("/", null, true));
    pipeline.addLast(new ProtobufDecoder(GameServerOuterClass.GameServer.getDefaultInstance()));
    pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
    pipeline.addLast(new TextWebSocketFrameHandler());
  }
}
