package com.epam.pashkov.rest.client;

import com.epam.pashkov.rest.entity.CountryData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.ResourceBundle;

/**
 * User: Yaroslav_Pashkov
 * Date: 09.12.2015
 * Time: 16:29
 */
public class Methods {
    private Client client;
    private WebResource webResource;
    private ClientResponse response;
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("settings");
    private String baseUrl = resourceBundle.getString("path.app");

    public Collection<CountryData> get() {
        client = Client.create();
        String getURL = baseUrl + resourceBundle.getString("path.get");
        webResource = client.resource(getURL);
        String countryData = webResource.accept(MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<CountryData>>() {
        }.getType();
        Collection<CountryData> countryDatas = gson.fromJson(countryData, collectionType);
        return countryDatas;
    }

    public CountryData getByCountry(String country) {
        client = Client.create();
        String getURL = baseUrl + resourceBundle.getString("path.get") + "/" + country;
        webResource = client.resource(getURL);
        String countryData = webResource.accept(MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new Gson();
        return gson.fromJson(countryData, CountryData.class);
    }

    public ClientResponse post(CountryData newCountry) {
        client = Client.create();
        String postURL = baseUrl + resourceBundle.getString("path.post");
        webResource = client.resource(postURL);
        response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, new Gson().toJson(newCountry));
        return response;
    }

    public ClientResponse put(String country, long population) {
        client = Client.create();
        String putUrl = baseUrl + resourceBundle.getString("path.put");
        webResource = client.resource(putUrl);
        response =
            webResource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, String.format("{country: \"%s\", population: %s}", country, population));
        return response;
    }

    public ClientResponse delete(String country) {
        client = Client.create();
        String deleteUrl = baseUrl + String.format(resourceBundle.getString("path.delete"), country);
        webResource = client.resource(deleteUrl);
        response = webResource.type(MediaType.TEXT_PLAIN).delete(ClientResponse.class);
        return response;
    }
}
