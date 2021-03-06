package com.example.springtodo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class ToDoItem {

    @Id
    @GeneratedValue
    private Long id;
    private String name;


    public ToDoItem(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public ToDoItem(String name) {
        this.name = name;

    }

    public ToDoItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}