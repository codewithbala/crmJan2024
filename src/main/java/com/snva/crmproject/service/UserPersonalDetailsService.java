package com.snva.crmproject.service;


import com.snva.crmproject.entity.userDetails.UserPersonalDetails;

import java.util.List;
import java.util.Optional;

public interface UserPersonalDetailsService {
    UserPersonalDetails createPersonalDetails(UserPersonalDetails personalDetails);

    Optional<UserPersonalDetails> findPersonalDetailsById(Long id);

    List<UserPersonalDetails> findAllPersonalDetails();

    UserPersonalDetails updatePersonalDetails(Long id, UserPersonalDetails personalDetails);

    void deletePersonalDetails(Long id);
}
