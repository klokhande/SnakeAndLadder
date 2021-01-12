package com.deserve.codingproblem.snakeladder;

import com.deserve.codingproblem.snakeladder.exceptions.InvalidDataException;
import com.deserve.codingproblem.snakeladder.utils.SnakeLadderConstant;

import java.util.Map;
import java.util.Optional;

public class SnakeLadderBoard {
  private int currentPosition = 0;
  private int finalPosition = SnakeLadderConstant.FINAL_POSITION;
  private Map<Integer, Integer> snakes;
  public SnakeLadderBoard(Map<Integer, Integer> snakes) throws InvalidDataException{
    validate(snakes);
    this.snakes = snakes;
  }

  public SnakeLadderBoard(int startPosition, int finalPosition, Map<Integer, Integer> snakes) throws InvalidDataException {
    this(snakes);
    if(startPosition < 0) {
      throw new InvalidDataException("Start position should be greater than 0");
    }

    if(finalPosition <= startPosition) {
      throw new InvalidDataException("Final position should be greater than the start position");
    }
    this.currentPosition = startPosition;
    this.finalPosition = finalPosition;
  }

  public boolean moveAhead(int moveValue) throws InvalidDataException {
    //Move ahead only if we are not exceeding finalPosition.
    if(moveValue <= 0) {
      throw new InvalidDataException("Can not move player by zero or negative value");
    }
    if(currentPosition + moveValue <= finalPosition) {
      currentPosition += moveValue;
    }

    if(snakes.containsKey(currentPosition)) {
      currentPosition = snakes.get(currentPosition);
      System.out.println("Ooops! Biiten by a Snake.");
    }
    return hasWon();
  }

  private void validate(Map<Integer, Integer> snakes) throws InvalidDataException{
    Optional<Map.Entry<Integer, Integer>> optional = snakes.entrySet().stream().filter(snake -> snake.getKey() <= snake.getValue()).findAny();
    if(optional.isPresent()) {
      throw new InvalidDataException("Snake mouth position can not be lower than the tail position");
    }
  }


  public boolean hasWon() {
    return currentPosition == finalPosition;
  }

  public int getCurrentPosition() {
    return currentPosition;
  }
}
