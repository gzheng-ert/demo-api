package com.gz.demoapi.service;


import com.gz.demoapi.errorhandling.AppException;
import com.gz.demoapi.model.Thing;

import java.util.List;

public interface ThingService {
    public Thing getThing(int id) throws AppException;
    public List<Thing> getThings();
}
