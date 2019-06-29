package com.li.ribbon.controller;

import com.li.ribbon.api.HelloServiceApi;
import com.li.ribbon.service.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloFeignController implements HelloServiceApi {
  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  HelloFeignService feignService;


  @Override
  public String hello() {
    return feignService.hello();
  }

  @Override
  @RequestMapping("/feign-consumer/{id}")
  public String helloById(@PathVariable("id") Integer id) throws InterruptedException{
    return feignService.helloById(id);
  }
}
