package com.ftiger.www.common.netty.handler;

import com.ftiger.www.common.manage.ChannelManager;
import com.ftiger.www.game.protocol.GameServerOuterClass;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

/**
 * @author soulxy
 * @version \$Id: ${FILE.name}, v 0.1 2017年08月03 下午4:07 soulxy Exp $
 */
public class TextWebSocketFrameHandler
    extends SimpleChannelInboundHandler<GameServerOuterClass.GameServer> {

  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    if (evt == WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE) {
      ChannelManager.put(ctx.channel().id().asLongText(), ctx.channel());
    } else {
      super.userEventTriggered(ctx, evt);
    }
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, GameServerOuterClass.GameServer msg)
      throws Exception {

  }

  private void sendConnSuccess(String channelId) {
    GameServerOuterClass.GameServer gameServer =
        new GameServerOuterClass.GameServer.Builder().setCode(10000).build();
    ChannelManager.send(channelId, gameServer);
  }
}
