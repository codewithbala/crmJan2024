package com.snva.crmproject.service;

import com.snva.crmproject.entity.batchUser.BatchUser;
import com.snva.crmproject.entity.batchUser.BatchUsersId;
import com.snva.crmproject.repository.batchUser.BatchUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BatchUserServiceImp implements BatchUserService{

    private final BatchUserRepository batchUserRepository;
    @Autowired
    public BatchUserServiceImp(BatchUserRepository batchUserRepository) {
        this.batchUserRepository = batchUserRepository;
    }

    @Transactional
    @Override
    public BatchUser createBatchUser(BatchUser batchUser) {
        return batchUserRepository.save(batchUser);
    }

    @Override
    public List<BatchUser> getAllBatchUsers() {
        return batchUserRepository.findAll();
    }
    @Transactional
    @Override
    public Optional<BatchUser> getBatchUserById(BatchUsersId id) {
        return batchUserRepository.findById(id);
    }

    @Transactional
    @Override
    public BatchUser updateBatchUser(BatchUser batchUser) {
        BatchUsersId id = new BatchUsersId(batchUser.getBatch().getId(), batchUser.getUser().getId());
        if (batchUserRepository.existsById(id)) {
            return batchUserRepository.save(batchUser);
        }
        throw new RuntimeException("BatchUser not found");
    }

    @Transactional
    @Override
    public void deleteBatchUser(BatchUsersId id) {
        if (batchUserRepository.existsById(id)) {
            batchUserRepository.deleteById(id);
        } else {
            throw new RuntimeException("BatchUser not found");
        }
    }
}
