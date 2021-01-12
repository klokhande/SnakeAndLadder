package com.deserve.codingproblem.snakeladder.dices;

import com.deserve.codingproblem.snakeladder.exceptions.InvalidDataException;
import com.deserve.codingproblem.snakeladder.utils.SnakeLadderConstant;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceFactoryTest {

  @Test
  public void getDice() {
    try {
      Dice dice = DiceFactory.getInstance().getDice(SnakeLadderConstant.DICE_TYPE_NORMAL);
      assertTrue(dice instanceof NormalDice);
      dice = DiceFactory.getInstance().getDice(SnakeLadderConstant.DICE_TYPE_CROOKED);
      assertTrue(dice instanceof CrookedDice);
    } catch (InvalidDataException e) {
      fail(e.getMessage());
    }

    try {
      //This call should fail
      DiceFactory.getInstance().getDice("invaliddice");
      fail("Validation test failed as DiceFactory is accepting invalid inputs");
    } catch (InvalidDataException e) {
      //
    }
  }
}
