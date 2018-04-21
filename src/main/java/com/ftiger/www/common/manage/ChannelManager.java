package com.ftiger.www.common.manage;

import com.google.common.collect.Maps;
import io.netty.channel.Channel;

import java.util.Map;

public class ChannelManager {
    private static final Map<String,Channel> CHANNEL_MAP = Maps.newHashMap();

    public void put(String key,Channel channel){
        CHANNEL_MAP.put(key,channel);
    }

    public Channel get(String key){
        return CHANNEL_MAP.get(key);
    }
}
