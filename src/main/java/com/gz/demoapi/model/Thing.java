package com.gz.demoapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Thing {
    private final long id;
    @NotNull(message = "name cannot be null")
    private final String name;

    @JsonCreator
    public Thing(@JsonProperty("id") long id, @JsonProperty("name") String name) {
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
