package com.ftiger.www.common.router;

import com.ftiger.www.common.annotation.Router;
import com.ftiger.www.server.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class RouterRegister extends ApplicationObjectSupport {
  private static Logger logger = LoggerFactory.getLogger(RouterRegister.class);
  private static final Map<String, BaseRouter> ROUTER_MAP = new HashMap<>();

  @Override
  protected void initApplicationContext(ApplicationContext context) throws BeansException {
    super.initApplicationContext(context);

    logger.info("----------开始注册路由----------");
    Map<String, Object> routerMap = context.getBeansWithAnnotation(Router.class);
    routerMap.forEach((beanName, bean) -> {
      Class clazz = bean.getClass();
      Router router = (Router) clazz.getAnnotation(Router.class);
      if (bean instanceof BaseRouter && router != null) {
        String code = router.code();
        if (ROUTER_MAP.keySet().contains(code)) {
          logger.error("Router code has exits. code = {}", code);
          throw new RuntimeException("Router code has exits. code = " + code);
        }
        ROUTER_MAP.put(code, (BaseRouter) bean);
        logger.info("register routers,code:{}", code);
      }
    });
    logger.info("----------注册路由完毕----------");
  }

  public static BaseRouter get(String code) {
    return ROUTER_MAP.get(code);
  }
}
