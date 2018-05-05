package com.ftiger.www.game.redis.obj;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 宋旭源
 */
@RedisHash("users")
public class UserRedisDO implements Serializable {
    private String channelId;
    private Map<String,String> groupMap;
    @Id
    private Long id;
    private String nickName;
    private String avatar;
    private Long gold;
    private Map<String,Object> context;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Map<String, String> getGroupMap() {
        return groupMap;
    }

    public void setGroupMap(Map<String, String> groupMap) {
        this.groupMap = groupMap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "UserRedisDO{" +
                "channelId='" + channelId + '\'' +
                ", groupMap=" + groupMap +
                ", id=" + id +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", gold=" + gold +
                ", context=" + context +
                '}';
    }
}
