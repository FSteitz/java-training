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
package com.github.fsteitz.training.cli.client.sword;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.fsteitz.training.cli.client.common.HttpClientApp;
import com.github.fsteitz.training.cli.client.common.TrainingHttpClient;
import com.github.fsteitz.training.common.JsonUtil;

import java.util.List;

public class SwordHttpClientApp implements HttpClientApp<List<SwordVO>> {

   private static final String CONTROLLER_PATH = "sword/list";

   public static void main(String[] args) {
      new SwordHttpClientApp().printCliOutput();
   }

   public void printCliOutput() {
      System.out.println("==================================================");
      new TrainingHttpClient(CONTROLLER_PATH)
            .receive(this::parseResponseBody, swordList -> {
               System.out.println("I, the great swordmaster of the northern kingdoms, shall carry the following swords:");

               for (SwordVO sword : swordList) {
                  System.out.printf("- %s (%s)%n", sword.name(), JsonUtil.toJson(sword.attributes()));
               }

               System.out.println("==================================================");
               System.out.println("I now embark on my mission!");
            });
   }

   public List<SwordVO> parseResponseBody(String json) {
      return JsonUtil.fromJsonAsList(json, new TypeReference<>() {
      });
   }
}
