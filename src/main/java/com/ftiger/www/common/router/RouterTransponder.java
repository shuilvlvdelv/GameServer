package com.ftiger.www.common.router;

import com.ftiger.www.common.entity.ChannelContext;

public class RouterTransponder {

    public static void push(String code){
        BaseRouter baseRouter = RouterRegister.get(code);
        ChannelContext channelContext = new ChannelContext();
        channelContext.setChannelId("111111");
        baseRouter.exec(channelContext);
    }
}
