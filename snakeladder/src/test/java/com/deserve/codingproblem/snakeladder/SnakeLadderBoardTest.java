package com.deserve.codingproblem.snakeladder;

import com.deserve.codingproblem.snakeladder.dices.NormalDice;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnakeLadderBoardTest {

    @Test
    public void moveAhead() {
      SnakeLadderBoard snakeLadderBoard = new SnakeLadderBoard();
      assertEquals(0, snakeLadderBoard.getCurrentPosition());
      snakeLadderBoard.moveAhead(5);
      assertEquals(5, snakeLadderBoard.getCurrentPosition());
      snakeLadderBoard.moveAhead(2);
      assertEquals(7, snakeLadderBoard.getCurrentPosition());
    }

    @Test
    public void hasWon() {
      SnakeLadderBoard snakeLadderBoard = new SnakeLadderBoard(1, 10);
      snakeLadderBoard.moveAhead(4);
      assertFalse(snakeLadderBoard.hasWon());
      snakeLadderBoard.moveAhead(3);
      assertFalse(snakeLadderBoard.hasWon());
      //Current position is 8 and final position 10. So game is complete only when dice throws exactly 2
      snakeLadderBoard.moveAhead(4);
      assertFalse(snakeLadderBoard.hasWon());
      snakeLadderBoard.moveAhead(2);
      assertTrue(snakeLadderBoard.hasWon());
    }

    @Test
    public void getCurrentPosition() {
    }
}
