package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class Child {
    private String name;
    private Integer age;
    private List<Friends> friends;
}
