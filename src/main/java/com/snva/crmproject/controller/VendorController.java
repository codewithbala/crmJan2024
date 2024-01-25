package com.snva.crmproject.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snva.crmproject.entity.Vendor;
import com.snva.crmproject.service.VenderService;

@RestController
@RequestMapping("/api/v1/vendors")
public class VendorController {
	
private static final Logger logger = LoggerFactory.getLogger(VendorController.class);



 @Autowired
VenderService vendorService;
 

	    @GetMapping
	    public ResponseEntity<List<Vendor>> getAllVendors() {
	        try {
	            logger.info("Request to get all vendors");
	            List<Vendor> vendors = vendorService.getAllVendors();
	            return new ResponseEntity<>(vendors, HttpStatus.OK);
	        } catch (Exception e) {
	            logger.error("Error getting all vendors", e);
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
	        try {
	            logger.info("Request to get vendor by ID: {}", id);
	            Vendor vendor = vendorService.getVendorById(id);
	            if (vendor != null) {
	                return new ResponseEntity<>(vendor, HttpStatus.OK);
	            } else {
	                logger.warn("Vendor not found with ID: {}", id);
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            }
	        } catch (Exception e) {
	            logger.error("Error getting vendor by ID: {}", id, e);
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PostMapping
	    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
	        try {
	            logger.info("Request to create a new vendor");
	            Vendor createdVendor = vendorService.createVendor(vendor);
	            return new ResponseEntity<>(createdVendor, HttpStatus.CREATED);
	        } catch (Exception e) {
	            logger.error("Error creating vendor", e);
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Vendor> updateVendor(@PathVariable Long id, @RequestBody Vendor updatedVendor) {
	        try {
	            logger.info("Request to update vendor with ID: {}", id);
	            Vendor updated = vendorService.updateVendor(id, updatedVendor);
	            if (updated != null) {
	                logger.info("Vendor updated successfully with ID: {}", id);
	                return new ResponseEntity<>(updated, HttpStatus.OK);
	            } else {
	                logger.warn("Vendor not found for update with ID: {}", id);
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            }
	        } catch (Exception e) {
	            logger.error("Error updating vendor with ID: {}", id, e);
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteVendor(@PathVariable Long id) {
	        try {
	            logger.info("Request to delete vendor with ID: {}", id);
	            vendorService.deleteVendor(id);
	            logger.info("Vendor deleted successfully with ID: {}", id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (Exception e) {
	            logger.error("Error deleting vendor with ID: {}", id, e);
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}




