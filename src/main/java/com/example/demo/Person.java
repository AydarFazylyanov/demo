package com.example.demo;

public class Person {
    private int age;
    private String name;
    Person(String name, int age){
        this.age = age;
        this.name = name;
    }
    Person(){}


    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
