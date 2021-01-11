package com.deserve.codingproblem.snakeladder;

import com.deserve.codingproblem.snakeladder.exceptions.InvalidDataException;
import com.deserve.codingproblem.snakeladder.utils.SnakeLadderConstant;

public class SnakeLadderBoard {
  private int currentPosition = 0;
  private int finalPosition = SnakeLadderConstant.FINAL_POSITION;
  public SnakeLadderBoard() {

  }

  public SnakeLadderBoard(int startPosition, int finalPosition) throws InvalidDataException {
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
    return hasWon();
  }


  public boolean hasWon() {
    return currentPosition == finalPosition;
  }

  public int getCurrentPosition() {
    return currentPosition;
  }
}
