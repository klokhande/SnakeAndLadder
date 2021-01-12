package com.deserve.codingproblem.snakeladder;

import com.deserve.codingproblem.snakeladder.dices.NormalDice;
import com.deserve.codingproblem.snakeladder.exceptions.InvalidDataException;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class SnakeLadderBoardTest {

    @Test
    public void moveAhead() {
      SnakeLadderBoard snakeLadderBoard;
      HashMap<Integer, Integer> snakes = new HashMap<>();
      snakes.put(10, 3);
      snakes.put(15, 7);
      try {
        snakeLadderBoard = new SnakeLadderBoard(snakes);
        assertEquals(0, snakeLadderBoard.getCurrentPosition());
        snakeLadderBoard.moveAhead(5);
        assertEquals(5, snakeLadderBoard.getCurrentPosition());
        snakeLadderBoard.moveAhead(2);
        assertEquals(7, snakeLadderBoard.getCurrentPosition());
        snakeLadderBoard.moveAhead(3);
        //This would take to position 10 where there is a snake which takes to position 3
        assertEquals(3, snakeLadderBoard.getCurrentPosition());
        snakeLadderBoard.moveAhead(6);
        assertEquals(9, snakeLadderBoard.getCurrentPosition());
        snakeLadderBoard.moveAhead(6);
        //This would take to position 15 where there is a snake which takes to position 7
        assertEquals(7, snakeLadderBoard.getCurrentPosition());
      } catch (InvalidDataException e) {
        fail(e.getMessage());
      }

      try {
        //This should throw exception
        snakeLadderBoard = new SnakeLadderBoard(-1, 100, new HashMap<>());
        fail("Validation test failed as SnakeLadderBoard is accepting negative startPosition");
      } catch (InvalidDataException e) {

      }

      try {
        //This should throw exception
        snakeLadderBoard = new SnakeLadderBoard(100, 1, new HashMap<>());
        fail("Validation test failed as SnakeLadderBoard is accepting finalPosition smaller than the startPosition");
      } catch (InvalidDataException e) {

      }

      try {
        snakes.put(10, 15);
        new SnakeLadderBoard(100, 1, new HashMap<>());
        fail("Validation test failed as SnakeLadderBoard is accepting invalid snakes");
      } catch (InvalidDataException e) {

      }
    }

    @Test
    public void hasWon() {
      SnakeLadderBoard snakeLadderBoard = null;
      try {
        snakeLadderBoard = new SnakeLadderBoard(1, 10, new HashMap<>());
        snakeLadderBoard.moveAhead(4);
        assertFalse(snakeLadderBoard.hasWon());
        snakeLadderBoard.moveAhead(3);
        assertFalse(snakeLadderBoard.hasWon());
        //Current position is 8 and final position 10. So game is complete only when dice throws exactly 2
        snakeLadderBoard.moveAhead(4);
        assertFalse(snakeLadderBoard.hasWon());
        snakeLadderBoard.moveAhead(2);
        assertTrue(snakeLadderBoard.hasWon());
      } catch (InvalidDataException e) {
        fail(e.getMessage());
      }

    }

    @Test
    public void getCurrentPosition() {
    }
}
