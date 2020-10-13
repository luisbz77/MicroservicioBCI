package com.luisbrito.micro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luisbrito.micro.model.LoginRequest;
import com.luisbrito.micro.service.LoginUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestCaseController {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LoginUserService loginUserService;

    @Test
    public void loginTest() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("venezuela@gmail.ve");
        loginRequest.setPassword("Cumana20");
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk());
    }

}
