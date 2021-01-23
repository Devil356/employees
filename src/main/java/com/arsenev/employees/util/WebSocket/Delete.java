package com.arsenev.employees.util.WebSocket;

public class Delete {
    private Long id;

    public Delete(Long id) {
        this.id = id;
    }

    public Delete() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
