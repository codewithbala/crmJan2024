package com.snva.crmproject.controller;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snva.crmproject.entity.EndClient;
import com.snva.crmproject.service.EndClientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/v1/end-clients")
public class EndClientController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EndClientController.class);

	@Autowired
	private EndClientService endClientService;

	@GetMapping
	public List<EndClient> getAllEndClients() {
		LOGGER.info("Getting all End Clients");
		return endClientService.getAllEndClients();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EndClient> getEndClientById(@PathVariable Long id) {
		LOGGER.info("Getting End Client by ID: {}", id);
		Optional<EndClient> endClient = endClientService.getEndClientById(id);
		return endClient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public EndClient saveEndClient(@RequestBody EndClient endClient) {
		LOGGER.info("Saving End Client");
		return endClientService.saveEndClient(endClient);
	}

	@DeleteMapping("/{id}")
	public void deleteEndClient(@PathVariable Long id) {
		LOGGER.info("Deleting End Client by ID: {}", id);
		endClientService.deleteEndClient(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EndClient> updateEndClient(@PathVariable Long id, @RequestBody EndClient updatedEndClient) {
		LOGGER.info("Updating End Client with ID: {}", id);
		Optional<EndClient> endClient = endClientService.updateEndClient(id, updatedEndClient);
		return endClient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}
