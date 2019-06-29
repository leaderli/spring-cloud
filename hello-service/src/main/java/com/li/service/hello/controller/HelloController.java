package com.li.service.hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class HelloController {
  @Value("${server.port}")
  int port;

  @RequestMapping("/hello/{id}")
  public String helloById(@PathVariable("id") Integer id) throws InterruptedException {
    log.info("cache hello " + id);
    return "hello" + id;
  }

  @RequestMapping("/hello/ids/{ids}")
  public List<String> helloByIds(@PathVariable("ids") String ids) throws InterruptedException {
    log.info("ids " + ids);
    return Arrays.stream(ids.split(",")).map(x -> "hello" + x).collect(Collectors.toList());
  }

  @RequestMapping("/hello")
  public String index() throws InterruptedException {
    int sleepTime = new Random().nextInt(3000);
    Thread.sleep(sleepTime);
    log.info("sleepTime:" + sleepTime + " port:" + port);
    return "hello";
  }
}
