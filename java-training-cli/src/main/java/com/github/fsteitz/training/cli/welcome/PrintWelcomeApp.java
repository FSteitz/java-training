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
package com.github.fsteitz.training.cli.welcome;

import com.github.fsteitz.training.cli.common.app.CliApp;
import com.github.fsteitz.training.cli.common.util.CliOutputUtil;

/**
 * A simple CLI application that only outputs text.
 *
 * @author Florian Steitz
 */
public class PrintWelcomeApp implements CliApp {

   /**
    * Runs the app.
    */
   public static void main(String[] args) {
      new PrintWelcomeApp().printCliOutput();
   }

   /**
    * Produces an RPG like console output based on the world of The Witcher.
    */
   @Override
   public void printCliOutput() {
      CliOutputUtil.printSeparatorLine();
      System.out.println("Welcome to the sword training!");
      CliOutputUtil.printSeparatorLine();
      System.out.println("My name is Geralt of Rivia.");
      System.out.println("Draw your sword, Ciri!");
   }
}
