package com.li.ribbon.service;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

public class CacheCommand extends HystrixCommand<String> {
  RestTemplate restTemplate;
  private long id;

  public CacheCommand(Setter setter,RestTemplate restTemplate, long id) {
    super(setter);
    this.id = id;
    this.restTemplate = restTemplate;
  }

  @Override
  protected String getCacheKey() {
    return String.valueOf(id);
  }

  @Override
  protected String run() throws Exception {
    return restTemplate.getForEntity("http://HELLO-SERVICE/hello/{id}", String.class, id).getBody();
  }

  @Override
  protected String getFallback() {
    return "error";
  }
}
