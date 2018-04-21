package com.ftiger.www.common.entity;

import java.util.Map;

public class ChannelContext {
    private String channelId;
    private Map<String,Object> channelData;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public void put(String key, Object data){
        channelData.put(key,data);
    }

    public Object getInstance(String key){
        return channelData.get(key);
    }
}
