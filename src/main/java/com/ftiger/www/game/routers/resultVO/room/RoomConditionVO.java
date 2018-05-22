package com.ftiger.www.game.routers.resultVO.room;

import com.ftiger.www.common.entity.UserRoomInfo;

import java.util.List;

/**
 * 返回房间状况信息
 * @author 宋旭源
 */
public class RoomConditionVO {

    /**
     * 自己的座位号
     */
    private Integer seat;

    /**
     * 其他玩家信息
     */
    private List<UserConditionVO> otherUsers;

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public List<UserConditionVO> getOtherUsers() {
        return otherUsers;
    }

    public void setOtherUsers(List<UserConditionVO> otherUsers) {
        this.otherUsers = otherUsers;
    }

    @Override
    public String toString() {
        return "RoomConditionVO{" +
                "seat=" + seat +
                ", otherUsers=" + otherUsers +
                '}';
    }
}
