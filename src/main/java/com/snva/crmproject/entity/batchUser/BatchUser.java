package com.snva.crmproject.entity.batchUser;

import com.snva.crmproject.entity.batchDetails.Batch;
import com.snva.crmproject.entity.userDetails.User;
import jakarta.persistence.*;

@Entity
@Table(name = "batch_user")
@IdClass(BatchUsersId.class)
public class BatchUser {

    @Id
    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public BatchUser() {
    }

    public BatchUser(Batch batch, User user) {
        this.batch = batch;
        this.user = user;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
