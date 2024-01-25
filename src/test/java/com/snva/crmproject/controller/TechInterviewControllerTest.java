package com.snva.crmproject.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.snva.crmproject.CrmProjectApplication;
import com.snva.crmproject.entity.TechInterview;
import com.snva.crmproject.utility.TestUser;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = CrmProjectApplication.class)
@AutoConfigureMockMvc

public class TechInterviewControllerTest {
	
	    private static final Logger LOGGER = LoggerFactory.getLogger(TechInterviewControllerTest.class);

	    private static String authorization = TestUser.getBase64Credentials();
	    private static TechInterview testingTechInterview;

	    @Autowired
	    private MockMvc mockMvc;

	    @Autowired
	    private ObjectMapper objectMapper;

	    @BeforeEach
	    public void createTechInterviewBeforeDeletion() throws Exception {
	        if (testingTechInterview == null) {
	            LOGGER.info("Creating a tech interview for testing");
	            testingTechInterview = new TechInterview();
	            testingTechInterview.setInterviewDate(new Date());
	            testingTechInterview.setInterviewer("Test Interviewer");
	            testingTechInterview.setInterviewerFeedback("Good");
	            testingTechInterview.setCandidateInterviewStatus("Completed");

	            ResultActions result = mockMvc.perform(post("/api/v1/tech-interviews")
	                    .header("Authorization", authorization)
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(objectMapper.writeValueAsString(testingTechInterview)))
	                    .andExpect(status().isOk());

	            int techInterviewId = JsonPath.read(result.andReturn().getResponse().getContentAsString(), "$.id");
	            testingTechInterview.setId(Long.valueOf(techInterviewId));
	            LOGGER.info("Created tech interview with id: {}", testingTechInterview.getId());
	        }
	    }

	    @Test
	    public void testGetAllTechInterviews() throws Exception {
	        LOGGER.info("Pulling all tech interviews from DB");
	        mockMvc.perform(get("/api/v1/tech-interviews")
	                .header("Authorization", authorization))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$").isArray())
	                .andExpect(jsonPath("$.length()").value(Matchers.greaterThan(0)));
	    }

	    @Test
	    public void testGetTechInterviewById() throws Exception {
	        LOGGER.info("Pulling tech interview by id: {}", testingTechInterview.getId());
	        MvcResult result = mockMvc.perform(get("/api/v1/tech-interviews/{id}", testingTechInterview.getId())
	                .header("Authorization", authorization))
	                .andReturn();

	        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	        Integer readId = JsonPath.read(result.getResponse().getContentAsString(), "$.id");
	        assertEquals(testingTechInterview.getId(), Long.valueOf(readId));
	        assertEquals(testingTechInterview.getInterviewer(), JsonPath.read(result.getResponse().getContentAsString(), "$.interviewer"));
	    }

	    @Test
	    public void testCreateTechInterview() throws Exception {
	        TechInterview techInterview = new TechInterview();
	        techInterview.setInterviewDate(new Date());
	        techInterview.setInterviewer("New Interviewer");
	        techInterview.setInterviewerFeedback("Excellent");
	        techInterview.setCandidateInterviewStatus("Scheduled");

	        MvcResult result = mockMvc.perform(post("/api/v1/tech-interviews")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(techInterview))
	                .header("Authorization", authorization))
	                .andReturn();

	        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	        assertTrue(JsonPath.read(result.getResponse().getContentAsString(), "$.id") != null);
	        assertEquals("New Interviewer", JsonPath.read(result.getResponse().getContentAsString(), "$.interviewer"));
	        assertEquals("Excellent", JsonPath.read(result.getResponse().getContentAsString(), "$.interviewerFeedback"));
	        assertEquals("Scheduled", JsonPath.read(result.getResponse().getContentAsString(), "$.candidateInterviewStatus"));

	        
	        int techInterviewId = JsonPath.read(result.getResponse().getContentAsString(), "$.id");
	        mockMvc.perform(delete("/api/v1/tech-interviews/{id}", techInterviewId)
	                .header("Authorization", authorization))
	                .andExpect(status().isOk());
	    }

	    @Test
	    public void testUpdateTechInterview() throws Exception {
	        String TEST_VALUE = "New Test Value";
	        testingTechInterview.setInterviewer(TEST_VALUE);
	        testingTechInterview.setInterviewerFeedback(TEST_VALUE);
	        LOGGER.info("Testing tech interview update with id: {}", testingTechInterview.getId());
	        ResultActions result = mockMvc.perform(put("/api/v1/tech-interviews/{id}", testingTechInterview.getId())
	                .header("Authorization", authorization)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(testingTechInterview)))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.interviewer").value(TEST_VALUE))
	                .andExpect(jsonPath("$.interviewerFeedback").value(TEST_VALUE));
	    }

	    @Test
	    public void testDeleteTechInterview() throws Exception {
	        Long techInterviewId = testingTechInterview.getId();
	        LOGGER.info("Testing deletion of a tech interview with id: {}", techInterviewId);
	        mockMvc.perform(delete("/api/v1/tech-interviews/{id}", techInterviewId)
	                .header("Authorization", authorization))
	                .andExpect(status().isOk());
	        testingTechInterview = null;
	    }

	    @AfterEach
	    public void cleanUp() throws Exception {
	        if (testingTechInterview != null) {
	            LOGGER.info("Deleting testing tech interview");
	            mockMvc.perform(delete("/api/v1/tech-interviews/{id}", testingTechInterview.getId())
	                    .header("Authorization", authorization))
	                    .andExpect(status().isOk());
	            testingTechInterview = null;
	            
	       

}
	    }
}
	