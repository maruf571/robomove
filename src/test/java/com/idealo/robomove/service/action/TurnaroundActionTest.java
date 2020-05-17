package com.idealo.robomove.service.action;


import com.idealo.robomove.dto.RobotPosition;
import com.idealo.robomove.service.impl.action.RightAction;
import com.idealo.robomove.service.impl.action.TurnaroundAction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TurnaroundActionTest {

    @Test
    public void testToNorth() {
        RobotPosition position = new RobotPosition(
                2,
                0,
                "NORTH",
                90
        );
        TurnaroundAction turnaroundAction = new TurnaroundAction();
        turnaroundAction.execute("TURNAROUND", position);
        Assertions.assertEquals("SOUTH", position.getDirection());
    }

    @Test
    public void testToEast() {
        RobotPosition position = new RobotPosition(
                2,
                0,
                "EAST",
                90
        );
        TurnaroundAction turnaroundAction = new TurnaroundAction();
        turnaroundAction.execute("TURNAROUND", position);
        Assertions.assertEquals("WEST", position.getDirection());
    }

    @Test
    public void testToWest() {
        RobotPosition position = new RobotPosition(
                2,
                0,
                "WEST",
                90
        );
        TurnaroundAction turnaroundAction = new TurnaroundAction();
        turnaroundAction.execute("TURNAROUND", position);
        Assertions.assertEquals("EAST", position.getDirection());
    }

    @Test
    public void testToSouth() {
        RobotPosition position = new RobotPosition(
                2,
                0,
                "NORTH",
                90
        );
        TurnaroundAction turnaroundAction = new TurnaroundAction();
        turnaroundAction.execute("TURNAROUND", position);
        Assertions.assertEquals("SOUTH", position.getDirection());
    }




}
