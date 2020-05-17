package com.idealo.robomove.service.action;


import com.idealo.robomove.dto.RobotPosition;
import com.idealo.robomove.exception.RoboMoveException;
import com.idealo.robomove.service.impl.action.ForwardAction;
import com.idealo.robomove.service.impl.action.LeftAction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeftActionTest {

    @Test
    public void testLeftToEast() {
        RobotPosition position = new RobotPosition(
                2,
                0,
                "EAST",
                90
        );
        LeftAction leftAction = new LeftAction();
        leftAction.execute("LEFT", position);
        Assertions.assertEquals("NORTH", position.getDirection());
    }

    @Test
    public void testLeftToWest() {
        RobotPosition position = new RobotPosition(
                2,
                0,
                "WEST",
                90
        );
        LeftAction leftAction = new LeftAction();
        leftAction.execute("LEFT", position);
        Assertions.assertEquals("SOUTH", position.getDirection());
    }

    @Test
    public void testLeftToSouth() {
        RobotPosition position = new RobotPosition(
                2,
                0,
                "SOUTH",
                90
        );
        LeftAction leftAction = new LeftAction();
        leftAction.execute("LEFT", position);
        Assertions.assertEquals("EAST", position.getDirection());
    }

    @Test
    public void testLeftToNorth() {
        RobotPosition position = new RobotPosition(
                2,
                0,
                "NORTH",
                90
        );
        LeftAction leftAction = new LeftAction();
        leftAction.execute("LEFT", position);
        Assertions.assertEquals("WEST", position.getDirection());
    }


}
