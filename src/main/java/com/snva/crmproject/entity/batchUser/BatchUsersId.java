package com.snva.crmproject.entity.batchUser;

import java.io.Serializable;

public class BatchUsersId implements Serializable {
    private Long batch;
    private Long user;

    public BatchUsersId(Long batch, Long user) {
        this.batch = batch;
        this.user = user;
    }

    public Long getBatch() {
        return batch;
    }

    public void setBatch(Long batch) {
        this.batch = batch;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
