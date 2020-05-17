package com.idealo.robomove.service.impl.action;

import com.idealo.robomove.dto.RobotPosition;
import com.idealo.robomove.service.RobotAction;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Slf4j
public class WaitAction extends RobotAction {

    public static final Pattern pattern = Pattern.compile("^WAIT");

    @Override
    public void execute(String command, RobotPosition current) {
        log.info("do nothing, just wait and relax");
    }
}
