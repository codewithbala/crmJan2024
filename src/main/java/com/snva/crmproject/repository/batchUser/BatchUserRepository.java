package com.snva.crmproject.repository.batchUser;

import com.snva.crmproject.entity.batchUser.BatchUser;
import com.snva.crmproject.entity.batchUser.BatchUsersId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchUserRepository extends JpaRepository<BatchUser, BatchUsersId> {
    boolean existsById(BatchUsersId id);
}
