package com.idealo.robomove.service.action;


import com.idealo.robomove.dto.RobotPosition;
import com.idealo.robomove.exception.RoboMoveException;
import com.idealo.robomove.service.impl.action.ForwardAction;
import com.idealo.robomove.service.impl.action.PositionAction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionActionTest {

    @Test
    public void testInitPosition() {
        RobotPosition position = new RobotPosition(
                0,
                0,
                "NORTH",
                0
        );
        PositionAction positionAction = new PositionAction();
        positionAction.execute("POSITION 1 3 EAST", position);
        System.out.println(position.toString());
        Assertions.assertEquals(1, position.getRow());
        Assertions.assertEquals(3, position.getCol());
        Assertions.assertEquals("EAST", position.getDirection());
        Assertions.assertEquals(90, position.getDirectionDegree());
    }




    @Test
    public void testThrowException() {
        RobotPosition position = new RobotPosition(
                0,
                0,
                "NORTH",
                0
        );
        PositionAction positionAction = new PositionAction();
        Assertions.assertThrows(RoboMoveException.class, () ->
            positionAction.execute("POSITION 1 9 EAST", position)
        );
    }
}
