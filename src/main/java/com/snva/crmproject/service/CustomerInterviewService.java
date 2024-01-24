package com.snva.crmproject.service;

import com.snva.crmproject.entity.customerInterview.CustomerInterview;
import com.snva.crmproject.repository.customerInterview.CustomerInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerInterviewService {
    private final CustomerInterviewRepository customerInterviewRepository;
    @Autowired
    public CustomerInterviewService(CustomerInterviewRepository customerInterviewRepository) {
        this.customerInterviewRepository = customerInterviewRepository;
    }

    public List<CustomerInterview> findAllInterviews() {
        return customerInterviewRepository.findAll();
    }

    public Optional<CustomerInterview> findByInterviewId(Long id) {
        return customerInterviewRepository.findById(id);
    }

    public CustomerInterview saveNewInterview(CustomerInterview customerInterview) {
        return customerInterviewRepository.save(customerInterview);
    }

    public void deleteByInterviewId(Long id) {
        customerInterviewRepository.deleteById(id);
    }
}
