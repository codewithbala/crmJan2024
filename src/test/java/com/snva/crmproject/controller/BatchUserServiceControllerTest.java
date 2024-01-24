package com.snva.crmproject.controller;

import com.snva.crmproject.entity.batchDetails.Batch;
import com.snva.crmproject.entity.batchUser.BatchUser;
import com.snva.crmproject.entity.batchUser.BatchUsersId;
import com.snva.crmproject.entity.userDetails.User;
import com.snva.crmproject.service.BatchUserServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BatchUserServiceControllerTest {
    @Mock
    private BatchUserServiceImp batchUserServiceImp;

    @InjectMocks
    private BatchUserController batchUserController;

    private BatchUser batchUser;
    private List<BatchUser> batchUserList;
    private BatchUsersId batchUsersId;

    @BeforeEach
    void setUp() {
        Batch batch1 = new Batch();
        batch1.setId(1L);
        User user1 = new User();
        user1.setId(101L);

        Batch batch2 = new Batch();
        batch2.setId(2L);
        User user2 = new User();
        user2.setId(102L);

        batchUser = new BatchUser(batch1, user1);
        BatchUser anotherBatchUser = new BatchUser(batch2, user2);

        batchUserList = new ArrayList<>();
        batchUserList.add(batchUser);
        batchUserList.add(anotherBatchUser);

        batchUsersId = new BatchUsersId(batch1.getId(), user1.getId());
    }

    @Test
    void testCreateBatchUser() {
        when(batchUserServiceImp.createBatchUser(any(BatchUser.class))).thenReturn(batchUser);
        ResponseEntity<BatchUser> response = batchUserController.createBatchUser(batchUser);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(batchUser, response.getBody());
        verify(batchUserServiceImp, times(1)).createBatchUser(batchUser);
    }

    @Test
    void testGetBatchUserById() {
        when(batchUserServiceImp.getBatchUserById(any(BatchUsersId.class))).thenReturn(Optional.of(batchUser));

        Long batchId = batchUsersId.getBatch();
        Long userId = batchUsersId.getUser();

        ResponseEntity<BatchUser> response = batchUserController.getBatchUserById(batchId, userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(batchUserServiceImp).getBatchUserById(argThat(id -> id.getBatch().equals(batchId) && id.getUser().equals(userId)));
    }


    @Test
    void testUpdateBatchUser() {
        when(batchUserServiceImp.updateBatchUser(any(BatchUser.class))).thenReturn(batchUser);
        Long batchId = batchUsersId.getBatch();
        Long userId = batchUsersId.getUser();
        ResponseEntity<BatchUser> response = batchUserController.updateBatchUser(batchId, userId,batchUser);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(batchUser, response.getBody());
        verify(batchUserServiceImp, times(1)).updateBatchUser(any(BatchUser.class));
    }

    @Test
    void testDeleteBatchUser() {
        doNothing().when(batchUserServiceImp).deleteBatchUser(any(BatchUsersId.class));
        Long batchId = batchUsersId.getBatch();
        Long userId = batchUsersId.getUser();

        ResponseEntity<Void> response = batchUserController.deleteBatchUser(batchId, userId);

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCodeValue());
        verify(batchUserServiceImp).deleteBatchUser(argThat(id -> id.getBatch().equals(batchId) && id.getUser().equals(userId)));
    }
    @Test
    void testGetAllBatchUsers() {
        when(batchUserServiceImp.getAllBatchUsers()).thenReturn(batchUserList);

        ResponseEntity<List<BatchUser>> response = batchUserController.getAllBatchUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        verify(batchUserServiceImp, times(1)).getAllBatchUsers();
    }
}
