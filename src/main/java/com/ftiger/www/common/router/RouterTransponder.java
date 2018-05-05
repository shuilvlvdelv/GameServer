package com.ftiger.www.common.router;

import com.alibaba.fastjson.JSON;
import com.ftiger.www.common.utils.SpringContextUtil;
import com.ftiger.www.game.protocol.GameServerOuterClass;
import com.ftiger.www.game.redis.dao.UserRepository;
import com.ftiger.www.game.redis.obj.UserRedisDO;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;

public class RouterTransponder {
    private static Logger logger = LoggerFactory.getLogger(RouterTransponder.class);

    private static Properties routers = null;

    public static void push(String channelId, GameServerOuterClass.GameServer gameServer){
        //获取路由类
        String strCode = routers.getProperty(gameServer.getCode()+ "");
        BaseRouter baseRouter = RouterRegister.get(strCode);

        //获取用户上下文
        UserRedisDO channelContext = getRedisDo(gameServer.getId() + "");
        channelContext.setChannelId(channelId);
        Map<String,Object> msg = Maps.newHashMap();

        //解析请求数据
        String context = gameServer.getContext();
        try {
            msg = JSON.parseObject(context,Map.class);
        }catch (Exception e){
            logger.error("parse json data failed!context:{}",context);
        }
        baseRouter.exec(channelContext,msg);
    }

    public static UserRedisDO getRedisDo(String id){
        UserRepository userRepository = SpringContextUtil.getBean(UserRepository.class);
        return userRepository.findById(id).get();
    }

    public static void init(Properties routers){
        RouterTransponder.routers = routers;
    }
}
