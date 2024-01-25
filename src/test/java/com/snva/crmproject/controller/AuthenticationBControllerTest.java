package com.snva.crmproject.controller;

import com.snva.crmproject.CrmProjectApplication;
import com.snva.crmproject.utility.TestUser;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.snva.crmproject.utility.TestUser.TEST_USERNAME;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = CrmProjectApplication.class)
@AutoConfigureMockMvc
class AuthenticationBControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementControllerTest.class);

    private static String authorization = TestUser.getBase64Credentials();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void loginTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/authentication")
                .header("Authorization", authorization))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(TEST_USERNAME))
                .andReturn();
    }

    @Test
    void unauthorizedTest() throws Exception {
         mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/some_resource_outside_of_open"))
                .andExpect(status().isUnauthorized());
    }
}