package com.snva.crmproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.snva.crmproject.entity.EndClient;

public interface EndClientRepository extends JpaRepository<EndClient, Long> {
   
}
