package com.ftiger.www.common.init;

import com.ftiger.www.common.router.RouterTransponder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author 宋旭源
 */
@Component
public class ApplicatinInit implements InitializingBean {
    private static Logger logger = LoggerFactory.getLogger(ApplicatinInit.class);

  @Override
  public void afterPropertiesSet() throws Exception {
    Properties properties = PropertiesLoaderUtils.loadAllProperties("routers.properties");
    RouterTransponder.init(properties);
    logger.info("----------加载路由映射完成----------，\n{}",properties);
  }
}
