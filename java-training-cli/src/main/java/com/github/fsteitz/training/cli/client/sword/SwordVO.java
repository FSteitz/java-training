package com.github.fsteitz.training.cli.client.sword;

/**
 * Represents a named sword with RPG attributes.
 *
 * @param name    The name of the sword
 * @param damage  The damage the sword inflicts
 * @param magical Whether the sword is infused with magic
 * @author Florian Steitz
 */
public record SwordVO(String name, int damage, boolean magical) {

   /**
    * Creates a new {@link SwordAttributesVO attributes object} containing only the RPG attributes of this sword.
    */
   public SwordAttributesVO attributes() {
      return new SwordAttributesVO(damage, magical);
   }
}