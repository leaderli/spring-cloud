package com.li.shorty;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class Decare {
  public void run(String[] args) {
    ArrayList<List<String>> planar = new ArrayList<>();
    for (String arg : args) {
      char[] chars = arg.toCharArray();
      List<String> element = new ArrayList<>();
      for (char c : arg.toCharArray()) {
        element.add(c + "");
      }
    }
  }

}
