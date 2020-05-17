package com.idealo.robomove.service.impl.action;

import com.idealo.robomove.dto.RobotPosition;
import com.idealo.robomove.service.RobotAction;

import java.util.regex.Pattern;

public class TurnaroundAction extends RobotAction {
    public static final Pattern pattern = Pattern.compile("^TURNAROUND");
    @Override
    public void execute(String command, RobotPosition current) {
        setDirection(current, "turnaround");
    }
}
