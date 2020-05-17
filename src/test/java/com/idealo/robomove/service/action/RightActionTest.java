package com.idealo.robomove.service.action;


import com.idealo.robomove.dto.RobotPosition;
import com.idealo.robomove.service.RobotAction;
import com.idealo.robomove.service.impl.action.LeftAction;
import com.idealo.robomove.service.impl.action.RightAction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RightActionTest {

    @Test
    public void testToNorth() {
        RobotPosition position = new RobotPosition(
                2,
                0,
                "NORTH",
                90
        );
        RightAction rightAction = new RightAction();
        rightAction.execute("RIGHT", position);
        Assertions.assertEquals("EAST", position.getDirection());
    }

    @Test
    public void testToEast() {
        RobotPosition position = new RobotPosition(
                2,
                0,
                "EAST",
                90
        );
        RightAction rightAction = new RightAction();
        rightAction.execute("RIGHT", position);
        Assertions.assertEquals("SOUTH", position.getDirection());
    }

    @Test
    public void testToWest() {
        RobotPosition position = new RobotPosition(
                2,
                0,
                "WEST",
                90
        );
        RightAction rightAction = new RightAction();
        rightAction.execute("RIGHT", position);
        Assertions.assertEquals("NORTH", position.getDirection());
    }

    @Test
    public void testToSouth() {
        RobotPosition position = new RobotPosition(
                2,
                0,
                "SOUTH",
                90
        );
        RightAction rightAction = new RightAction();
        rightAction.execute("RIGHT", position);
        Assertions.assertEquals("WEST", position.getDirection());
    }




}
