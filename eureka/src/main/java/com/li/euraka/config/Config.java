package com.li.euraka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Config {
  @Value("${spring.application.name}")
  String name;
 @Value("${server.port}")
  int port;
  @PostConstruct
  public void init(){
    System.out.println("---------------------------------------------------------"+name+" "+port);
  }
}
