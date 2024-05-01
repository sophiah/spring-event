package com.sophiah.springexample.demo.dataObject;

import lombok.Data;

@Data
public class User {
    private String login;
    private String name;
  
    @Override
    public String toString() {
      return "User [login=" + login + ", name=" + name + "]";
    } 
}
