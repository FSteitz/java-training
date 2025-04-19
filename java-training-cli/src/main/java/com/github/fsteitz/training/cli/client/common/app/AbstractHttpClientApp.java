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

/**
 * Default implementation of {@link HttpClientApp} that shall be extended by all CLI applications that retrieve data
 * from REST endpoints and generate console outputs based on their responses.
 *
 * @author Florian Steitz
 */
public abstract class AbstractHttpClientApp<V> implements HttpClientApp {

   /**
    * {@inheritDoc}
    */
   @Override
   public void printCliOutput() {
      printCliSeparatorLine();
      new DefaultTrainingHttpClient(getRemoteMethodPath()).receive(this::parseResponseBody, this::onResponseReceived);
   }

   /**
    * Outputs a single line that is supposed to visually separate other console outputs.
    */
   protected void printCliSeparatorLine() {
      System.out.println("==================================================");
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
