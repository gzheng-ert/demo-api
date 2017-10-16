package com.gz.demoapi.model;

public class Thing {
    private final int id;
    private final String name;

    public Thing(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
