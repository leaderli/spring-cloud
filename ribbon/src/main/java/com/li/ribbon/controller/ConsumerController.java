package com.li.ribbon.controller;

import com.li.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
  @Autowired
  HelloService helloService;

  @RequestMapping("/consumer")
  public String consumer() {
    return helloService.helloService();
  }
}
