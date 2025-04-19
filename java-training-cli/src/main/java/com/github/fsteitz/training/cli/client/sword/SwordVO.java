package com.github.fsteitz.training.cli.client.sword;

public record SwordVO(String name, int damage, boolean magical) {

   public SwordAttributesVO attributes() {
      return new SwordAttributesVO(damage, magical);
   }
}