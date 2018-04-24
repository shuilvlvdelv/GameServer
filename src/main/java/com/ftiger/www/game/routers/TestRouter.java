package com.ftiger.www.game.routers;

import com.alibaba.fastjson.JSON;
import com.ftiger.www.common.annotation.Router;
import com.ftiger.www.common.entity.ChannelContext;
import com.ftiger.www.common.router.BaseRouter;
import com.ftiger.www.game.mysql.entity.User;
import com.ftiger.www.game.mysql.entity.UserKey;
import com.ftiger.www.game.mysql.mapper.UserMapper;
import com.ftiger.www.game.redis.dao.UserRepository;
import com.ftiger.www.game.redis.obj.UserRedisDO;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

@Router(code = "test")
@Component
public class TestRouter implements BaseRouter {
  private static Logger logger = LoggerFactory.getLogger(TestRouter.class);

  @Autowired
  private UserMapper userMapper;

  @Override
  public void exec(ChannelContext channelContext) {
    User user = new User();
    user.setNickName("test3");
    user.setAvatar("test3");
    user.setGold(1000L);
    userMapper.insert(user);
    UserKey userKey = new UserKey();
    userKey.setId(user.getId());
    User user1 = userMapper.selectByPrimaryKey(userKey);
    logger.info("user:{}", JSON.toJSONString(user));
  }
}
