package com.example.api.petapi.service;

import com.example.api.petapi.PetApiClient;
import com.example.api.petapi.model.Pet;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class PetApiService {

    @Inject
    @RestClient
    PetApiClient petApiClient;

    public Pet getPet(Long id) {
        return petApiClient.getPetById(id);
    }
}
