package com.epam.pashkov.rest;

import com.epam.pashkov.rest.entity.CountryData;
import com.epam.pashkov.rest.management.Management;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * User: Yaroslav_Pashkov
 * Date: 08.12.2015
 * Time: 13:38
 */
@Path("/countries")
public class QueriesService {
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCountries() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(Management.getAllCountries());
        return Response.status(200).entity(json).build();
    }

    @GET
    @Path("/get/{country}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountry(@PathParam("country") String country) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(Management.getCountry(country));
        return Response.status(200).entity(json).build();
    }

    @PUT
    @Path("/put")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response changePopulation(String json) {
        return Response.status(200).entity(Management.changePopulation(new Gson().fromJson(json, JsonObject.class).get("country").getAsString(),
            new Gson().fromJson(json, JsonObject.class).get("population").getAsInt())).build();
    }

    @DELETE
    @Path("/delete/{country}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCountry(@PathParam("country") String country) {
        return Response.status(200).entity(Management.removeCountry(country)).build();
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createCountry(String countryDataJSON) {
        Management.createCountry(new Gson().fromJson(countryDataJSON, CountryData.class));
        return countryDataJSON;
    }
}
