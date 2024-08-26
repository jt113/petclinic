package com.example.api.petapi;

import com.example.api.petapi.model.Pet;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/petapi")
@RegisterRestClient(configKey="pet-api")
public interface PetApiClient {

    @GET
    @Path("/{id}")
    Pet getPetById(@PathParam("id") Long id);
}