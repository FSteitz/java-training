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
package com.github.fsteitz.training.cli.client.common.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public final class TrainingHttpClient {

   private static final String BASE_ENDPOINT = "http://localhost:8080/";

   private final String endpoint;

   public TrainingHttpClient(String controllerPath) {
      Objects.requireNonNull(controllerPath, "controller path must not be null");
      this.endpoint = BASE_ENDPOINT + controllerPath;
   }

   public  <T> void receive(Function<String, T> bodyParser, Consumer<T> responseReceiver) {
      Objects.requireNonNull(responseReceiver, "body parser must not be null");
      Objects.requireNonNull(responseReceiver, "response receiver must not be null");

      try (HttpClient client = HttpClient.newHttpClient()) {
         final HttpRequest request = HttpRequest.newBuilder()
               .uri(URI.create(endpoint))
               .GET()
               .build();

         // Send the request and handle the response
         client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
               .thenApply(HttpResponse::body)
               .thenApply(bodyParser)
               .thenAccept(responseReceiver)
               .join(); // Wait for the completion
      }
   }
}
