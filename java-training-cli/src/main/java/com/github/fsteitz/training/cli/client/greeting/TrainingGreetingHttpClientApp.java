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

import com.github.fsteitz.training.cli.client.common.AbstractHttpClientApp;
import com.github.fsteitz.training.common.JsonUtil;

public class TrainingGreetingHttpClientApp extends AbstractHttpClientApp<GreetingVO> {

   public static void main(String[] args) {
      new TrainingGreetingHttpClientApp().printCliOutput();
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String getRemoteMethodPath() {
      return "greeting/training";
   }

   @Override
   protected void onResponseReceived(GreetingVO greeting) {
      System.out.println(greeting.text());
      printCliSeparatorLine();
      System.out.println("Thank you! I'm ready! ;-)");
      System.out.println("""
               O      O
              /|\\    /|\\
              / \\    / \\
            """);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   protected GreetingVO parseResponseBody(String json) {
      return JsonUtil.fromJson(json, GreetingVO.class);
   }
}
