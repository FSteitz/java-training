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
package com.github.fsteitz.training.cli.client.greeting;

import com.github.fsteitz.training.common.JsonUtil;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class GreetingHttpClientApp {

   private static final String ENDPOINT = "http://localhost:8080/greet";

   public static void main(String[] args) {
      GreetingHttpClientApp greetingHttpClientApp = new GreetingHttpClientApp();
      greetingHttpClientApp.receiveGreeting(greeting -> {
         System.out.println(greeting.text());
         System.out.println("==================================================");
         System.out.println("Thank you! I'm ready! ;-)");
         System.out.println("""
                  O      O
                 /|\\    /|\\
                 / \\    / \\
               """);
      });
   }

   private void receiveGreeting(Consumer<ClientGreeting> responseReceiver) {
      try (HttpClient client = HttpClient.newHttpClient()) {
         final HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create(ENDPOINT))
               .GET()
               .build();

         // Send the request and handle the response
         client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
               .thenApply(HttpResponse::body)
               .thenApply(this::parseGreeting)
               .thenAccept(responseReceiver)
               .join(); // Wait for the completion
      }
   }

   private ClientGreeting parseGreeting(String json) {
      return JsonUtil.fromJson(json, ClientGreeting.class);
   }
}
