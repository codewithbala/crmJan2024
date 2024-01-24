package com.snva.crmproject.service;

import com.snva.crmproject.entity.userDetails.UserPersonalDetails;
import com.snva.crmproject.repository.user.UserPersonalDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserPersonalDetailsServiceImpl implements UserPersonalDetailsService {

    private final UserPersonalDetailsRepository personalDetailsRepository;

    @Autowired
    public UserPersonalDetailsServiceImpl(UserPersonalDetailsRepository personalDetailsRepository) {
        this.personalDetailsRepository = personalDetailsRepository;
    }

    @Override
    @Transactional
    public UserPersonalDetails createPersonalDetails(UserPersonalDetails personalDetails) {
        return personalDetailsRepository.save(personalDetails);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserPersonalDetails> findPersonalDetailsById(Long id) {
        return personalDetailsRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserPersonalDetails> findAllPersonalDetails() {
        return personalDetailsRepository.findAll();
    }

    @Override
    @Transactional
    public UserPersonalDetails updatePersonalDetails(Long id, UserPersonalDetails personalDetails) {
        return personalDetailsRepository.findById(id).map(existingDetails -> {
            existingDetails.setUser(personalDetails.getUser());
            existingDetails.setFirstName(personalDetails.getFirstName());
            existingDetails.setLastName(personalDetails.getLastName());
            existingDetails.setPhone(personalDetails.getPhone());
            existingDetails.setAddressCity(personalDetails.getAddressCity());
            existingDetails.setAddressCountry(personalDetails.getAddressCountry());
            existingDetails.setAddressLine1(personalDetails.getAddressLine1());
            existingDetails.setAddressLine2(personalDetails.getAddressLine2());
            existingDetails.setAddressState(personalDetails.getAddressState());
            existingDetails.setAddressZipCode(personalDetails.getAddressZipCode());
            return personalDetailsRepository.save(existingDetails);
        }).orElse(null); // Return null if the object with the given id is not found
    }

    @Override
    @Transactional
    public void deletePersonalDetails(Long id) {
        personalDetailsRepository.deleteById(id);
    }
}
