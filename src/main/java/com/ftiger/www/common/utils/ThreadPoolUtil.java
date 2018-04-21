package com.ftiger.www.common.utils;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtil {
  private static final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
  private static final BasicThreadFactory basicThreadFactory =
      new BasicThreadFactory.Builder().namingPattern("common-pool").daemon(true).build();
  private static final ThreadPoolExecutor pool =
      new ThreadPoolExecutor(5, 20, 10, TimeUnit.SECONDS, queue, basicThreadFactory);

  public static void run(Runnable runnable) {
    pool.execute(runnable);
  }
}
