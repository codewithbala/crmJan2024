package com.snva.crmproject.service;

import java.util.List;
import java.util.Optional;

import com.snva.crmproject.entity.Vendor;

public interface VenderService {
	
        List<Vendor> getAllVendors();

	   Vendor getVendorById(Long id);

	    Vendor createVendor(Vendor vendor);
	  
	  Vendor updateVendor(Long id, Vendor updatedVendor);
	    void deleteVendor(Long id);
	}



