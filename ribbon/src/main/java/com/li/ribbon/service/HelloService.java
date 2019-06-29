package com.li.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Future;

@Service
@Slf4j
public class HelloService {
  @Autowired
  RestTemplate restTemplate;

  @CacheResult
  @HystrixCollapser(batchMethod = "findAll", collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "1000")},scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL)
  public Future<String> cacheService(Long id) {
    return  null;
  }

  @HystrixCommand
  public List<String> findAll(List<Long> ids) {
    return restTemplate.getForObject("http://HELLO-SERVICE/hello/ids/{ids}", List.class, StringUtils.join(ids, ","));
  }

  public String helloFallback() {
    return "error";
  }

  @HystrixCommand(fallbackMethod = "helloFallback")
  public String helloService() {
    long start = System.currentTimeMillis();
    long end = System.currentTimeMillis();
    log.info("Spend time : " + (end - start));
    return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
  }

  @CacheRemove(commandKey = "id")
  @HystrixCommand
  public String removeCacheService(Long id) {
    log.info("remove cache " + id);
    return restTemplate.getForEntity("http://HELLO-SERVICE/hello/{id}", String.class, id).getBody();
  }

}
