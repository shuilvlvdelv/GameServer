package com.ftiger.www.common.manage;

import com.ftiger.www.game.protocol.GameServerOuterClass;
import com.google.common.collect.Maps;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import java.util.Map;

public class ChannelManager {
  private static final Map<String, Channel> CHANNEL_MAP = Maps.newHashMap();

  public static void put(String key, Channel channel) {
    CHANNEL_MAP.put(key, channel);
  }

  public static void send(String channelId, GameServerOuterClass.GameServer gameServer) {
    Channel channel = CHANNEL_MAP.get(channelId);
    ByteBuf result = Unpooled.buffer();
    result.writeBytes(gameServer.toByteArray());
    channel.pipeline().writeAndFlush(new BinaryWebSocketFrame(result));
  }
}
