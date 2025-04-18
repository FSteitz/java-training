package com.github.fsteitz.training.springboot;

import com.github.fsteitz.training.common.JsonUtil;
import com.github.fsteitz.training.springboot.greeting.Greeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootApp {

   public static void main(String[] args) {
      SpringApplication.run(SpringBootApp.class, args);
   }

   @RestController
   public static class GreetingController {

      @GetMapping(value = "/greet", produces = MediaType.APPLICATION_JSON_VALUE)
      public String greet() {
         return JsonUtil.toJson(new Greeting("Welcome to the training!"));
      }
   }
}