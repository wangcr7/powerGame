package com.optional;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-15 23:14
 */
public class Girl {

    private String name;

    public Girl(String name) {
        this.name = name;
    }

    public Girl (){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
