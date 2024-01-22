package com.snva.crmproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.snva.crmproject.CrmProjectApplication;
import com.snva.crmproject.entity.userDetails.User;
import com.snva.crmproject.utility.Roles;
import com.snva.crmproject.utility.TestUser;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = CrmProjectApplication.class)
@AutoConfigureMockMvc
class UserManagementControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementControllerTest.class);
    private static String authorization = TestUser.getBase64Credentials();
    private static User testingUser;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() throws Exception {
        if (testingUser == null) {
            LOGGER.info("Creating a user for testing");

            testingUser = new User();
            testingUser.setUsername("Test User");
            testingUser.setPassword("1234");
            testingUser.setAccountNonLocked(true);
            testingUser.setRole(Roles.TEST);

            ResultActions result = mockMvc.perform(post("/api/v1/users/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(testingUser)))
                    .andExpect(status().isOk());
            int userId = JsonPath.read(result.andReturn().getResponse().getContentAsString(), "$.id");
            testingUser.setId(Long.valueOf(userId));
            LOGGER.info("Created user got '" + testingUser.getId() + "' id");
        }
    }

    @AfterEach
    public void cleanUp() throws Exception {
        if (testingUser != null) {
            LOGGER.info("After test. Deleting test user with id:" + testingUser.getId());
            mockMvc.perform(delete("/api/v1/users/{id}", testingUser.getId())
                    .header("Authorization", authorization))
                    .andExpect(status().isOk());
            testingUser = null;
        }
    }

    @Test
    void getUserByIdTest() throws Exception {
        LOGGER.info("Pulling user by id:" + testingUser.getId());
        MvcResult result = mockMvc.perform(get("/api/v1/users/{id}", testingUser.getId())
                .header("Authorization", authorization))
                .andExpect(status().isOk())
                .andReturn();

        Integer readId = JsonPath.read(result.getResponse().getContentAsString(), "$.id");
        assertEquals(testingUser.getId(), Long.valueOf(readId));
        assertEquals(testingUser.getUsername(), JsonPath.read(result.getResponse().getContentAsString(), "$.username"));
    }

    @Test
    void getUserByUsernameTest() throws Exception {
        LOGGER.info("Pulling user by name:" + testingUser.getUsername());

        MvcResult result = mockMvc.perform(get("/api/v1/users/name/{username}", testingUser.getUsername())
                .header("Authorization", authorization))
                .andExpect(status().isOk())
                .andReturn();

        Integer readId = JsonPath.read(result.getResponse().getContentAsString(), "$.id");
        assertEquals(testingUser.getId(), Long.valueOf(readId));
        assertEquals(testingUser.getUsername(), JsonPath.read(result.getResponse().getContentAsString(), "$.username"));
    }

    @Test
    void getAllUsersTest() throws Exception {
        LOGGER.info("Pulling all users from DB");
        mockMvc.perform(get("/api/v1/users")
                .header("Authorization", authorization))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(Matchers.greaterThan(0)));
    }

    @Test
    void updateUserTest() throws Exception {
        String TEST_VALUE = "new test value";
        testingUser.setUsername(TEST_VALUE);
        testingUser.setRole(Roles.TRAINER);
        LOGGER.info("Testing update of a user with id:" + testingUser.getId());

        ResultActions result = mockMvc.perform(put("/api/v1/users/{id}", testingUser.getId())
                .header("Authorization", authorization)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testingUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(TEST_VALUE))
                .andExpect(jsonPath("$.role").value(Roles.TRAINER));
    }

    @Test
    void deleteUserTest() throws Exception {
        LOGGER.info("Deleting test user with id:" + testingUser.getId());
        mockMvc.perform(delete("/api/v1/users/{id}", testingUser.getId())
                .header("Authorization", authorization))
                .andExpect(status().isOk());
        testingUser = null;
    }

    @Test
    void suspendUserTest() throws Exception {
        testingUser.setAccountNonLocked(false);
        LOGGER.info("Testing suspension of a user with id:" + testingUser.getId());

        ResultActions result = mockMvc.perform(put("/api/v1/users/suspend/{id}", testingUser.getId())
                .header("Authorization", authorization))
                .andExpect(status().isOk());
    }

    @Test
    void updatePasswordTest() throws Exception {
        String TEST_VALUE = "new password";
        testingUser.setPassword(TEST_VALUE);
        LOGGER.info("Testing update of a user password with id:" + testingUser.getId());

        ResultActions result = mockMvc.perform(post("/api/v1/users/changePassword")
                .header("Authorization", authorization)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testingUser)))
                .andExpect(status().isOk());
    }

}