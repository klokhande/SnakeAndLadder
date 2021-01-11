package com.deserve.codingproblem.snakeladder.dices;

import org.junit.Test;

import static org.junit.Assert.*;

public class NormalDiceTest {

    @Test
    public void throwDice() {
      NormalDice normalDice = new NormalDice();
      for(int i = 0; i < 10; i++) {
        int diceValue = normalDice.throwDice();
        assertTrue(diceValue > 0 && diceValue < 7);
      }
    }
}
