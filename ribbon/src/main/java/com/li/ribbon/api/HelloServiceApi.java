package com.li.ribbon.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface HelloServiceApi {
  @RequestMapping("/hello")
  String hello();

  @RequestMapping("/hello/{id}")
  String helloById(@PathVariable("id") Integer id) throws InterruptedException;
}
