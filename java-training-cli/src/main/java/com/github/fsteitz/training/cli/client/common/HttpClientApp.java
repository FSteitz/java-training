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

/**
 * Interface that shall be implemented by all CLI applications that retrieve data from REST endpoints and generate
 * console outputs based on their responses.
 *
 * @author Florian Steitz
 */
public interface HttpClientApp {

   /**
    * Generates the console output based on a response of a REST endpoint.
    */
   void printCliOutput();

   /**
    * Returns the path of a REST method (including the base path of its REST controller). It must not return a full URL!
    */
   String getRemoteMethodPath();
}
