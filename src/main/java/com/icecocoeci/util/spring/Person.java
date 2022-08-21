package com.icecocoeci.util.spring;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther wlf
 * @Date: 2022/08/07/18:00
 * @Description:
 */
public class Person {
    private Long id;
    private String name;

    public void say(){
        System.out.println("Say Hello");
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
