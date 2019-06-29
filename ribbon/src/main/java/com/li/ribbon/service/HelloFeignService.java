package com.li.ribbon.service;

import com.li.ribbon.api.HelloServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("hello-service")
public interface HelloFeignService extends HelloServiceApi {

}
