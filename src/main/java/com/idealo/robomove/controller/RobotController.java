package com.idealo.robomove.controller;

import com.idealo.robomove.dto.RobotPosition;
import com.idealo.robomove.service.RobotAction;
import com.idealo.robomove.service.RobotMoveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(RobotController.ROOT_URL)
public class RobotController {

    public static final String ROOT_URL =  "/";
    private final RobotMoveService robotMoveService;

    @GetMapping
    public String getIndexPage(Model model) {
        RobotPosition position = new RobotPosition(
                0,
                0,
                RobotAction.NORTH,
                0
        );
        model.addAttribute("initPosition", position);
        return "index";
    }

    @PostMapping
    public ResponseEntity<RobotPosition> generatePlanDto(@RequestBody @Valid final String moveScript){
        return ResponseEntity.ok(robotMoveService.parseScript(moveScript));
    }
}
