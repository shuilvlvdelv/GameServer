package com.ftiger.www.game.routers;

import com.ftiger.www.common.annotation.Router;
import com.ftiger.www.common.contant.StatusConst;
import com.ftiger.www.common.entity.UserRoomInfo;
import com.ftiger.www.common.router.BaseRouter;
import com.ftiger.www.game.redis.obj.RoomInfoDO;
import com.ftiger.www.game.redis.obj.UserRedisDO;
import com.ftiger.www.game.services.RoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
    RoomInfoDO roomInfoDO = roomService.getIdleEoom();
    UserRoomInfo userRoomInfo = new UserRoomInfo();
    BeanUtils.copyProperties(channelContext, userRoomInfo);
    userRoomInfo.setStatus(StatusConst.USER_ROOM_STATUS_WAIT);
    roomInfoDO.getUserRoomInfos().add(userRoomInfo);
  }
}
