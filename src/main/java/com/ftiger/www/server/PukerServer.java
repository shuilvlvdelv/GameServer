package com.ftiger.www.server;

import com.ftiger.www.common.pipeline.ChannelServerInitializer;
import com.ftiger.www.common.utils.ThreadPoolUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author soulxy
 * @version \$Id: ${FILE.name}, v 0.1 2017年08月03 下午4:22 soulxy Exp $
 */
@Component
public class PukerServer implements InitializingBean, DisposableBean {
  private static Logger logger = LoggerFactory.getLogger(PukerServer.class);

  @Autowired
  private ChannelServerInitializer channelServerInitializer;

  @Value("${game.server.port}")
  private Integer gameServerPort;

  private static EventLoopGroup bossGroup = null;
  private static EventLoopGroup workerGroup = null;

  public void bind() throws Exception {
    Runnable runnable = () -> {
      bossGroup = new NioEventLoopGroup();
      workerGroup = new NioEventLoopGroup();

      ServerBootstrap b = new ServerBootstrap();
      b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
          .option(ChannelOption.SO_BACKLOG, 1024).childHandler(channelServerInitializer);
      ChannelFuture future = null;
      try {
        future = b.bind(gameServerPort).sync();
        future.channel().closeFuture().sync();
      } catch (InterruptedException e) {
        logger.warn("pukerServer star failed,error:{}", e);
      }
    };
    ThreadPoolUtil.run(runnable);
  }

  @Override
  public void destroy() throws Exception {
    bossGroup.shutdownGracefully();
    workerGroup.shutdownGracefully();
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    logger.info("----------開始启动ws服务----------");
    bind();
    logger.info("----------已启动ws服务----------");
  }
}
