package com.github.fsteitz.training.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
}
