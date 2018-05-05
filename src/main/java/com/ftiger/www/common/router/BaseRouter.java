package com.ftiger.www.common.router;

import com.ftiger.www.game.redis.obj.UserRedisDO;

import java.util.Map;

/**
 * @author 宋旭源
 */
public interface BaseRouter {

    void exec(UserRedisDO channelContext, Map<String,Object> msg);
}
