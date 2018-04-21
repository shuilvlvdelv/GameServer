package com.ftiger.www.game.routers;

import com.ftiger.www.common.annotation.Router;
import com.ftiger.www.common.entity.ChannelContext;
import com.ftiger.www.common.router.BaseRouter;
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
  private UserRepository userRepository;

  @Override
  public void exec(ChannelContext channelContext) {
      UserRedisDO userRedisDO = new UserRedisDO();
      userRedisDO.setChannelId("1111");
      userRedisDO.setId(1L);
      userRedisDO.setAvatar("testA");
      userRedisDO.setGold(1000L);
      userRedisDO.setNickName("testN");
      Map<String,String> groupMap = Maps.newHashMap();
      groupMap.put("roomGroupId","222");
      userRedisDO.setGroupMap(groupMap);
      userRepository.save(userRedisDO);
      UserRedisDO result = userRepository.findById("1111").get();
      logger.info("redis.get:{}",result);
  }
}
