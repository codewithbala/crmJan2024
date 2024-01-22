package com.snva.crmproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.snva.crmproject.CrmProjectApplication;
import com.snva.crmproject.entity.userDetails.User;
import com.snva.crmproject.entity.userDetails.UserPersonalDetails;
import com.snva.crmproject.utility.Roles;
import com.snva.crmproject.utility.TestUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = CrmProjectApplication.class)
@AutoConfigureMockMvc
class CreateUserControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUserControllerTest.class);

    private static String authorization = TestUser.getBase64Credentials();
    private static User testingUser;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

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
    void createSuperAdminTest() throws Exception {
        createUserWithRole(Roles.SUPER_ADMIN, "TestSuperAdmin", "register", null);
    }

    @Test
    void createRecruiterAdminTest() throws Exception {
        createUserWithRole(Roles.RECRUITER_ADMIN, "TestRecruiterAdmin", "recruiter_admin", authorization);
    }

    @Test
    void createTrainerAdminTest() throws Exception {
        createUserWithRole(Roles.TRAINER_ADMIN, "TestTrainerAdmin", "trainer_admin", authorization);
    }

    @Test
    void createBusinessDevAdminTest() throws Exception {
        createUserWithRole(Roles.BUSINESS_DEV_ADMIN, "TestBusinessDevAdmin", "bd_admin", authorization);
    }

    @Test
    void createRecruiterTest() throws Exception {
        createUserWithRole(Roles.RECRUITER, "TestRecruiter", "recruiter", authorization);
    }

    @Test
    void createTrainerTest() throws Exception {
        createUserWithRole(Roles.TRAINER, "TestTrainer", "trainer", authorization);
    }

    @Test
    void createBusinessDevTest() throws Exception {
        createUserWithRole(Roles.BUSINESS_DEV, "TestBusinessDev", "bd", authorization);
    }

    private MvcResult createUserWithRole(String role, String username, String resource, String auth) throws Exception {
        LOGGER.info("Test creating " + role + " user");

        testingUser = new User();
        testingUser.setId(0);
        testingUser.setUsername(username);
        testingUser.setPassword("1234");
        testingUser.setRole(role);

        UserPersonalDetails personalDetails = new UserPersonalDetails();
        personalDetails.setId(0);
        personalDetails.setFirstName("Test first name");
        personalDetails.setUser(testingUser);
        testingUser.setUserPersonalDetails(personalDetails);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/users/" + resource)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testingUser))
                .header("Authorization", auth != null ? auth : ""))
                .andReturn();

        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

        assertTrue(JsonPath.read(result.getResponse().getContentAsString(), "$.id") != null);
        int userId = JsonPath.read(result.getResponse().getContentAsString(), "$.id");
        testingUser.setId(Long.valueOf(userId));

        assertEquals(testingUser.getUsername(), JsonPath.read(result.getResponse().getContentAsString(), "$.username"));
        assertEquals(testingUser.getRole(), JsonPath.read(result.getResponse().getContentAsString(), "$.role"));
        assertTrue(JsonPath.read(result.getResponse().getContentAsString(), "$.password") != null);
        assertEquals(testingUser.getUserPersonalDetails().getFirstName(),
                JsonPath.read(result.getResponse().getContentAsString(), "$.userPersonalDetails.firstName"));

        return result;
    }

    @Test
    void createTrainerAdminWithoutAuthorityTest() throws Exception {
        LOGGER.info("Test creating " + Roles.TRAINER_ADMIN + " user without authority");

        testingUser = new User();
        testingUser.setId(0);
        testingUser.setUsername("TestTrainerAdmin");
        testingUser.setPassword("1234");
        testingUser.setRole(Roles.TRAINER_ADMIN);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/users/trainer_admin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testingUser)))
                .andExpect(status().isUnauthorized());

    }

}