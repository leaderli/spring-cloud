package com.li.ribbon.controller;

import com.li.ribbon.service.HelloService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@Slf4j
public class CacheController {
  @Autowired
  HelloService helloService;

  @RequestMapping("/cache/{id}")
  public String consumer(@PathVariable("id") Long id) throws ExecutionException, InterruptedException {
    HystrixRequestContext.initializeContext();
    log.info(helloService.cacheService(id).get());
    log.info(helloService.removeCacheService(id));
    return helloService.cacheService(id).get();
  }


}
