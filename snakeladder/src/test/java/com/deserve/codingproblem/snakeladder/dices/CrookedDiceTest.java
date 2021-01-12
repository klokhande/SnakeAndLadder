package com.deserve.codingproblem.snakeladder.dices;

import org.junit.Test;

import static org.junit.Assert.*;

public class CrookedDiceTest {

    @Test
    public void throwDice() {
      CrookedDice dice = new CrookedDice();
      for(int i=0; i<10; i++) {
        int value = dice.throwDice();
        assertEquals(0, value % 2);
      }
    }
}
