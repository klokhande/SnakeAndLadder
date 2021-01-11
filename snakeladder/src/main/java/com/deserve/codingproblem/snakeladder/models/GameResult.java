package com.deserve.codingproblem.snakeladder.models;

public class GameResult {
  private String message;
  private int turnsTaken;

  public int getTurnsTaken() {
    return turnsTaken;
  }

  public void setTurnsTaken(int turnsTaken) {
    this.turnsTaken = turnsTaken;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
