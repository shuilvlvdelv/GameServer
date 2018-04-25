package com.ftiger.www.common.manage;

import com.google.common.collect.Maps;
import io.netty.channel.group.ChannelGroup;
import java.util.Map;

public class ChannelGroupMannger {
  private static final Map<String, ChannelGroup> CHANNEL_GROUP_MAP = Maps.newHashMap();

  public static void put(String key, ChannelGroup channelGroup) {
    CHANNEL_GROUP_MAP.put(key, channelGroup);
  }

  public static ChannelGroup get(String key) {
    return CHANNEL_GROUP_MAP.get(key);
  }
}
