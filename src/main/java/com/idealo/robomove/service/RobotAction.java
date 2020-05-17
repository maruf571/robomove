package com.idealo.robomove.service;

import com.idealo.robomove.dto.RobotPosition;
import com.idealo.robomove.exception.RoboMoveException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class RobotAction {

    private final static Map<String, Integer> directionMap;
    private final static Map<Integer, String> reverseMap;

    public static final String NORTH = "north";
    public static final String SOUTH = "south";
    public static final String EAST = "east";
    public static final String WEST = "west";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String TURNAROUND = "turnaround";


    static {
        Map<String, Integer> dMap = new HashMap<>();
        Map<Integer, String> rMap = new HashMap<>();
        dMap.put(NORTH, 0);
        dMap.put(EAST, 90);
        dMap.put(SOUTH, 180);
        dMap.put(WEST, 270);

        rMap.put( 0, NORTH);
        rMap.put(90, EAST);
        rMap.put( 180, SOUTH);
        rMap.put(270, WEST);

        directionMap = Collections.unmodifiableMap(dMap);
        reverseMap = Collections.unmodifiableMap(rMap);
    }

    protected void setDirection(RobotPosition current, String to) {
        Integer currentDirection = directionMap.get(current.getDirection().toLowerCase());
        if(to.equalsIgnoreCase(LEFT)) {
            currentDirection = currentDirection - 90;
        } else if(to.equalsIgnoreCase(RIGHT)) {
            currentDirection = currentDirection + 90;
        } else if(to.equalsIgnoreCase(TURNAROUND)) {
            currentDirection = currentDirection + 180;
        }

        if(currentDirection < 0){
            currentDirection = 360 - Math.abs(currentDirection);
        } else if(currentDirection > 270) {
            currentDirection = currentDirection % 360;
        }

        current.setDirectionDegree(currentDirection);
        current.setDirection(reverseMap.get(currentDirection).toUpperCase());
    }


    protected void setMove(RobotPosition current, int step ) {
        int newPosition;
        if(current.getDirection().equalsIgnoreCase(EAST)) {
            newPosition = current.getCol() + step;
            validatePosition(newPosition);
            current.setCol(newPosition);
        } else if(current.getDirection().equalsIgnoreCase(WEST)) {
            newPosition = current.getCol() - step;
            validatePosition(newPosition);
            current.setCol(newPosition);
        } else if(current.getDirection().equalsIgnoreCase(SOUTH)) {
            newPosition = current.getRow() + step;
            validatePosition(newPosition);
            current.setRow(newPosition);
        } else if(current.getDirection().equalsIgnoreCase(NORTH)) {
            newPosition = current.getRow() - step;
            validatePosition(newPosition);
            current.setRow(newPosition);
        }
    }

    private void validatePosition(int position) {
        if(position < 0 || position > 5) {
            // Throw exception
            throw new RoboMoveException("Index out of bound", HttpStatus.BAD_REQUEST);
        }
    }
    protected abstract void execute(String command, RobotPosition current);
}
