package com.springboot.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(Controller.class)
public class ControllerTest {
    @Autowired
    private Controller controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testgetEmployee(){

    }


}
