package com.idealo.robomove.service.impl.action;

import com.idealo.robomove.dto.RobotPosition;
import com.idealo.robomove.exception.RoboMoveException;
import com.idealo.robomove.service.RobotAction;
import org.springframework.http.HttpStatus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PositionAction extends RobotAction {

    public static final Pattern pattern = Pattern.compile("^POSITION\\s(\\d)\\s(\\d)\\s(.*)");
    /**
     * Set the initial position
     *
     * @param command
     */
    @Override
    public void execute(String command, RobotPosition current) {
        Matcher matcher = pattern.matcher(command);
        if(matcher.find()) {
            int row = Integer.parseInt(matcher.group(1));
            int col = Integer.parseInt(matcher.group(2));
            String direction = matcher.group(3);
            if(row > 5 || col > 5) {
                throw new RoboMoveException("Index out of bound", HttpStatus.BAD_REQUEST);
            }
            current.setRow(row);
            current.setCol(col);
            current.setDirection(direction);
            setDirection(current, current.getDirection());
        }
    }
}
