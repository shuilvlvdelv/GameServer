package com.ftiger.www.game.routers;

import com.ftiger.www.common.annotation.Router;
import com.ftiger.www.common.manage.ChannelManager;
import com.ftiger.www.common.router.BaseRouter;
import com.ftiger.www.game.protocol.GameServerOuterClass;
import com.ftiger.www.game.redis.obj.RoomInfoDO;
import com.ftiger.www.game.redis.obj.UserRedisDO;
import com.ftiger.www.game.routers.resultVO.room.RoomConditionVO;
import com.ftiger.www.game.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * @author 宋旭源
 */
@Component
@Router(code = "intoRoom")
public class IntoRoomRouter implements BaseRouter {

  @Autowired
  private RoomService roomService;

  @Override
  public void exec(UserRedisDO channelContext, Map<String, Object> msg) {
    // 加入房间
    RoomConditionVO roomConditionVO = roomService.joinRoom(channelContext);

    // 返回房间状况
    ChannelManager.send(channelContext, 10001, roomConditionVO);

  }
}
