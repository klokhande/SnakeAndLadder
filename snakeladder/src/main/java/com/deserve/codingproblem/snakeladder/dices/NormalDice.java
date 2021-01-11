package com.deserve.codingproblem.snakeladder.dices;

import java.util.Random;

public class NormalDice implements Dice {
  public int throwDice() {
    Random random = new Random();
    return random.nextInt(6)+1;
  }
}
