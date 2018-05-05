package com.ftiger.www.common.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.util.List;

/**
 * @author 宋旭源
 */
public class UserRoomInfo {
  private Long id;
  private Integer status;
  private List<Integer> pukers;
  private String avatar;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public List<Integer> getPukers() {
    return pukers;
  }

  public void setPukers(List<Integer> pukers) {
    this.pukers = pukers;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  @Override
  public String toString() {
    return "UserRoomInfo{" + "id='" + id + '\'' + ", status='" + status + '\'' + ", pukers="
        + pukers + ", avatar='" + avatar + '\'' + '}';
  }
}
