package com.bean;

import java.io.Serializable;

public class FlyPig implements Serializable{
    private static final long serialVersionUID = 1L;
    private static String age = "26"; //这个静态static的属性，他不序列化
    private String name;
    private String color;
    transient private String car; //transient 修饰的属性，是不会被序列化的

    public static String getAge() {
        return age;
    }

    public static void setAge(String age) {
        FlyPig.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "FlyPig{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", car='" + car + '\'' +
                ", AGE='" + age + '\'' +
                '}';
    }
}
