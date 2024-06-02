package com.javatechie.api.Serialization.Item85.Json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonExample {
    public static void main(String[] args) throws Exception {
        Person person = new Person("John Doe", 30, "123 Main St");

        // Serialize to JSON
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(person);
        System.out.println(jsonString);

        // Deserialize from JSON
        Person deserializedPerson = mapper.readValue(jsonString, Person.class);
        System.out.println(deserializedPerson.getName());
    }
}