package com.snva.crmproject.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snva.crmproject.entity.CandidateDetails;
import com.snva.crmproject.entity.LetterOfIntent;
import com.snva.crmproject.service.LetterOfIntentService;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {LetterOfIntentController.class})
@ExtendWith(SpringExtension.class)
class LetterOfIntentControllerDiffblueTest {
  @Autowired
  private LetterOfIntentController letterOfIntentController;

  @MockBean
  private LetterOfIntentService letterOfIntentService;

  /**
   * Method under test: {@link LetterOfIntentController#getAllLettersOfIntent()}
   */
  @Test
  void testGetAllLettersOfIntent() throws Exception {
    // Arrange
    when(letterOfIntentService.getAllLettersOfIntent()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/letter-of-intent");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(letterOfIntentController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link LetterOfIntentController#getAllLettersOfIntent()}
   */
  @Test
  void testGetAllLettersOfIntent2() throws Exception {
    // Arrange
    CandidateDetails candidateDetails = new CandidateDetails();
    candidateDetails.setAddressCity("42 Main St");
    candidateDetails.setAddressCounty("42 Main St");
    candidateDetails.setAddressLine1("42 Main St");
    candidateDetails.setAddressLine2("42 Main St");
    candidateDetails.setAddressState("42 Main St");
    candidateDetails.setAddressZipCode("42 Main St");
    candidateDetails.setCandidateId("2020-03-01");
    candidateDetails.setCandidateInterviewStatus("2020-03-01");
    candidateDetails.setCommunicationSkill(1);
    candidateDetails.setInterviewDate("2020-03-01");
    candidateDetails.setInterviewer("Getting all Letters of Intent");
    candidateDetails.setInterviewerFeedback("Getting all Letters of Intent");
    candidateDetails.setJoinedBatch(true);
    candidateDetails.setLOIAccepted(true);
    candidateDetails.setLOISent(true);
    candidateDetails.setRemarks("Getting all Letters of Intent");
    candidateDetails.setSkillSet("Getting all Letters of Intent");
    candidateDetails.setSource("Getting all Letters of Intent");
    candidateDetails.setStartDate("2020-03-01");

    LetterOfIntent letterOfIntent = new LetterOfIntent();
    letterOfIntent.setCandidateDetails(candidateDetails);
    letterOfIntent.setCandidateId("2020-03-01");
    letterOfIntent.setId(1L);
    letterOfIntent.setJoinedBatch(true);
    letterOfIntent.setStartDate("2020-03-01");
    letterOfIntent.setlOIAccepted(true);
    letterOfIntent.setlOISent(true);

    ArrayList<LetterOfIntent> letterOfIntentList = new ArrayList<>();
    letterOfIntentList.add(letterOfIntent);
    when(letterOfIntentService.getAllLettersOfIntent()).thenReturn(letterOfIntentList);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/letter-of-intent");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(letterOfIntentController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "[{\"id\":1,\"candidateId\":\"2020-03-01\",\"lOISent\":true,\"lOIAccepted\":true,\"joinedBatch\":true,\"startDate\""
                                    + ":\"2020-03-01\",\"candidateDetails\":{\"candidateId\":\"2020-03-01\",\"skillSet\":\"Getting all Letters of"
                                    + " Intent\",\"communicationSkill\":1,\"addressLine1\":\"42 Main St\",\"addressLine2\":\"42 Main St\",\"addressCity\":\"42"
                                    + " Main St\",\"addressState\":\"42 Main St\",\"addressCounty\":\"42 Main St\",\"addressZipCode\":\"42 Main"
                                    + " St\",\"source\":\"Getting all Letters of Intent\",\"remarks\":\"Getting all Letters of Intent\",\"interviewDate"
                                    + "\":\"2020-03-01\",\"interviewer\":\"Getting all Letters of Intent\",\"interviewerFeedback\":\"Getting all Letters"
                                    + " of Intent\",\"candidateInterviewStatus\":\"2020-03-01\",\"joinedBatch\":true,\"startDate\":\"2020-03-01\","
                                    + "\"loiaccepted\":true,\"loisent\":true}}]"));
  }

  /**
   * Method under test: {@link LetterOfIntentController#getAllLettersOfIntent()}
   */
  @Test
  void testGetAllLettersOfIntent3() throws Exception {
    // Arrange
    CandidateDetails candidateDetails = new CandidateDetails();
    candidateDetails.setAddressCity("42 Main St");
    candidateDetails.setAddressCounty("42 Main St");
    candidateDetails.setAddressLine1("42 Main St");
    candidateDetails.setAddressLine2("42 Main St");
    candidateDetails.setAddressState("42 Main St");
    candidateDetails.setAddressZipCode("42 Main St");
    candidateDetails.setCandidateId("2020-03-01");
    candidateDetails.setCandidateInterviewStatus("2020-03-01");
    candidateDetails.setCommunicationSkill(1);
    candidateDetails.setInterviewDate("2020-03-01");
    candidateDetails.setInterviewer("Getting all Letters of Intent");
    candidateDetails.setInterviewerFeedback("Getting all Letters of Intent");
    candidateDetails.setJoinedBatch(true);
    candidateDetails.setLOIAccepted(true);
    candidateDetails.setLOISent(true);
    candidateDetails.setRemarks("Getting all Letters of Intent");
    candidateDetails.setSkillSet("Getting all Letters of Intent");
    candidateDetails.setSource("Getting all Letters of Intent");
    candidateDetails.setStartDate("2020-03-01");

    LetterOfIntent letterOfIntent = new LetterOfIntent();
    letterOfIntent.setCandidateDetails(candidateDetails);
    letterOfIntent.setCandidateId("2020-03-01");
    letterOfIntent.setId(1L);
    letterOfIntent.setJoinedBatch(true);
    letterOfIntent.setStartDate("2020-03-01");
    letterOfIntent.setlOIAccepted(true);
    letterOfIntent.setlOISent(true);

    CandidateDetails candidateDetails2 = new CandidateDetails();
    candidateDetails2.setAddressCity("17 High St");
    candidateDetails2.setAddressCounty("17 High St");
    candidateDetails2.setAddressLine1("17 High St");
    candidateDetails2.setAddressLine2("17 High St");
    candidateDetails2.setAddressState("17 High St");
    candidateDetails2.setAddressZipCode("17 High St");
    candidateDetails2.setCandidateId("2020/03/01");
    candidateDetails2.setCandidateInterviewStatus("2020/03/01");
    candidateDetails2.setCommunicationSkill(1);
    candidateDetails2.setInterviewDate("2020/03/01");
    candidateDetails2.setInterviewer("Interviewer");
    candidateDetails2.setInterviewerFeedback("Interviewer Feedback");
    candidateDetails2.setJoinedBatch(false);
    candidateDetails2.setLOIAccepted(false);
    candidateDetails2.setLOISent(false);
    candidateDetails2.setRemarks("Remarks");
    candidateDetails2.setSkillSet("Skill Set");
    candidateDetails2.setSource("Source");
    candidateDetails2.setStartDate("2020/03/01");

    LetterOfIntent letterOfIntent2 = new LetterOfIntent();
    letterOfIntent2.setCandidateDetails(candidateDetails2);
    letterOfIntent2.setCandidateId("2020/03/01");
    letterOfIntent2.setId(2L);
    letterOfIntent2.setJoinedBatch(false);
    letterOfIntent2.setStartDate("2020/03/01");
    letterOfIntent2.setlOIAccepted(false);
    letterOfIntent2.setlOISent(false);

    ArrayList<LetterOfIntent> letterOfIntentList = new ArrayList<>();
    letterOfIntentList.add(letterOfIntent2);
    letterOfIntentList.add(letterOfIntent);
    when(letterOfIntentService.getAllLettersOfIntent()).thenReturn(letterOfIntentList);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/letter-of-intent");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(letterOfIntentController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "[{\"id\":2,\"candidateId\":\"2020/03/01\",\"lOISent\":false,\"lOIAccepted\":false,\"joinedBatch\":false,\"startDate"
                                    + "\":\"2020/03/01\",\"candidateDetails\":{\"candidateId\":\"2020/03/01\",\"skillSet\":\"Skill Set\",\"communicationSkill"
                                    + "\":1,\"addressLine1\":\"17 High St\",\"addressLine2\":\"17 High St\",\"addressCity\":\"17 High St\",\"addressState\":\"17"
                                    + " High St\",\"addressCounty\":\"17 High St\",\"addressZipCode\":\"17 High St\",\"source\":\"Source\",\"remarks\":"
                                    + "\"Remarks\",\"interviewDate\":\"2020/03/01\",\"interviewer\":\"Interviewer\",\"interviewerFeedback\":\"Interviewer"
                                    + " Feedback\",\"candidateInterviewStatus\":\"2020/03/01\",\"joinedBatch\":false,\"startDate\":\"2020/03/01\","
                                    + "\"loiaccepted\":false,\"loisent\":false}},{\"id\":1,\"candidateId\":\"2020-03-01\",\"lOISent\":true,\"lOIAccepted"
                                    + "\":true,\"joinedBatch\":true,\"startDate\":\"2020-03-01\",\"candidateDetails\":{\"candidateId\":\"2020-03-01\","
                                    + "\"skillSet\":\"Getting all Letters of Intent\",\"communicationSkill\":1,\"addressLine1\":\"42 Main St\","
                                    + "\"addressLine2\":\"42 Main St\",\"addressCity\":\"42 Main St\",\"addressState\":\"42 Main St\",\"addressCounty\":\"42"
                                    + " Main St\",\"addressZipCode\":\"42 Main St\",\"source\":\"Getting all Letters of Intent\",\"remarks\":\"Getting"
                                    + " all Letters of Intent\",\"interviewDate\":\"2020-03-01\",\"interviewer\":\"Getting all Letters of Intent\","
                                    + "\"interviewerFeedback\":\"Getting all Letters of Intent\",\"candidateInterviewStatus\":\"2020-03-01\",\"joinedBatch"
                                    + "\":true,\"startDate\":\"2020-03-01\",\"loiaccepted\":true,\"loisent\":true}}]"));
  }

  /**
   * Method under test:
   * {@link LetterOfIntentController#getLetterOfIntentById(Long)}
   */
  @Test
  void testGetLetterOfIntentById() throws Exception {
    // Arrange
    CandidateDetails candidateDetails = new CandidateDetails();
    candidateDetails.setAddressCity("42 Main St");
    candidateDetails.setAddressCounty("42 Main St");
    candidateDetails.setAddressLine1("42 Main St");
    candidateDetails.setAddressLine2("42 Main St");
    candidateDetails.setAddressState("42 Main St");
    candidateDetails.setAddressZipCode("42 Main St");
    candidateDetails.setCandidateId("2020-03-01");
    candidateDetails.setCandidateInterviewStatus("2020-03-01");
    candidateDetails.setCommunicationSkill(1);
    candidateDetails.setInterviewDate("2020-03-01");
    candidateDetails.setInterviewer("Interviewer");
    candidateDetails.setInterviewerFeedback("Interviewer Feedback");
    candidateDetails.setJoinedBatch(true);
    candidateDetails.setLOIAccepted(true);
    candidateDetails.setLOISent(true);
    candidateDetails.setRemarks("Remarks");
    candidateDetails.setSkillSet("Skill Set");
    candidateDetails.setSource("Source");
    candidateDetails.setStartDate("2020-03-01");

    LetterOfIntent letterOfIntent = new LetterOfIntent();
    letterOfIntent.setCandidateDetails(candidateDetails);
    letterOfIntent.setCandidateId("2020-03-01");
    letterOfIntent.setId(1L);
    letterOfIntent.setJoinedBatch(true);
    letterOfIntent.setStartDate("2020-03-01");
    letterOfIntent.setlOIAccepted(true);
    letterOfIntent.setlOISent(true);
    Optional<LetterOfIntent> ofResult = Optional.of(letterOfIntent);
    when(letterOfIntentService.getLetterOfIntentById(Mockito.<Long>any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/letter-of-intent/{id}", 1L);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(letterOfIntentController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "{\"id\":1,\"candidateId\":\"2020-03-01\",\"lOISent\":true,\"lOIAccepted\":true,\"joinedBatch\":true,\"startDate\":"
                                    + "\"2020-03-01\",\"candidateDetails\":{\"candidateId\":\"2020-03-01\",\"skillSet\":\"Skill Set\",\"communicationSkill"
                                    + "\":1,\"addressLine1\":\"42 Main St\",\"addressLine2\":\"42 Main St\",\"addressCity\":\"42 Main St\",\"addressState\":\"42"
                                    + " Main St\",\"addressCounty\":\"42 Main St\",\"addressZipCode\":\"42 Main St\",\"source\":\"Source\",\"remarks\":"
                                    + "\"Remarks\",\"interviewDate\":\"2020-03-01\",\"interviewer\":\"Interviewer\",\"interviewerFeedback\":\"Interviewer"
                                    + " Feedback\",\"candidateInterviewStatus\":\"2020-03-01\",\"joinedBatch\":true,\"startDate\":\"2020-03-01\","
                                    + "\"loiaccepted\":true,\"loisent\":true}}"));
  }

  /**
   * Method under test:
   * {@link LetterOfIntentController#getLetterOfIntentById(Long)}
   */
  @Test
  void testGetLetterOfIntentById2() throws Exception {
    // Arrange
    CandidateDetails candidateDetails = new CandidateDetails();
    candidateDetails.setAddressCity("42 Main St");
    candidateDetails.setAddressCounty("42 Main St");
    candidateDetails.setAddressLine1("42 Main St");
    candidateDetails.setAddressLine2("42 Main St");
    candidateDetails.setAddressState("42 Main St");
    candidateDetails.setAddressZipCode("42 Main St");
    candidateDetails.setCandidateId("2020-03-01");
    candidateDetails.setCandidateInterviewStatus("2020-03-01");
    candidateDetails.setCommunicationSkill(1);
    candidateDetails.setInterviewDate("2020-03-01");
    candidateDetails.setInterviewer("Interviewer");
    candidateDetails.setInterviewerFeedback("Interviewer Feedback");
    candidateDetails.setJoinedBatch(true);
    candidateDetails.setLOIAccepted(true);
    candidateDetails.setLOISent(true);
    candidateDetails.setRemarks("Remarks");
    candidateDetails.setSkillSet("Skill Set");
    candidateDetails.setSource("Source");
    candidateDetails.setStartDate("2020-03-01");

    LetterOfIntent letterOfIntent = new LetterOfIntent();
    letterOfIntent.setCandidateDetails(candidateDetails);
    letterOfIntent.setCandidateId("2020-03-01");
    letterOfIntent.setId(1L);
    letterOfIntent.setJoinedBatch(false);
    letterOfIntent.setStartDate("2020-03-01");
    letterOfIntent.setlOIAccepted(true);
    letterOfIntent.setlOISent(true);
    Optional<LetterOfIntent> ofResult = Optional.of(letterOfIntent);
    when(letterOfIntentService.getLetterOfIntentById(Mockito.<Long>any())).thenReturn(ofResult);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/letter-of-intent/{id}", 1L);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(letterOfIntentController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "{\"id\":1,\"candidateId\":\"2020-03-01\",\"lOISent\":true,\"lOIAccepted\":true,\"joinedBatch\":false,\"startDate\""
                                    + ":\"2020-03-01\",\"candidateDetails\":{\"candidateId\":\"2020-03-01\",\"skillSet\":\"Skill Set\",\"communicationSkill"
                                    + "\":1,\"addressLine1\":\"42 Main St\",\"addressLine2\":\"42 Main St\",\"addressCity\":\"42 Main St\",\"addressState\":\"42"
                                    + " Main St\",\"addressCounty\":\"42 Main St\",\"addressZipCode\":\"42 Main St\",\"source\":\"Source\",\"remarks\":"
                                    + "\"Remarks\",\"interviewDate\":\"2020-03-01\",\"interviewer\":\"Interviewer\",\"interviewerFeedback\":\"Interviewer"
                                    + " Feedback\",\"candidateInterviewStatus\":\"2020-03-01\",\"joinedBatch\":true,\"startDate\":\"2020-03-01\","
                                    + "\"loiaccepted\":true,\"loisent\":true}}"));
  }

  /**
   * Method under test:
   * {@link LetterOfIntentController#deleteLetterOfIntent(Long)}
   */
  @Test
  void testDeleteLetterOfIntent() throws Exception {
    // Arrange
    doNothing().when(letterOfIntentService).deleteLetterOfIntent(Mockito.<Long>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/letter-of-intent/{id}", 1L);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(letterOfIntentController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Method under test:
   * {@link LetterOfIntentController#deleteLetterOfIntent(Long)}
   */
  @Test
  void testDeleteLetterOfIntent2() throws Exception {
    // Arrange
    doNothing().when(letterOfIntentService).deleteLetterOfIntent(Mockito.<Long>any());
    SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(letterOfIntentController)
            .build()
            .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Method under test:
   * {@link LetterOfIntentController#updateLetterOfIntent(Long, LetterOfIntent)}
   */
  @Test
  void testUpdateLetterOfIntent() throws Exception {
    // Arrange
    when(letterOfIntentService.updateLetterOfIntent(Mockito.<Long>any(), Mockito.<LetterOfIntent>any()))
            .thenReturn(null);

    CandidateDetails candidateDetails = new CandidateDetails();
    candidateDetails.setAddressCity("42 Main St");
    candidateDetails.setAddressCounty("42 Main St");
    candidateDetails.setAddressLine1("42 Main St");
    candidateDetails.setAddressLine2("42 Main St");
    candidateDetails.setAddressState("42 Main St");
    candidateDetails.setAddressZipCode("42 Main St");
    candidateDetails.setCandidateId("2020-03-01");
    candidateDetails.setCandidateInterviewStatus("2020-03-01");
    candidateDetails.setCommunicationSkill(1);
    candidateDetails.setInterviewDate("2020-03-01");
    candidateDetails.setInterviewer("Interviewer");
    candidateDetails.setInterviewerFeedback("Interviewer Feedback");
    candidateDetails.setJoinedBatch(true);
    candidateDetails.setLOIAccepted(true);
    candidateDetails.setLOISent(true);
    candidateDetails.setRemarks("Remarks");
    candidateDetails.setSkillSet("Skill Set");
    candidateDetails.setSource("Source");
    candidateDetails.setStartDate("2020-03-01");

    LetterOfIntent letterOfIntent = new LetterOfIntent();
    letterOfIntent.setCandidateDetails(candidateDetails);
    letterOfIntent.setCandidateId("2020-03-01");
    letterOfIntent.setId(1L);
    letterOfIntent.setJoinedBatch(true);
    letterOfIntent.setStartDate("2020-03-01");
    letterOfIntent.setlOIAccepted(true);
    letterOfIntent.setlOISent(true);
    String content = (new ObjectMapper()).writeValueAsString(letterOfIntent);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/letter-of-intent/{id}", 1L)
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(letterOfIntentController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Method under test:
   * {@link LetterOfIntentController#saveLetterOfIntent(LetterOfIntent)}
   */
  @Test
  void testSaveLetterOfIntent() throws Exception {
    // Arrange
    when(letterOfIntentService.getAllLettersOfIntent()).thenReturn(new ArrayList<>());

    CandidateDetails candidateDetails = new CandidateDetails();
    candidateDetails.setAddressCity("42 Main St");
    candidateDetails.setAddressCounty("42 Main St");
    candidateDetails.setAddressLine1("42 Main St");
    candidateDetails.setAddressLine2("42 Main St");
    candidateDetails.setAddressState("42 Main St");
    candidateDetails.setAddressZipCode("42 Main St");
    candidateDetails.setCandidateId("2020-03-01");
    candidateDetails.setCandidateInterviewStatus("2020-03-01");
    candidateDetails.setCommunicationSkill(1);
    candidateDetails.setInterviewDate("2020-03-01");
    candidateDetails.setInterviewer("Interviewer");
    candidateDetails.setInterviewerFeedback("Interviewer Feedback");
    candidateDetails.setJoinedBatch(true);
    candidateDetails.setLOIAccepted(true);
    candidateDetails.setLOISent(true);
    candidateDetails.setRemarks("Remarks");
    candidateDetails.setSkillSet("Skill Set");
    candidateDetails.setSource("Source");
    candidateDetails.setStartDate("2020-03-01");

    LetterOfIntent letterOfIntent = new LetterOfIntent();
    letterOfIntent.setCandidateDetails(candidateDetails);
    letterOfIntent.setCandidateId("2020-03-01");
    letterOfIntent.setId(1L);
    letterOfIntent.setJoinedBatch(true);
    letterOfIntent.setStartDate("2020-03-01");
    letterOfIntent.setlOIAccepted(true);
    letterOfIntent.setlOISent(true);
    String content = (new ObjectMapper()).writeValueAsString(letterOfIntent);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/letter-of-intent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(letterOfIntentController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test:
   * {@link LetterOfIntentController#saveLetterOfIntent(LetterOfIntent)}
   */
  @Test
  void testSaveLetterOfIntent2() throws Exception {
    // Arrange
    CandidateDetails candidateDetails = new CandidateDetails();
    candidateDetails.setAddressCity("42 Main St");
    candidateDetails.setAddressCounty("42 Main St");
    candidateDetails.setAddressLine1("42 Main St");
    candidateDetails.setAddressLine2("42 Main St");
    candidateDetails.setAddressState("42 Main St");
    candidateDetails.setAddressZipCode("42 Main St");
    candidateDetails.setCandidateId("2020-03-01");
    candidateDetails.setCandidateInterviewStatus("2020-03-01");
    candidateDetails.setCommunicationSkill(1);
    candidateDetails.setInterviewDate("2020-03-01");
    candidateDetails.setInterviewer("Getting all Letters of Intent");
    candidateDetails.setInterviewerFeedback("Getting all Letters of Intent");
    candidateDetails.setJoinedBatch(true);
    candidateDetails.setLOIAccepted(true);
    candidateDetails.setLOISent(true);
    candidateDetails.setRemarks("Getting all Letters of Intent");
    candidateDetails.setSkillSet("Getting all Letters of Intent");
    candidateDetails.setSource("Getting all Letters of Intent");
    candidateDetails.setStartDate("2020-03-01");

    LetterOfIntent letterOfIntent = new LetterOfIntent();
    letterOfIntent.setCandidateDetails(candidateDetails);
    letterOfIntent.setCandidateId("2020-03-01");
    letterOfIntent.setId(1L);
    letterOfIntent.setJoinedBatch(true);
    letterOfIntent.setStartDate("2020-03-01");
    letterOfIntent.setlOIAccepted(true);
    letterOfIntent.setlOISent(true);

    ArrayList<LetterOfIntent> letterOfIntentList = new ArrayList<>();
    letterOfIntentList.add(letterOfIntent);
    when(letterOfIntentService.getAllLettersOfIntent()).thenReturn(letterOfIntentList);

    CandidateDetails candidateDetails2 = new CandidateDetails();
    candidateDetails2.setAddressCity("42 Main St");
    candidateDetails2.setAddressCounty("42 Main St");
    candidateDetails2.setAddressLine1("42 Main St");
    candidateDetails2.setAddressLine2("42 Main St");
    candidateDetails2.setAddressState("42 Main St");
    candidateDetails2.setAddressZipCode("42 Main St");
    candidateDetails2.setCandidateId("2020-03-01");
    candidateDetails2.setCandidateInterviewStatus("2020-03-01");
    candidateDetails2.setCommunicationSkill(1);
    candidateDetails2.setInterviewDate("2020-03-01");
    candidateDetails2.setInterviewer("Interviewer");
    candidateDetails2.setInterviewerFeedback("Interviewer Feedback");
    candidateDetails2.setJoinedBatch(true);
    candidateDetails2.setLOIAccepted(true);
    candidateDetails2.setLOISent(true);
    candidateDetails2.setRemarks("Remarks");
    candidateDetails2.setSkillSet("Skill Set");
    candidateDetails2.setSource("Source");
    candidateDetails2.setStartDate("2020-03-01");

    LetterOfIntent letterOfIntent2 = new LetterOfIntent();
    letterOfIntent2.setCandidateDetails(candidateDetails2);
    letterOfIntent2.setCandidateId("2020-03-01");
    letterOfIntent2.setId(1L);
    letterOfIntent2.setJoinedBatch(true);
    letterOfIntent2.setStartDate("2020-03-01");
    letterOfIntent2.setlOIAccepted(true);
    letterOfIntent2.setlOISent(true);
    String content = (new ObjectMapper()).writeValueAsString(letterOfIntent2);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/letter-of-intent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(letterOfIntentController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "[{\"id\":1,\"candidateId\":\"2020-03-01\",\"lOISent\":true,\"lOIAccepted\":true,\"joinedBatch\":true,\"startDate\""
                                    + ":\"2020-03-01\",\"candidateDetails\":{\"candidateId\":\"2020-03-01\",\"skillSet\":\"Getting all Letters of"
                                    + " Intent\",\"communicationSkill\":1,\"addressLine1\":\"42 Main St\",\"addressLine2\":\"42 Main St\",\"addressCity\":\"42"
                                    + " Main St\",\"addressState\":\"42 Main St\",\"addressCounty\":\"42 Main St\",\"addressZipCode\":\"42 Main"
                                    + " St\",\"source\":\"Getting all Letters of Intent\",\"remarks\":\"Getting all Letters of Intent\",\"interviewDate"
                                    + "\":\"2020-03-01\",\"interviewer\":\"Getting all Letters of Intent\",\"interviewerFeedback\":\"Getting all Letters"
                                    + " of Intent\",\"candidateInterviewStatus\":\"2020-03-01\",\"joinedBatch\":true,\"startDate\":\"2020-03-01\","
                                    + "\"loiaccepted\":true,\"loisent\":true}}]"));
  }

  /**
   * Method under test:
   * {@link LetterOfIntentController#saveLetterOfIntent(LetterOfIntent)}
   */
  @Test
  void testSaveLetterOfIntent3() throws Exception {
    // Arrange
    CandidateDetails candidateDetails = new CandidateDetails();
    candidateDetails.setAddressCity("42 Main St");
    candidateDetails.setAddressCounty("42 Main St");
    candidateDetails.setAddressLine1("42 Main St");
    candidateDetails.setAddressLine2("42 Main St");
    candidateDetails.setAddressState("42 Main St");
    candidateDetails.setAddressZipCode("42 Main St");
    candidateDetails.setCandidateId("2020-03-01");
    candidateDetails.setCandidateInterviewStatus("2020-03-01");
    candidateDetails.setCommunicationSkill(1);
    candidateDetails.setInterviewDate("2020-03-01");
    candidateDetails.setInterviewer("Getting all Letters of Intent");
    candidateDetails.setInterviewerFeedback("Getting all Letters of Intent");
    candidateDetails.setJoinedBatch(true);
    candidateDetails.setLOIAccepted(true);
    candidateDetails.setLOISent(true);
    candidateDetails.setRemarks("Getting all Letters of Intent");
    candidateDetails.setSkillSet("Getting all Letters of Intent");
    candidateDetails.setSource("Getting all Letters of Intent");
    candidateDetails.setStartDate("2020-03-01");

    LetterOfIntent letterOfIntent = new LetterOfIntent();
    letterOfIntent.setCandidateDetails(candidateDetails);
    letterOfIntent.setCandidateId("2020-03-01");
    letterOfIntent.setId(1L);
    letterOfIntent.setJoinedBatch(true);
    letterOfIntent.setStartDate("2020-03-01");
    letterOfIntent.setlOIAccepted(true);
    letterOfIntent.setlOISent(true);

    CandidateDetails candidateDetails2 = new CandidateDetails();
    candidateDetails2.setAddressCity("17 High St");
    candidateDetails2.setAddressCounty("17 High St");
    candidateDetails2.setAddressLine1("17 High St");
    candidateDetails2.setAddressLine2("17 High St");
    candidateDetails2.setAddressState("17 High St");
    candidateDetails2.setAddressZipCode("17 High St");
    candidateDetails2.setCandidateId("2020/03/01");
    candidateDetails2.setCandidateInterviewStatus("2020/03/01");
    candidateDetails2.setCommunicationSkill(1);
    candidateDetails2.setInterviewDate("2020/03/01");
    candidateDetails2.setInterviewer("Interviewer");
    candidateDetails2.setInterviewerFeedback("Interviewer Feedback");
    candidateDetails2.setJoinedBatch(false);
    candidateDetails2.setLOIAccepted(false);
    candidateDetails2.setLOISent(false);
    candidateDetails2.setRemarks("Remarks");
    candidateDetails2.setSkillSet("Skill Set");
    candidateDetails2.setSource("Source");
    candidateDetails2.setStartDate("2020/03/01");

    LetterOfIntent letterOfIntent2 = new LetterOfIntent();
    letterOfIntent2.setCandidateDetails(candidateDetails2);
    letterOfIntent2.setCandidateId("2020/03/01");
    letterOfIntent2.setId(2L);
    letterOfIntent2.setJoinedBatch(false);
    letterOfIntent2.setStartDate("2020/03/01");
    letterOfIntent2.setlOIAccepted(false);
    letterOfIntent2.setlOISent(false);

    ArrayList<LetterOfIntent> letterOfIntentList = new ArrayList<>();
    letterOfIntentList.add(letterOfIntent2);
    letterOfIntentList.add(letterOfIntent);
    when(letterOfIntentService.getAllLettersOfIntent()).thenReturn(letterOfIntentList);

    CandidateDetails candidateDetails3 = new CandidateDetails();
    candidateDetails3.setAddressCity("42 Main St");
    candidateDetails3.setAddressCounty("42 Main St");
    candidateDetails3.setAddressLine1("42 Main St");
    candidateDetails3.setAddressLine2("42 Main St");
    candidateDetails3.setAddressState("42 Main St");
    candidateDetails3.setAddressZipCode("42 Main St");
    candidateDetails3.setCandidateId("2020-03-01");
    candidateDetails3.setCandidateInterviewStatus("2020-03-01");
    candidateDetails3.setCommunicationSkill(1);
    candidateDetails3.setInterviewDate("2020-03-01");
    candidateDetails3.setInterviewer("Interviewer");
    candidateDetails3.setInterviewerFeedback("Interviewer Feedback");
    candidateDetails3.setJoinedBatch(true);
    candidateDetails3.setLOIAccepted(true);
    candidateDetails3.setLOISent(true);
    candidateDetails3.setRemarks("Remarks");
    candidateDetails3.setSkillSet("Skill Set");
    candidateDetails3.setSource("Source");
    candidateDetails3.setStartDate("2020-03-01");

    LetterOfIntent letterOfIntent3 = new LetterOfIntent();
    letterOfIntent3.setCandidateDetails(candidateDetails3);
    letterOfIntent3.setCandidateId("2020-03-01");
    letterOfIntent3.setId(1L);
    letterOfIntent3.setJoinedBatch(true);
    letterOfIntent3.setStartDate("2020-03-01");
    letterOfIntent3.setlOIAccepted(true);
    letterOfIntent3.setlOISent(true);
    String content = (new ObjectMapper()).writeValueAsString(letterOfIntent3);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/letter-of-intent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(letterOfIntentController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content()
                    .string(
                            "[{\"id\":2,\"candidateId\":\"2020/03/01\",\"lOISent\":false,\"lOIAccepted\":false,\"joinedBatch\":false,\"startDate"
                                    + "\":\"2020/03/01\",\"candidateDetails\":{\"candidateId\":\"2020/03/01\",\"skillSet\":\"Skill Set\",\"communicationSkill"
                                    + "\":1,\"addressLine1\":\"17 High St\",\"addressLine2\":\"17 High St\",\"addressCity\":\"17 High St\",\"addressState\":\"17"
                                    + " High St\",\"addressCounty\":\"17 High St\",\"addressZipCode\":\"17 High St\",\"source\":\"Source\",\"remarks\":"
                                    + "\"Remarks\",\"interviewDate\":\"2020/03/01\",\"interviewer\":\"Interviewer\",\"interviewerFeedback\":\"Interviewer"
                                    + " Feedback\",\"candidateInterviewStatus\":\"2020/03/01\",\"joinedBatch\":false,\"startDate\":\"2020/03/01\","
                                    + "\"loiaccepted\":false,\"loisent\":false}},{\"id\":1,\"candidateId\":\"2020-03-01\",\"lOISent\":true,\"lOIAccepted"
                                    + "\":true,\"joinedBatch\":true,\"startDate\":\"2020-03-01\",\"candidateDetails\":{\"candidateId\":\"2020-03-01\","
                                    + "\"skillSet\":\"Getting all Letters of Intent\",\"communicationSkill\":1,\"addressLine1\":\"42 Main St\","
                                    + "\"addressLine2\":\"42 Main St\",\"addressCity\":\"42 Main St\",\"addressState\":\"42 Main St\",\"addressCounty\":\"42"
                                    + " Main St\",\"addressZipCode\":\"42 Main St\",\"source\":\"Getting all Letters of Intent\",\"remarks\":\"Getting"
                                    + " all Letters of Intent\",\"interviewDate\":\"2020-03-01\",\"interviewer\":\"Getting all Letters of Intent\","
                                    + "\"interviewerFeedback\":\"Getting all Letters of Intent\",\"candidateInterviewStatus\":\"2020-03-01\",\"joinedBatch"
                                    + "\":true,\"startDate\":\"2020-03-01\",\"loiaccepted\":true,\"loisent\":true}}]"));
  }
}
