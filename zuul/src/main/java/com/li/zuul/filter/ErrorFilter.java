package com.li.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ErrorFilter extends ZuulFilter {
  @Override
  public String filterType() {
    return "error";
  }

  @Override
  public int filterOrder() {
    return -1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    Throwable throwable = ctx.getThrowable().getCause();
    log.error("this is a ErrorFilter : {}", throwable.getMessage());
    ctx.setThrowable(throwable);
    return null;
  }

}
