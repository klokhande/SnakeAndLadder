package com.deserve.codingproblem.snakeladder;

import com.deserve.codingproblem.snakeladder.utils.SnakeLadderConstant;

public class SnakeLadderBoard {
  private int currentPosition = 0;
  private int finalPosition = SnakeLadderConstant.FINAL_POSITION;
  public SnakeLadderBoard() {

  }

  public SnakeLadderBoard(int currentPosition, int finalPosition) {
    this.currentPosition = currentPosition;
    this.finalPosition = finalPosition;
  }

  public boolean moveAhead(int moveValue) {
    //Move ahead only if we are not exceeding finalPosition.
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
