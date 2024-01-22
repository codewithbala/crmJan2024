package com.snva.crmproject.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snva.crmproject.entity.userDetails.UserPersonalDetails;

public interface UserPersonalDetailsRepository extends JpaRepository<UserPersonalDetails, Long> {
}
