package com.ftiger.www.common.factory;

import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author 宋旭源
 */
public class ChannelGroupFactory {

    public static DefaultChannelGroup createChannelGroup(String name){
        return new DefaultChannelGroup(name,GlobalEventExecutor.INSTANCE);
    }
}
