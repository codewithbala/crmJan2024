package com.snva.crmproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snva.crmproject.entity.Vendor;
import com.snva.crmproject.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VenderService {
	
	@Autowired
		    private VendorRepository vendorRepository;

		    public List<Vendor> getAllVendors() {
		        return vendorRepository.findAll();
		    }

		    public Vendor getVendorById(Long id) {
		        return vendorRepository.findById(id).orElse(null);
		    }

		    public Vendor createVendor(Vendor vendor) {
		      
		   
		        if (vendor == null) {
		            throw new IllegalArgumentException("Vendor object cannot be null");
		        }

		         return vendorRepository.save(vendor);
		    }

		    public Vendor updateVendor(Long id, Vendor updatedVendor) {
		        Vendor existingVendor = vendorRepository.findById(id).orElse(null);
		        if (existingVendor != null) {
		           
		            existingVendor.setVendorTier(updatedVendor.getVendorTier());
		            existingVendor.setVendorName(updatedVendor.getVendorName());
		            existingVendor.setSpoc(updatedVendor.getSpoc());
		            existingVendor.setPoc(updatedVendor.getPoc());
		            existingVendor.setEmail(updatedVendor.getEmail());
		            existingVendor.setPhone(updatedVendor.getPhone());
		            existingVendor.setState(updatedVendor.getState());
		            existingVendor.setCity(updatedVendor.getCity());

		            return vendorRepository.save(existingVendor);
		        } else {
		            return null; 
		        }
		    }

		    public void deleteVendor(Long id) {
		        vendorRepository.deleteById(id);
		    }
		}

		


