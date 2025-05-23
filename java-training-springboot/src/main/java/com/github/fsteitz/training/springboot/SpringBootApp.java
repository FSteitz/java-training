/*
 * Copyright 2025 Florian Steitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.fsteitz.training.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * For Bootstrapping the Spring Boot application.
 *
 * @author Florian Steitz
 */
@SpringBootApplication
public class SpringBootApp {

   /**
    * Registers a custom {@link Banner} and then starts the Spring Boot application.
    */
   public static void main(String[] args) {
      SpringApplication springApplication = new SpringApplication(SpringBootApp.class);
      springApplication.setBanner(new SpringBootBanner());
      springApplication.run(args);
   }
}