package com.ftiger.www.common.factory;

import com.ftiger.www.common.contant.StatusConst;
import com.ftiger.www.common.manage.ChannelGroupMannger;
import com.ftiger.www.common.utils.IDUtil;
import com.ftiger.www.game.redis.obj.RoomInfoDO;
import com.google.common.collect.Lists;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;

/**
 * @author 宋旭源
 */
public class RoomFactory {

  public static RoomInfoDO createRoom() {
    RoomInfoDO roomInfoDO = new RoomInfoDO();
    roomInfoDO.setStatus(StatusConst.ROOM_STATUS_WAIT);
    roomInfoDO.setUserLen(0);
    roomInfoDO.setUserRoomInfos(Lists.newArrayList());
    roomInfoDO.setId(IDUtil.createId());

    // 生成
    ChannelGroup channelGroup = ChannelGroupFactory.createChannelGroup(IDUtil.createId() + "");
    roomInfoDO.setChannelId(channelGroup.name());
    ChannelGroupMannger.put(channelGroup.name(), channelGroup);

    return roomInfoDO;
  }
}
