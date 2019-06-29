package com.li.zuul.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 */

@ConfigurationProperties(prefix = "zuul.filter")
@Data
public class FilterConfiguration {
  private String root;
  private Integer interval;
}
