package com.javatechie.api.Serialization.Item85.Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

@Getter
class Person {
    private String name;
    private int age;
    private String address;

    public Person() {
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }



    // Getters and setters...
}


