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
package com.github.fsteitz.training.cli.client.common.app;

import com.github.fsteitz.training.cli.client.common.http.DefaultTrainingHttpClient;
import com.github.fsteitz.training.cli.client.common.http.TrainingHttpClient;
import com.github.fsteitz.training.cli.common.util.CliOutputUtil;

import java.util.Objects;

/**
 * Default implementation of {@link HttpClientApp} that shall be extended by all CLI applications that retrieve data
 * from REST endpoints and generate console outputs based on their responses.
 *
 * @param <V> The object(s) returned by the REST endpoint called by this app.
 * @author Florian Steitz
 */
public abstract class AbstractHttpClientApp<V> implements HttpClientApp {

   private final TrainingHttpClient httpClient;

   /**
    * Initializes this instance with the default implementation of {@link TrainingHttpClient}.
    */
   protected AbstractHttpClientApp() {
      this.httpClient = new DefaultTrainingHttpClient(getRemoteMethodPath());
   }

   /**
    * Initializes this instance with the provided implementation of {@link TrainingHttpClient}.
    */
   protected AbstractHttpClientApp(TrainingHttpClient httpClient) {
      Objects.requireNonNull(httpClient, "HTTP client must not be null");
      this.httpClient = httpClient;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void printCliOutput() {
      CliOutputUtil.printSeparatorLine();
      httpClient.receive(this::parseResponseBody, this::onResponseReceived);
   }

   /**
    * Produces the console output based on the parsed object returned by the REST endpoint.
    *
    * @see #parseResponseBody(String)
    */
   protected abstract void onResponseReceived(V value);

   /**
    * Parses the JSON body returned by the REST endpoint.
    */
   protected abstract V parseResponseBody(String json);
}
