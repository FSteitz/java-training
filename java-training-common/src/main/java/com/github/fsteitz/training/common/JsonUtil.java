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
package com.github.fsteitz.training.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public final class JsonUtil {

   private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

   private JsonUtil() {
      // Util class
   }

   public static String toJson(Object value) {
      try {
         return OBJECT_MAPPER.writeValueAsString(value);
      } catch (JsonProcessingException e) {
         throw new TrainingException("Object could not be serialized as JSON", e);
      }
   }

   public static <T> T fromJson(String json, Class<T> valueType) {
      try {
         return OBJECT_MAPPER.readValue(json, valueType);
      } catch (JsonProcessingException e) {
         throw new TrainingException("JSON could not be parsed", e);
      }
   }

   public static <T> List<T> fromJsonAsList(String json, TypeReference<List<T>> valueTypeReference) {
      try {
         return OBJECT_MAPPER.readValue(json, valueTypeReference);
      } catch (JsonProcessingException e) {
         throw new TrainingException("JSON could not be parsed", e);
      }
   }
}
