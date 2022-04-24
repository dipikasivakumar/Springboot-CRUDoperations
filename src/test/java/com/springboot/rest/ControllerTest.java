package com.springboot.rest;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(Controller.class)
public class ControllerTest {


    @MockBean
    private  UserRepository  userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testgetEmployee() throws Exception {

        mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk());
        Employee e = new Employee();
        Mockito.when(userRepository.findById(4L)).thenReturn(java.util.Optional.of(e));


    }
    @Test
    public void testpostEmployee() throws Exception{
        String json= "{\n" +
                "  \"employeeid\": 6,\n" +
                "  \"firstname\": \"Dipika\",\n" +
                "  \"lastname\": \"Sivakumar\",\n" +
                "  \"age\": 24,\n" +
                "  \"designation\": \"Engineer\"\n" +
                "}";
        mockMvc.perform(post("/save").contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void testUpdateEmployee() throws Exception{
       Employee e = new Employee();
        String json= "{\n" +
                "  \"employeeid\": 6,\n" +
                "  \"firstname\": \"Dipika\",\n" +
                "  \"lastname\": \"Sivakumar\",\n" +
                "  \"age\": 24,\n" +
                "  \"designation\": \"Trainee\"\n" +
                "}";
       Mockito.when(userRepository.findById(6L)).thenReturn(java.util.Optional.of(e));
        mockMvc.perform(put("/update/6").contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testDeleteEmployee() throws Exception{
        Employee e = new Employee();
        Mockito.when(userRepository.findById(6L)).thenReturn(java.util.Optional.of(e));
        mockMvc.perform(delete("/delete/6")).andDo(print()).andExpect(status().isOk());
    }




}
