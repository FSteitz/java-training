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
package com.github.fsteitz.training.cli.client.common;

public abstract class AbstractHttpClientApp<V> implements HttpClientApp<V> {

   @Override
   public void printCliOutput() {
      printCliSeparator();
      new TrainingHttpClient(getRemoteMethodPath()).receive(this::parseResponseBody, this::onResponseReceived);
   }

   protected void printCliSeparator() {
      System.out.println("==================================================");
   }

   protected abstract void onResponseReceived(V value);

   protected abstract V parseResponseBody(String json);
}
