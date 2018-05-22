package com.ftiger.www.game.redis.obj;

import com.ftiger.www.common.contant.StatusConst;
import com.ftiger.www.common.entity.UserRoomInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 宋旭源
 */
@RedisHash("room")
public class RoomInfoDO {
  @Id
  private Integer id;
  private String channelId;
  /**
   * 状态，
   */
  private Integer status;
  private Integer userLen;
  private Map<Integer, UserRoomInfo> seatMap;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getChannelId() {
    return channelId;
  }

  public void setChannelId(String channelId) {
    this.channelId = channelId;
  }

  public Map<Integer, UserRoomInfo> getSeatMap() {
    return seatMap;
  }

  public void setSeatMap(Map<Integer, UserRoomInfo> seatMap) {
    this.seatMap = seatMap;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Integer getUserLen() {
    return userLen;
  }

  public void setUserLen(Integer userLen) {
    this.userLen = userLen;
  }

  @Override
  public String toString() {
    return "RoomInfoDO{" + "id=" + id + ", channelId='" + channelId + '\'' + ", status=" + status
        + ", userLen=" + userLen + ", seatMap=" + seatMap + '}';
  }
}
