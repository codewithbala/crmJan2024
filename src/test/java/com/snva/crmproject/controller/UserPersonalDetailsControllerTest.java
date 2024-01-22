package com.snva.crmproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.snva.crmproject.CrmProjectApplication;
import com.snva.crmproject.entity.userDetails.User;
import com.snva.crmproject.entity.userDetails.UserPersonalDetails;
import com.snva.crmproject.repository.user.AuthenticationRepository;
import com.snva.crmproject.utility.TestUser;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static com.snva.crmproject.utility.TestUser.TEST_USERNAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = CrmProjectApplication.class)
@AutoConfigureMockMvc
class UserPersonalDetailsControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserPersonalDetailsControllerTest.class);

    private static String authorization = TestUser.getBase64Credentials();
    private static UserPersonalDetails testingDetails;
    private static User testingUser;
    private static String resourcePath = "/api/v1/users/personal-details";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @BeforeEach
    public void setup() throws Exception {
        if (testingUser == null) {

            testingUser = authenticationRepository.findUserByUsername(TEST_USERNAME).get();
            LOGGER.info("Prepared test user with username:'" + testingUser.getUsername()
                    + "' and id:'" + testingUser.getId() + "'");
        }

        if (testingDetails == null) {
            LOGGER.info("Creating user personal details for testing");
            testingDetails = new UserPersonalDetails();
            testingDetails.setId(testingUser.getId());
            testingDetails.setFirstName("Test First name");
            testingDetails.setLastName("Test Last Name");
            testingDetails.setPhone("test phone");
            testingDetails.setAddressCity("Test city");
            testingDetails.setAddressLine1("Test line 1");
            testingDetails.setAddressLine2("Test line 2");
            testingDetails.setAddressState("TEST NJ");
            testingDetails.setAddressZipCode("test zip");
            testingDetails.setAddressCountry("test country");

            testingDetails.setUser(testingUser);
            testingUser.setUserPersonalDetails(testingDetails);

            ResultActions result = mockMvc.perform(post(resourcePath)
                    .header("Authorization", authorization)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(testingDetails)))
                    .andExpect(status().isOk());
        }
    }


    @Test
    void createPersonalDetailsTest() throws Exception {
        LOGGER.info("Creating user personal details for testing");
        UserPersonalDetails newDetails = new UserPersonalDetails();
        newDetails.setId(testingUser.getId());
        newDetails.setFirstName("John");
        newDetails.setLastName("Doe");
        newDetails.setPhone("1234567890");
        newDetails.setAddressCity("city");
        newDetails.setAddressLine1("street");
        newDetails.setAddressLine2("apartment 2");
        newDetails.setAddressState("NJ");
        newDetails.setAddressZipCode("100001");
        newDetails.setAddressCountry("US");

        newDetails.setUser(testingUser);
        testingUser.setUserPersonalDetails(newDetails);

        mockMvc.perform(post(resourcePath)
                .header("Authorization", authorization)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newDetails)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(newDetails.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(newDetails.getLastName()))
                .andExpect(jsonPath("$.phone").value(newDetails.getPhone()))
                .andExpect(jsonPath("$.addressCity").value(newDetails.getAddressCity()))
                .andExpect(jsonPath("$.addressLine1").value(newDetails.getAddressLine1()))
                .andExpect(jsonPath("$.addressLine2").value(newDetails.getAddressLine2()))
                .andExpect(jsonPath("$.addressState").value(newDetails.getAddressState()))
                .andExpect(jsonPath("$.addressZipCode").value(newDetails.getAddressZipCode()))
                .andExpect(jsonPath("$.addressCountry").value(newDetails.getAddressCountry()));

        testingDetails = newDetails;
    }

    @Test
    void getPersonalDetailsByIdTest() throws Exception {
        LOGGER.info("Pulling personal details by id:" + testingDetails.getId());
        MvcResult result = mockMvc.perform(get(resourcePath + "/{id}", testingDetails.getId())
                .header("Authorization", authorization))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.phone").exists())
                .andExpect(jsonPath("$.addressCity").exists())
                .andExpect(jsonPath("$.addressLine1").exists())
                .andExpect(jsonPath("$.addressLine2").exists())
                .andExpect(jsonPath("$.addressState").exists())
                .andExpect(jsonPath("$.addressZipCode").exists())
                .andExpect(jsonPath("$.addressCountry").exists())
                .andReturn();

        Integer readId = JsonPath.read(result.getResponse().getContentAsString(), "$.id");
        assertEquals(testingDetails.getId(), Long.valueOf(readId)); // Check if id matches

    }

    @Test
    void getAllPersonalDetailsTest() throws Exception {
        LOGGER.info("Pulling all personal details from DB");
        mockMvc.perform(get(resourcePath)
                .header("Authorization", authorization))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(Matchers.greaterThan(0)));
    }

    @Test
    void updatePersonalDetailsTest() throws Exception {

        UserPersonalDetails newDetails = new UserPersonalDetails();
        newDetails.setId(testingUser.getId());
        newDetails.setFirstName("John");
        newDetails.setLastName("Doe");
        newDetails.setPhone("1234567890");
        newDetails.setAddressCity("city");
        newDetails.setAddressLine1("street");
        newDetails.setAddressLine2("apartment 2");
        newDetails.setAddressState("NJ");
        newDetails.setAddressZipCode("100001");
        newDetails.setAddressCountry("US");
        newDetails.setUser(testingUser);

        testingUser.setUserPersonalDetails(newDetails);

        LOGGER.info("Testing personal details update with user id:" + newDetails.getId());
        ResultActions result = mockMvc.perform(put(resourcePath+"/{id}", newDetails.getId())
                .header("Authorization", authorization)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newDetails)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(newDetails.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(newDetails.getLastName()))
                .andExpect(jsonPath("$.phone").value(newDetails.getPhone()))
                .andExpect(jsonPath("$.addressCity").value(newDetails.getAddressCity()))
                .andExpect(jsonPath("$.addressLine1").value(newDetails.getAddressLine1()))
                .andExpect(jsonPath("$.addressLine2").value(newDetails.getAddressLine2()))
                .andExpect(jsonPath("$.addressState").value(newDetails.getAddressState()))
                .andExpect(jsonPath("$.addressZipCode").value(newDetails.getAddressZipCode()))
                .andExpect(jsonPath("$.addressCountry").value(newDetails.getAddressCountry()));

    }

    @Test
    public void whenDeleteReturnNotSupported() throws Exception {
        LOGGER.info("Testing deletion of personal details with id:" + testingDetails.getId());
        mockMvc.perform(delete(resourcePath+"/{id}", testingDetails.getId())
                .header("Authorization", authorization))
                .andExpect(status().isMethodNotAllowed());
    }

}