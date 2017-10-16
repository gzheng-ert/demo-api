package com.gz.demoapi.model;

public class Thing {
    private final long id;
    private final String name;

    public Thing(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format(
                "Thing[id=%d, name=%s]", id, name
        );
    }

}
