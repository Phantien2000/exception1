package com.javatechie.api.Serialization.Item85.Serialization;

import java.io.Serializable;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Getters and setters...
    public String getName() {
        return name;
    }
}