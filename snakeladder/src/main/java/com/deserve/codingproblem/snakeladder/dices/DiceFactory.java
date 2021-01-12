package com.deserve.codingproblem.snakeladder.dices;

import com.deserve.codingproblem.snakeladder.exceptions.InvalidDataException;
import com.deserve.codingproblem.snakeladder.utils.SnakeLadderConstant;

public class DiceFactory {
  private static DiceFactory instance;

  public static DiceFactory getInstance() {
    if(instance == null) {
      synchronized (DiceFactory.class) {
        if(instance == null) {
          instance = new DiceFactory();
        }
      }
    }
    return instance;
  }

  public Dice getDice(String type) throws InvalidDataException {
    if(SnakeLadderConstant.DICE_TYPE_NORMAL.equalsIgnoreCase(type)) {
      return new NormalDice();
    } else if(SnakeLadderConstant.DICE_TYPE_CROOKED.equalsIgnoreCase(type)) {
      return new CrookedDice();
    }
    throw new InvalidDataException("Unsupported Dice type: "+type);
  }

}
