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
package com.github.fsteitz.training.springboot.sword;

/**
 * Represents a named sword with RPG attributes.
 *
 * @param name    The name of the sword
 * @param damage  The damage the sword inflicts
 * @param magical Whether the sword is infused with magic
 * @author Florian Steitz
 */
public record Sword(String name, int damage, boolean magical) {
}
