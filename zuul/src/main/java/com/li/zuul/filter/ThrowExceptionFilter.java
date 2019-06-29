package com.li.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ThrowExceptionFilter extends ZuulFilter {
  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return false;
  }

  @Override
  public Object run() {
    log.info("this is a pre filter ,it will throw a RuntimeException");
    RequestContext ctx = RequestContext.getCurrentContext();
    doSomething();
    log.warn("this is a pre filter catch ,it will not handler the exception ,it will delivered to {}", ErrorFilter.class.getName());
    return null;
  }

  private void doSomething() {
    throw new RuntimeException("Exist some errors");
  }
}
