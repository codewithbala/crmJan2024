package com.snva.crmproject.service;

import com.snva.crmproject.entity.batchUser.BatchUser;
import com.snva.crmproject.entity.batchUser.BatchUsersId;

import java.util.List;
import java.util.Optional;

public interface BatchUserService {
    BatchUser createBatchUser(BatchUser batchUser);
    List<BatchUser> getAllBatchUsers();
    Optional<BatchUser> getBatchUserById(BatchUsersId id);
    BatchUser updateBatchUser(BatchUser batchUser);
    void deleteBatchUser(BatchUsersId id);
}
