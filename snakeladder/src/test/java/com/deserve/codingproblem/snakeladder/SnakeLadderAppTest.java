package com.deserve.codingproblem.snakeladder;

import com.deserve.codingproblem.snakeladder.dices.Dice;
import com.deserve.codingproblem.snakeladder.dices.NormalDice;
import com.deserve.codingproblem.snakeladder.models.GameResult;
import com.deserve.codingproblem.snakeladder.utils.SnakeLadderConstant;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;


public class SnakeLadderAppTest {
  @Test
  public void testPlayMethodWithNormalDice() {
    SnakeLadderApp snakeLadderApp = new SnakeLadderApp(new NormalDice(), new SnakeLadderBoard());
    String userInputs = "r\nr\nn";
    System.setIn(new ByteArrayInputStream(userInputs.getBytes()));
    GameResult result = snakeLadderApp.play();
    //There is no way game is won with just 2 turns
    Assert.assertEquals(SnakeLadderConstant.GANE_OVER_MSG, result.getMessage());
    Assert.assertEquals(2, result.getTurnsTaken());
    //Try with 10 r inputs
    snakeLadderApp = new SnakeLadderApp(new NormalDice(), new SnakeLadderBoard());
    userInputs = "r\nr\nr\nr\nr\nr\nr\nr\nr\nr\n";
    System.setIn(new ByteArrayInputStream(userInputs.getBytes()));
    result = snakeLadderApp.play();
    Assert.assertEquals(SnakeLadderConstant.GANE_OVER_MSG, result.getMessage());
    Assert.assertEquals(10, result.getTurnsTaken());
    //Try with R inputs

    snakeLadderApp = new SnakeLadderApp(new NormalDice(), new SnakeLadderBoard());
    userInputs = "R\nR\nR\nx";
    System.setIn(new ByteArrayInputStream(userInputs.getBytes()));
    result = snakeLadderApp.play();
    Assert.assertEquals(3, result.getTurnsTaken());
    //Try with mix of R and r inputs
    snakeLadderApp = new SnakeLadderApp(new NormalDice(), new SnakeLadderBoard());
    userInputs = "R\nR\nR\nr\nr\nx";
    System.setIn(new ByteArrayInputStream(userInputs.getBytes()));
    result = snakeLadderApp.play();
    Assert.assertEquals(5, result.getTurnsTaken());
  }

  @Test
  public void testPlayMethodWithCustomDice() {
    SnakeLadderBoard snakeLadderBoard = new SnakeLadderBoard();
    //Custom dice that returns 20 for each throw
    Dice dice = new Dice() {
      public int throwDice() {
        return 20;
      }
    };
    SnakeLadderApp snakeLadderApp = new SnakeLadderApp(dice, snakeLadderBoard);
    //Try with 10 r inputs
    String userInputs = "r\nr\nr\nr\nr\nr\nr\nr\nr\nr\n";
    System.setIn(new ByteArrayInputStream(userInputs.getBytes()));
    GameResult result = snakeLadderApp.play();
    Assert.assertEquals(SnakeLadderConstant.SUCCESS_MSG, result.getMessage());
    //Even though there are 10 r inputs from user, the game should get completed in 5 turns as dice returns 20 everytime.
    Assert.assertEquals(5, result.getTurnsTaken());

  }

}
