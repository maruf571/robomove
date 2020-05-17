package com.idealo.robomove.service;

import com.idealo.robomove.dto.RobotPosition;

public interface RobotMoveService {
    RobotPosition parseScript(String script);
}
