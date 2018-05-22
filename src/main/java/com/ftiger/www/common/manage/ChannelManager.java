package com.ftiger.www.common.manage;

import com.alibaba.fastjson.JSON;
import com.ftiger.www.game.protocol.GameServerOuterClass;
import com.ftiger.www.game.redis.obj.UserRedisDO;
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

  public static void send(UserRedisDO context, int code, Object data) {
    GameServerOuterClass.GameServer gameServer = GameServerOuterClass.GameServer.newBuilder()
        .setCode(code).setContext(JSON.toJSONString(data)).build();
    send(context.getChannelId(), gameServer);
  }
}
