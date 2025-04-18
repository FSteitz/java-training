package com.github.fsteitz.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApp {

   public static void main(String[] args) {
      SpringApplication.run(SpringBootApp.class, args);
   }

   @RestController
   public static class GreetingController {

      @GetMapping("/greet")
      public String greet() {
         return "Welcome to the training!";
      }
   }
}