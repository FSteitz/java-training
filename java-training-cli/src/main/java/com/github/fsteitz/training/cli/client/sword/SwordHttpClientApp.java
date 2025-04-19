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
import com.github.fsteitz.training.cli.client.common.AbstractHttpClientApp;
import com.github.fsteitz.training.common.JsonUtil;

import java.util.List;

/**
 * A simple CLI application retrieving all {@link SwordVO sword objects} of a REST endpoint and generating console
 * output based on it.
 *
 * @author Florian Steitz
 */
public class SwordHttpClientApp extends AbstractHttpClientApp<List<SwordVO>> {

   /**
    * Runs the app.
    */
   public static void main(String[] args) {
      new SwordHttpClientApp().printCliOutput();
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String getRemoteMethodPath() {
      return "sword/list";
   }

   /**
    * Produces an RPG like console output based on the provided list of swords.
    */
   @Override
   protected void onResponseReceived(List<SwordVO> swordList) {
      System.out.println("I, the great swordmaster of the northern kingdoms, shall carry the following swords:");

      for (SwordVO sword : swordList) {
         System.out.printf("- %s (%s)%n", sword.name(), JsonUtil.toJson(sword.attributes()));
      }

      printCliSeparatorLine();
      System.out.println("I now embark on my mission!");
   }

   /**
    * {@inheritDoc}
    */
   @Override
   protected List<SwordVO> parseResponseBody(String json) {
      return JsonUtil.fromJsonAsList(json, new TypeReference<>() {
      });
   }
}
