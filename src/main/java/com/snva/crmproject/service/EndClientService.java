package com.snva.crmproject.service;

import java.util.List;
import java.util.Optional;

import com.snva.crmproject.entity.EndClient;

public interface EndClientService {

	List<EndClient> getAllEndClients();

	Optional<EndClient> getEndClientById(Long id);

	EndClient saveEndClient(EndClient endClient);

	void deleteEndClient(Long id);

	Optional<EndClient> updateEndClient(Long id, EndClient updatedEndClient);

}