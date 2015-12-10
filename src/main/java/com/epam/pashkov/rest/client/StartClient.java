package com.epam.pashkov.rest.client;

import com.epam.pashkov.rest.entity.CountryData;
import com.sun.jersey.api.client.ClientResponse;

import java.util.Collection;

/**
 * User: Yaroslav_Pashkov
 * Date: 08.12.2015
 * Time: 14:18
 */
public class StartClient {
    public static void main(String[] args) {
        Methods methods = new Methods();
        //GET
        Collection<CountryData> countryData = methods.get();
        System.out.println(countryData);

        //POST
        ClientResponse clientResponse = methods.post(new CountryData("Poland", "Warsaw", 1740119, "EUR"));
        System.out.println("POST request status: " + clientResponse.getStatus());

        //PUT
        clientResponse = methods.put("Poland", 1);
        System.out.println("PUT request status: " + clientResponse.getStatus());

        //DELETE
        clientResponse = methods.delete("Poland");
        System.out.println("DELETE request status: " + clientResponse.getStatus());
    }
}
