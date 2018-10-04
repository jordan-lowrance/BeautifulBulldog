package com.example.jordan.beautifulbulldog;

import java.io.Serializable;

public class Bulldog implements Serializable {
    private String age;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
