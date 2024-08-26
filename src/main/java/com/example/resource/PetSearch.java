package com.example.resource;


import com.example.api.petapi.model.Pet;
import com.example.api.petapi.service.PetApiService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Path("/petclinic")
public class PetSearch {

    @Inject
    Logger logger;


    @Inject
    PetApiService petApiService;

    @GET
    @Path("/searchAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchPets() {
        Pet pet = petApiService.getPet((long)1);
        if (pet == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(pet).build();
    }

    @GET
    @Path("/scan")
    @QueryParam("limit")
    @Produces(MediaType.APPLICATION_JSON)
    public Response scanPets(@QueryParam("limit") int limit) {
        logger.info(limit);
        List <Pet> petsList = new ArrayList<>();
        if (limit > 0) {
            IntStream.range(0, limit).forEachOrdered(n -> {
                Pet pet = petApiService.getPet((long)(n+1));
                petsList.add(pet);
            });
        }
//        Pet pet = petApiService.getPet((long)1);
        if (petsList == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(petsList).build();
    }


}


