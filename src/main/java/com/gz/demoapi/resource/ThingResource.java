package com.gz.demoapi.resource;

import com.gz.demoapi.errorhandling.AppException;
import com.gz.demoapi.model.Thing;
import com.gz.demoapi.service.ThingService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/things")
public class ThingResource {

    @Inject
    private ThingService thingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getThings() {
        List<Thing> things = thingService.getThings();
        return Response.ok(things).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getThing(@PathParam("id") final long id) {
        Thing thing = thingService.getThing(id);
        return Response.ok(thing).build();
    }
}
