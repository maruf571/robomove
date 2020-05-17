package com.idealo.robomove.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class RobotMoveControllerIT {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void should_set_initial_position() throws Exception {
        // Given
        String script = "POSITION 1 3 EAST";

        // Then
         this.mockMvc.perform(post(RobotController.ROOT_URL)
                .contentType(MediaType.TEXT_PLAIN_VALUE)
               .content(script)
         )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.row").value (1))
                .andExpect(jsonPath("$.col").value (3))
                .andExpect(jsonPath("$.direction").value ("EAST"))
                .andExpect(jsonPath("$.directionDegree").value (90))
          ;
    }


    @Test
    public void should_set_forward() throws Exception {
        // Given
        String script = "POSITION 1 3 EAST\n" +
                "FORWARD 1\n";

        // Then
        this.mockMvc.perform(post(RobotController.ROOT_URL)
                .contentType(MediaType.TEXT_PLAIN_VALUE)
                .content(script)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.row").value (1))
                .andExpect(jsonPath("$.col").value (4))
                .andExpect(jsonPath("$.direction").value ("EAST"))
                .andExpect(jsonPath("$.directionDegree").value (90))
        ;
    }


    @Test
    public void should_set_turnaround() throws Exception {
        // Given
        String script = "POSITION 1 3 EAST\n" +
                "FORWARD 1\n" +
                "TURNAROUND \n";

        // Then
        this.mockMvc.perform(post(RobotController.ROOT_URL)
                .contentType(MediaType.TEXT_PLAIN_VALUE)
                .content(script)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.row").value (1))
                .andExpect(jsonPath("$.col").value (4))
                .andExpect(jsonPath("$.direction").value ("WEST"))
                .andExpect(jsonPath("$.directionDegree").value (270))
        ;
    }

    @Test
    public void should_set_right() throws Exception {
        // Given
        String script = "POSITION 1 3 EAST\n" +
                "FORWARD 1\n" +
                "TURNAROUND \n" +
                "RIGHT\n";

        // Then
        this.mockMvc.perform(post(RobotController.ROOT_URL)
                .contentType(MediaType.TEXT_PLAIN_VALUE)
                .content(script)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.row").value (1))
                .andExpect(jsonPath("$.col").value (4))
                .andExpect(jsonPath("$.direction").value ("NORTH"))
                .andExpect(jsonPath("$.directionDegree").value (0))
        ;
    }

    @Test
    public void should_throw_index_out_of_bound() throws Exception {
        // Given
        String script = "POSITION 1 3 EAST\n" +
                "FORWARD 9\n" +
                "TURNAROUND \n" +
                "RIGHT\n";

        // Then
        this.mockMvc.perform(post(RobotController.ROOT_URL)
                .contentType(MediaType.TEXT_PLAIN_VALUE)
                .content(script)
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Index out of bound"))
        ;
    }


    @Test
    public void should_throw_unknown_command() throws Exception {
        // Given
        String script = "POSITION 1 3 EAST\n" +
                "FORWARD 1\n" +
                "TURNAROUND \n" +
                "XYZ\n";

        // Then
        this.mockMvc.perform(post(RobotController.ROOT_URL)
                .contentType(MediaType.TEXT_PLAIN_VALUE)
                .content(script)
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Unknown command: XYZ"))
        ;
    }


}
