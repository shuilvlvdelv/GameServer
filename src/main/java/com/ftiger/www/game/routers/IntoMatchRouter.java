package com.ftiger.www.game.routers;

import com.ftiger.www.common.annotation.Router;
import com.ftiger.www.common.entity.ChannelContext;
import com.ftiger.www.common.router.BaseRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Router(code = "intoMatch")
public class IntoMatchRouter implements BaseRouter {

  @Override
  public void exec(ChannelContext channelContext) {

  }
}
