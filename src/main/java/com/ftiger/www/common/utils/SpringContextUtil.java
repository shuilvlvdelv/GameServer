package com.ftiger.www.common.utils;

import org.springframework.context.ApplicationContext;

public class SpringContextUtil {

    private static ApplicationContext applicationContext = null;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static <T>T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }

    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }
}
