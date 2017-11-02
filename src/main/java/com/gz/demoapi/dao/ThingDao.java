package com.gz.demoapi.dao;

import com.gz.demoapi.model.Thing;

import java.util.List;

public interface ThingDao {
    Thing findThing(final long id);
    List<Thing> findAllThings();
    Thing createNewThing(Thing newThing);
}
