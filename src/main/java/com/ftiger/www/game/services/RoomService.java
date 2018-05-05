package com.ftiger.www.game.services;

import com.ftiger.www.common.contant.StatusConst;
import com.ftiger.www.common.factory.RoomFactory;
import com.ftiger.www.common.utils.ListUtil;
import com.ftiger.www.game.redis.dao.RoomRepository;
import com.ftiger.www.game.redis.obj.RoomInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 宋旭源
 */
@Service
public class RoomService{

  @Autowired
  private RoomRepository roomRepository;

  public RoomInfoDO getIdleEoom(){
    //查询第一个人数状态为等待切人数不满的房间
      RoomInfoDO roomInfoDO = null;
      List<RoomInfoDO> roomInfoDOList = roomRepository.findAllByStatus(StatusConst.ROOM_STATUS_WAIT+"");
      if (!ListUtil.isEmpty(roomInfoDOList)){
          roomInfoDOList = roomInfoDOList.stream().filter(e -> e.getUserLen() < 3).limit(1).collect(Collectors.toList());
          roomInfoDO = roomInfoDOList.get(0);
      }

      //没有空余房间，则创建新房间
      if (roomInfoDO == null){
        roomInfoDO = RoomFactory.createRoom();
      }

      return roomInfoDO;
  }
}
