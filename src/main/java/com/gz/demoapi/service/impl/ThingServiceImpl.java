package com.gz.demoapi.service.impl;

import com.gz.demoapi.errorhandling.AppError;
import com.gz.demoapi.errorhandling.AppException;
import com.gz.demoapi.model.Thing;
import com.gz.demoapi.service.ThingService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ThingServiceImpl implements ThingService {

    //simply store a static list of things, for sake of demo
    private final List<Thing> things = initThings();

    @Override
    public Thing getThing(int id) throws AppException {
        try {
            return things.stream().filter((thing) -> thing.getId() == id).
                    findFirst().
                    get();
        }
        catch (NoSuchElementException ex) {
            AppError appError = new AppError(404, 4004,"thing " + id + " not found", "not found" );
            throw new AppException(ex, appError);
        }
    }

    @Override
    public List<Thing> getThings() {
        return things;
    }

    private List<Thing> initThings() {
        Thing[] things = new Thing[] {
                new Thing(1,"thing1"),
                new Thing(2,"thing2"),
                new Thing(3,"thing3"),
                new Thing(4,"thing4"),
                new Thing(5,"thing5")
        };
        return Arrays.asList(things);
    }

}
