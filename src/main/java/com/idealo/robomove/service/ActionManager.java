package com.idealo.robomove.service;

import com.idealo.robomove.dto.RobotPosition;
import com.idealo.robomove.exception.RoboMoveException;
import com.idealo.robomove.service.impl.action.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Slf4j
@Service
public class ActionManager {

    private final Map<Pattern, RobotAction> actionMap = new HashMap<>();

    public ActionManager() {
        actionMap.put(ForwardAction.pattern, new ForwardAction());
        actionMap.put(LeftAction.pattern, new LeftAction());
        actionMap.put(WaitAction.pattern, new WaitAction());
        actionMap.put(PositionAction.pattern, new PositionAction());
        actionMap.put(RightAction.pattern, new RightAction());
        actionMap.put(TurnaroundAction.pattern, new TurnaroundAction());
    }



    public void manage(String command, RobotPosition current) {
        boolean commandFound = false;
        for (Map.Entry<Pattern, RobotAction> entry : actionMap.entrySet()) {
            if (entry.getKey().matcher(command).find()) {
                entry.getValue().execute(command, current);
                log.info(command +" : "+current.toString());
                commandFound = true;
                break;
            }
        }
         if(!commandFound) {
            throw new RoboMoveException("Unknown command: " + command, HttpStatus.BAD_REQUEST);
        }
    }
}
