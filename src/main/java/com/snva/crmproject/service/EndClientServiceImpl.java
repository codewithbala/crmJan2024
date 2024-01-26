package com.snva.crmproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.snva.crmproject.entity.EndClient;
import com.snva.crmproject.repository.EndClientRepository;

import org.springframework.stereotype.Service;

@Service
public class EndClientServiceImpl implements EndClientService {

	@Autowired
	EndClientRepository endClientRepository;

	@Override
	public List<EndClient> getAllEndClients() {

		return endClientRepository.findAll();
	}

	@Override
	public Optional<EndClient> getEndClientById(Long id) {

		return endClientRepository.findById(id);
	}

	@Override
	public EndClient saveEndClient(EndClient endClient) {
		return endClientRepository.save(endClient);
	}

	@Override
	public void deleteEndClient(Long id) {
		endClientRepository.deleteById(id);

	}

	@Override
	public Optional<EndClient> updateEndClient(Long id, EndClient updatedEndClient) {
		Optional<EndClient> existingEndClient = getEndClientById(id);
		if (existingEndClient.isPresent()) {
			EndClient endClient = existingEndClient.get();
			endClient.setEndClient(updatedEndClient.getEndClient());
			endClient.setCity(updatedEndClient.getCity());
			endClient.setState(updatedEndClient.getState());
			return Optional.of(saveEndClient(endClient));
		}
		return Optional.empty();
	}

}
