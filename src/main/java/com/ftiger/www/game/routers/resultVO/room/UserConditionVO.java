package com.ftiger.www.game.routers.resultVO.room;

import java.util.List;

/**
 * @author 宋旭源
 */
public class UserConditionVO {
  private Integer seat;
  private Long id;
  private Integer status;
  private List<Integer> pukers;
  private String avatar;

  public Integer getSeat() {
    return seat;
  }

  public void setSeat(Integer seat) {
    this.seat = seat;
  }

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
        return "UserConditionVO{" +
                "seat=" + seat +
                ", id=" + id +
                ", status=" + status +
                ", pukers=" + pukers +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
