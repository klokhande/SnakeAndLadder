package com.deserve.codingproblem.snakeladder.dices;

import java.util.Random;

public class CrookedDice implements Dice {
  @Override
  public int throwDice() {
    Random random = new Random();
    int number = random.nextInt(6)+1;
    if(number % 2 == 0)
      return number;
    return number + 1;
  }
}
