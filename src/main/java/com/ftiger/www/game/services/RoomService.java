package com.ftiger.www.game.services;

import com.ftiger.www.common.contant.StatusConst;
import com.ftiger.www.common.entity.UserRoomInfo;
import com.ftiger.www.common.factory.RoomFactory;
import com.ftiger.www.common.utils.ListUtil;
import com.ftiger.www.game.redis.dao.RoomRepository;
import com.ftiger.www.game.redis.obj.RoomInfoDO;
import com.ftiger.www.game.redis.obj.UserRedisDO;
import com.ftiger.www.game.routers.resultVO.room.RoomConditionVO;
import com.ftiger.www.game.routers.resultVO.room.UserConditionVO;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 宋旭源
 */
@Service
public class RoomService {

  @Autowired
  private RoomRepository roomRepository;

  private RoomInfoDO getIdleEoom() {
    // 查询第一个人数状态为等待切人数不满的房间
    RoomInfoDO roomInfoDO = null;
    List<RoomInfoDO> roomInfoDOList =
        roomRepository.findAllByStatus(StatusConst.ROOM_STATUS_WAIT + "");
    if (!ListUtil.isEmpty(roomInfoDOList)) {
      // 找到有位置的房间
      roomInfoDOList = roomInfoDOList.stream().filter(e -> e.getUserLen() < 3).limit(1)
          .collect(Collectors.toList());
      if (ListUtil.isNotEmpty(roomInfoDOList)) {
        // 返回有位置的第一个房间
        roomInfoDO = roomInfoDOList.get(0);
      }
    }

    // 没有空余房间，则创建新房间
    if (roomInfoDO == null) {
      roomInfoDO = RoomFactory.createRoom();
    }

    return roomInfoDO;
  }

  public synchronized RoomConditionVO joinRoom(UserRedisDO userRedisDO) {
    RoomConditionVO roomConditionVO = new RoomConditionVO();
    RoomInfoDO roomInfoDO = getIdleEoom();
    Integer seat = null;
    Map<Integer, UserRoomInfo> seatMap = roomInfoDO.getSeatMap();
    Set<Integer> keys = seatMap.keySet();
    for (Integer key : keys) {
      UserRoomInfo userRoomInfo = seatMap.get(key);
      if (userRoomInfo == null) {
        seat = key;
        break;
      }
    }
    UserRoomInfo userRoomInfo = new UserRoomInfo();
    BeanUtils.copyProperties(userRedisDO, userRoomInfo);
    userRoomInfo.setStatus(StatusConst.USER_ROOM_STATUS_WAIT);
    roomConditionVO.setOtherUsers(getGames(roomInfoDO));
    seatMap.put(seat, userRoomInfo);


    roomConditionVO.setSeat(seat);
    return roomConditionVO;
  }

  public List<UserConditionVO> getGames(RoomInfoDO roomInfoDO) {
    List<UserConditionVO> gamers = Lists.newArrayList();
    roomInfoDO.getSeatMap().forEach((k, v) -> {
      UserConditionVO userConditionVO = new UserConditionVO();
      BeanUtils.copyProperties(v, userConditionVO);
      gamers.add(userConditionVO);
    });
    return gamers;
  }
}
