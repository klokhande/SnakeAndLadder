package com.deserve.codingproblem.snakeladder;

import com.deserve.codingproblem.snakeladder.dices.Dice;
import com.deserve.codingproblem.snakeladder.dices.NormalDice;
import com.deserve.codingproblem.snakeladder.exceptions.InvalidDataException;
import com.deserve.codingproblem.snakeladder.models.GameResult;
import com.deserve.codingproblem.snakeladder.utils.SnakeLadderConstant;

import java.util.HashMap;
import java.util.Scanner;

public class SnakeLadderApp {
  private Dice dice;
  private SnakeLadderBoard snakeLadderBoard;
  private final int TOTAL_TURNS = 10;

  public SnakeLadderApp(Dice dice, SnakeLadderBoard snakeLadderBoard) {
    this.dice = dice;
    this.snakeLadderBoard = snakeLadderBoard;
  }

  public GameResult play() throws InvalidDataException {
    Scanner scanner = new Scanner(System.in);
    int turns = 0;
    while(!snakeLadderBoard.hasWon() && turns < TOTAL_TURNS) {
      System.out.println("Press R or r to throw the dice");
      String input = scanner.next();
      if(!input.equals("R") && !input.equals("r") ) {
        break;
      }
      turns++;
      System.out.println("Rolling dice!!");
      int rolledValue = dice.throwDice();
      System.out.println("Value on top of dice: "+rolledValue);
      int previousPosition = snakeLadderBoard.getCurrentPosition();
      snakeLadderBoard.moveAhead(rolledValue);
      System.out.println("Moving from "+previousPosition+" to "+snakeLadderBoard.getCurrentPosition());
    }

    GameResult gameResult = new GameResult();
    gameResult.setTurnsTaken(turns);
    if(snakeLadderBoard.hasWon()) {
      gameResult.setMessage(SnakeLadderConstant.SUCCESS_MSG);
    } else {
      gameResult.setMessage(SnakeLadderConstant.GANE_OVER_MSG);
    }
    return gameResult;
  }

  public static void main(String[] args) {
    GameResult result = null;
    try {
      HashMap<Integer, Integer> snakes = new HashMap<Integer, Integer>();
      snakes.put(99, 69);
      snakes.put(91, 71);
      snakes.put(87, 57);
      snakes.put(65, 52);
      snakes.put(47, 19);
      snakes.put(34, 1);
      snakes.put(25, 5);
      result = new SnakeLadderApp(new NormalDice(), new SnakeLadderBoard(snakes)).play();
    } catch (InvalidDataException e) {
      System.out.println("Error occurred: "+e.getMessage());
      System.exit(1);
    }
    System.out.println(result.getMessage());
    System.out.println("Total turns taken: "+result.getTurnsTaken());
  }
}
