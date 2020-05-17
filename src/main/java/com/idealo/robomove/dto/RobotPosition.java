package com.idealo.robomove.dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RobotPosition {

    private int row;

    private int col;

    private String direction;

    private int directionDegree;

}
