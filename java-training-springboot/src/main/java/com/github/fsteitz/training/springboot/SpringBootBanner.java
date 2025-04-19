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
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * Console / log banner für the Spring Boot application.
 *
 * @author Florian Steitz
 */
final class SpringBootBanner implements Banner {

   SpringBootBanner() {
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
      out.println(" _______  _______ _________ _______ __________________ _______   _________ _______  _______ _________ _       _________ _        _______ ");
      out.println("(  ____ \\(  ____ \\\\__   __/(  ____ \\\\__   __/\\__   __// ___   )  \\__   __/(  ____ )(  ___  )\\__   __/( (    /|\\__   __/( (    /|(  ____ \\");
      out.println("| (    \\/| (    \\/   ) (   | (    \\/   ) (      ) (   \\/   )  |     ) (   | (    )|| (   ) |   ) (   |  \\  ( |   ) (   |  \\  ( || (    \\/");
      out.println("| (__    | (_____    | |   | (__       | |      | |       /   )     | |   | (____)|| (___) |   | |   |   \\ | |   | |   |   \\ | || |      ");
      out.println("|  __)   (_____  )   | |   |  __)      | |      | |      /   /      | |   |     __)|  ___  |   | |   | (\\ \\) |   | |   | (\\ \\) || | ____ ");
      out.println("| (            ) |   | |   | (         | |      | |     /   /       | |   | (\\ (   | (   ) |   | |   | | \\   |   | |   | | \\   || | \\_  )");
      out.println("| )      /\\____) |   | |   | (____/\\___) (___   | |    /   (_/\\     | |   | ) \\ \\__| )   ( |___) (___| )  \\  |___) (___| )  \\  || (___) |");
      out.println("|/       \\_______)   )_(   (_______/\\_______/   )_(   (_______/     )_(   |/   \\__/|/     \\|\\_______/|/    )_)\\_______/|/    )_)(_______)");
   }
}
