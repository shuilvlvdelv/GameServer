package com.ftiger.www.server;

import com.ftiger.www.common.utils.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 宋旭源
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.ftiger.www"})
public class Application {
  public static void main(String[] args) {
    ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    SpringContextUtil.setApplicationContext(applicationContext);
  }
}
