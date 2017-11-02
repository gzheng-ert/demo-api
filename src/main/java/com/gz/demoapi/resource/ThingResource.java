package com.gz.demoapi.resource;

import com.gz.demoapi.model.Thing;
import com.gz.demoapi.service.ThingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/things")
public class ThingResource {

    private static final Logger log = LoggerFactory.getLogger(ThingResource.class);

    @Inject
    private ThingService thingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getThings() {
        List<Thing> things = thingService.getThings();
        return Response.ok(things).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createThing(@NotNull(message = "POST body cannot be null") @Valid Thing newThing,
                                @Context UriInfo uriInfo) {
        log.info(newThing.toString());
        Thing thing = thingService.createThing(newThing);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(Long.toString(thing.getId()));
        return Response.created(uriBuilder.build()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getThing(@PathParam("id") final long id) {
        Thing thing = thingService.getThing(id);
        return Response.ok(thing).build();
    }
}
