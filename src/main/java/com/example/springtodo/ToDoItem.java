package com.example.springtodo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ToDoItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String body;
    @Column(nullable = true)
    private String timestamp;


    public ToDoItem(long id, String body, String timestamp) {
        this.id = id;
        this.body = body;
        this.timestamp = timestamp;
    }

    public ToDoItem(String body, String timestamp) {
        this.body = body;
        this.timestamp = timestamp;
    }

    public ToDoItem() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
