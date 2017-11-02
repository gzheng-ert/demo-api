package com.gz.demoapi.service;

import com.gz.demoapi.model.Thing;

import java.util.List;

public interface ThingService {
    public Thing getThing(long id);
    public List<Thing> getThings();
    public Thing createThing(Thing newThing);
}
