package com.snva.crmproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.snva.crmproject.entity.Vendor;
import com.snva.crmproject.service.VenderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class VendorControllerTest {
	
	 private MockMvc mockMvc;

	    @Mock
	    private VenderService vendorService;

	    @InjectMocks
	    private VendorController vendorController;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(vendorController).build();
	    }

	    @Test
	    public void testGetAllVendors() throws Exception {
	        // Mock data
	        List<Vendor> vendors = Arrays.asList(
	                new Vendor(1L, "Tier 1", "Vendor 1", "SPOC 1", "POC 1", "email1@example.com", "1234567890", "State 1", "City 1"),
	                new Vendor(2L, "Tier 2", "Vendor 2", "SPOC 2", "POC 2", "email2@example.com", "9876543210", "State 2", "City 2")
	        );

	        when(vendorService.getAllVendors()).thenReturn(vendors);

	        mockMvc.perform(get("/api/v1/vendors"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andExpect(jsonPath("$").isArray())
	                .andExpect(jsonPath("$.length()").value(2))
	                .andExpect(jsonPath("$[0].vendorName").value("Vendor 1"))
	                .andExpect(jsonPath("$[1].vendorName").value("Vendor 2"));

	        verify(vendorService, times(1)).getAllVendors();
	        verifyNoMoreInteractions(vendorService);
	    }

	    @Test
	    public void testGetVendorById() throws Exception {
	    
	    	    long vendorId = 1L;
	    	    Vendor vendor = new Vendor(vendorId, "Tier 1", "Vendor 1", "SPOC 1", "POC 1", "email1@example.com", "1234567890", "State 1", "City 1");

	    	    when(vendorService.getVendorById(vendorId)).thenReturn(vendor);

	    	    mockMvc.perform(get("/api/v1/vendors/{id}", vendorId))
	    	            .andExpect(status().isOk())
	    	            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    	            .andExpect(jsonPath("$.vendorName").value("Vendor 1"))
	    	            .andExpect(jsonPath("$.state").value("State 1"))
	    	            .andExpect(jsonPath("$.city").value("City 1"));

	    	    verify(vendorService, times(1)).getVendorById(vendorId);
	    	    verifyNoMoreInteractions(vendorService);
	    	}

	    

	    @Test
	    public void testCreateVendor() throws Exception {
	        // Mock data
	        Vendor newVendor = new Vendor(null, "Tier 3", "Vendor 3", "SPOC 3", "POC 3", "email3@example.com", "3333333333", "State 3", "City 3");

	        when(vendorService.createVendor(newVendor)).thenReturn(newVendor);

	        mockMvc.perform(post("/api/v1/vendors")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(new ObjectMapper().writeValueAsString(newVendor)))
	                .andExpect(status().isCreated())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andExpect(jsonPath("$.vendorName").value("Vendor 3"))
	                .andExpect(jsonPath("$.phone").value("3333333333"));

	        verify(vendorService, times(1)).createVendor(newVendor);
	        verifyNoMoreInteractions(vendorService);
	    }

	    @Test
	    public void testUpdateVendor() throws Exception {
	    	
	    	    long vendorId = 1L;
	    	    Vendor vendor = new Vendor(vendorId, "Tier 1", "Vendor 1", "SPOC 1", "POC 1", "email1@example.com", "1234567890", "State 1", "City 1");

	    	    when(vendorService.getVendorById(vendorId)).thenReturn(vendor);

	    	    mockMvc.perform(get("/api/v1/vendors/{id}", vendorId))
	    	            .andExpect(status().isOk())
	    	            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    	            .andExpect(jsonPath("$.vendorName").value("Vendor 1"))
	    	            .andExpect(jsonPath("$.state").value("State 1"))
	    	            .andExpect(jsonPath("$.city").value("City 1"));

	    	    verify(vendorService, times(1)).getVendorById(vendorId);
	    	    verifyNoMoreInteractions(vendorService);
	    	}

	    	 @Test
	    public void testDeleteVendor() throws Exception {
	       
	        long vendorId = 1L;

	        mockMvc.perform(delete("/api/v1/vendors/{id}", vendorId))
	                .andExpect(status().isNoContent());

	        verify(vendorService, times(1)).deleteVendor(vendorId);
	        verifyNoMoreInteractions(vendorService);
	    }

	  

	}




