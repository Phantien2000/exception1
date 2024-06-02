package com.javatechie.api.Serialization.Item87;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CustomSerializationExample {
    public static void main(String[] args) throws Exception {
        // Tạo một đối tượng Person
        Person person = new Person("John Doe", "password123", 30);

        // Tuần tự hóa đối tượng Person
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            out.writeObject(person);
        }

        // Giải tuần tự hóa đối tượng Person
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) in.readObject();
            System.out.println("Name: " + deserializedPerson.getName());
            System.out.println("Age: " + deserializedPerson.getAge());
            // Mật khẩu sẽ không được giải tuần tự hóa và sẽ là null
        }
    }
}
