package com.gz.demoapi.service.impl;

import com.gz.demoapi.dao.ThingDao;
import com.gz.demoapi.errorhandling.AppError;
import com.gz.demoapi.errorhandling.AppException;
import com.gz.demoapi.model.Thing;
import com.gz.demoapi.service.ThingService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ThingServiceImpl implements ThingService {

    @Inject
    private ThingDao thingDao;

    @Override
    public Thing getThing(final long id) {
        Thing thing = thingDao.findThing(id);
        if (thing == null) {
            AppError appError = new AppError(404, 4004,"thing " + id + " not found", "not found" );
            throw new AppException(appError);
        }
        return thing;
    }

    @Override
    public List<Thing> getThings() {
        return thingDao.findAllThings();
    }

    @Override
    public Thing createThing(Thing newThing) {
        return thingDao.createNewThing(newThing);
    }

}
