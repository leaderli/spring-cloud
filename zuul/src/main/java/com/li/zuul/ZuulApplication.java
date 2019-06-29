package com.li.zuul;

import com.li.zuul.config.FilterConfiguration;
import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableZuulProxy
@EnableConfigurationProperties(FilterConfiguration.class)
@SpringBootApplication
@RefreshScope
@RestController
public class ZuulApplication {

  @Value("${from}")
  private String from;
  @RequestMapping("/from")
  public String from(){
    return this.from;
  }
  public static void main(String[] args) {
    //SpringApplication.run(ZuulApplication.class, args);
    new SpringApplicationBuilder(ZuulApplication.class).web(WebApplicationType.SERVLET).run(args);
  }

  @Bean
  public FilterLoader filterLoader(FilterConfiguration filterConfiguration){
    FilterLoader filterLoader= FilterLoader.getInstance();
    filterLoader.setCompiler(new GroovyCompiler());
    FilterFileManager.setFilenameFilter(new GroovyFileFilter());
    try {
      FilterFileManager.init(filterConfiguration.getInterval(), filterConfiguration.getRoot()+"/pre");
    } catch (Exception e) {
      throw new RuntimeException();
    }
    return filterLoader;
  }
}
