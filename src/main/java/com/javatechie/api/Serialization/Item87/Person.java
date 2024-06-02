package com.javatechie.api.Serialization.Item87;

import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient String password; // Không tuần tự hóa mật khẩu
    private int age;

    public Person(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    // Phương thức tuần tự hóa tùy chỉnh
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // Ghi các trường không phải là transient

        // Ghi mật khẩu
        // (Ở đây, ta có thể mã hóa mật khẩu trước khi ghi để bảo mật hơn)
        out.writeObject(password);
    }

    // Phương thức giải tuần tự hóa tùy chỉnh
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Đọc các trường không phải là transient

        // Đọc mật khẩu
        // (Ở đây, ta có thể giải mã mật khẩu sau khi đọc để khôi phục giá trị ban đầu)
        password = (String) in.readObject();
    }

    // Getters và setters...
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

