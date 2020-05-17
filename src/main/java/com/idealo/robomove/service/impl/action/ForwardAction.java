package com.idealo.robomove.service.impl.action;

import com.idealo.robomove.dto.RobotPosition;
import com.idealo.robomove.service.RobotAction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForwardAction extends RobotAction {
    public static final Pattern pattern = Pattern.compile("^FORWARD\\s(\\d)");

    @Override
    public void execute(String command, RobotPosition current) {
        Matcher matcher = pattern.matcher(command);
        if(matcher.find()) {
            int step = Integer.parseInt(matcher.group(1));
            setMove(current, step);
        }
    }
}
