package com.deserve.codingproblem.snakeladder.exceptions;

public class InvalidDataException extends Exception {
  public InvalidDataException(String msg) {
    super(msg);
  }

  public InvalidDataException(String msg, Throwable t) {
    super(msg, t);
  }
}
