package com.snva.crmproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snva.crmproject.entity.EndClient;
import com.snva.crmproject.service.EndClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {EndClientController.class})
@ExtendWith(SpringExtension.class)
class EndClientControllerTest {
    @Autowired
    private EndClientController endClientController;

    @MockBean
    private EndClientServiceImpl endClientServiceImpl;

    /**
     * Method under test: {@link EndClientController#getAllEndClients()}
     */
    @Test
    void testGetAllEndClients() throws Exception {
        // Arrange
        when(endClientServiceImpl.getAllEndClients()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/end-clients");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(endClientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EndClientController#getEndClientById(Long)}
     */
    @Test
    void testGetEndClientById() throws Exception {
        // Arrange
        EndClient endClient = new EndClient();
        endClient.setCity("Oxford");
        endClient.setEndClient("End Client");
        endClient.setId(1L);
        endClient.setState("MD");
        Optional<EndClient> ofResult = Optional.of(endClient);
        when(endClientServiceImpl.getEndClientById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/end-clients/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(endClientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"endClient\":\"End Client\",\"city\":\"Oxford\",\"state\":\"MD\"}"));
    }

    /**
     * Method under test: {@link EndClientController#getEndClientById(Long)}
     */
   /* @Test
    void testGetEndClientById2() throws Exception {
        // Arrange
        Optional<EndClient> emptyResult = Optional.empty();
        when(endClientServiceImpl.getEndClientById(Mockito.<Long>any())).thenReturn(emptyResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/end-clients/{id}", 1L);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(endClientController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }*/

    /**
     * Method under test: {@link EndClientController#deleteEndClient(Long)}
     */
    @Test
    void testDeleteEndClient() throws Exception {
        // Arrange
        doNothing().when(endClientServiceImpl).deleteEndClient(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/end-clients/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(endClientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link EndClientController#deleteEndClient(Long)}
     */
   /* @Test
    void testDeleteEndClient2() throws Exception {
        // Arrange
        doNothing().when(endClientServiceImpl).deleteEndClient(Mockito.<Long>any());
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(endClientController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }*/

    /**
     * Method under test:
     * {@link EndClientController#updateEndClient(Long, EndClient)}
     */
    @Test
    void testUpdateEndClient() throws Exception {
        // Arrange
        EndClient endClient = new EndClient();
        endClient.setCity("Oxford");
        endClient.setEndClient("End Client");
        endClient.setId(1L);
        endClient.setState("MD");
        Optional<EndClient> ofResult = Optional.of(endClient);
        when(endClientServiceImpl.updateEndClient(Mockito.<Long>any(), Mockito.<EndClient>any())).thenReturn(ofResult);

        EndClient endClient2 = new EndClient();
        endClient2.setCity("Oxford");
        endClient2.setEndClient("End Client");
        endClient2.setId(1L);
        endClient2.setState("MD");
        String content = (new ObjectMapper()).writeValueAsString(endClient2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/end-clients/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(endClientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"endClient\":\"End Client\",\"city\":\"Oxford\",\"state\":\"MD\"}"));
    }

    /**
     * Method under test:
     * {@link EndClientController#updateEndClient(Long, EndClient)}
     */
   /* @Test
    void testUpdateEndClient2() throws Exception {
        // Arrange
        Optional<EndClient> emptyResult = Optional.empty();
        when(endClientServiceImpl.updateEndClient(Mockito.<Long>any(), Mockito.<EndClient>any())).thenReturn(emptyResult);

        EndClient endClient = new EndClient();
        endClient.setCity("Oxford");
        endClient.setEndClient("End Client");
        endClient.setId(1L);
        endClient.setState("MD");
        String content = (new ObjectMapper()).writeValueAsString(endClient);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/end-clients/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(endClientController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }*/

    /**
     * Method under test: {@link EndClientController#saveEndClient(EndClient)}
     */
    @Test
    void testSaveEndClient() throws Exception {
        // Arrange
        when(endClientServiceImpl.getAllEndClients()).thenReturn(new ArrayList<>());

        EndClient endClient = new EndClient();
        endClient.setCity("Oxford");
        endClient.setEndClient("End Client");
        endClient.setId(1L);
        endClient.setState("MD");
        String content = (new ObjectMapper()).writeValueAsString(endClient);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/end-clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(endClientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}
