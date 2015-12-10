package com.epam.pashkov.rest.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * User: Yaroslav_Pashkov
 * Date: 08.12.2015
 * Time: 12:07
 */
public class CountryData {
    private String country;
    private String capital;
    private long population;
    private String currency;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country.length() > 0) {
            this.country = country;
        } else {
            throw new IllegalArgumentException("Incorrect country name");
        }
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        if (capital.length() > 0) {
            this.capital = capital;
        } else {
            throw new IllegalArgumentException("Incorrect capital");
        }
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        if (population > 0) {
            this.population = population;
        } else {
            throw new IllegalArgumentException("Incorrect population count");
        }
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        if (currency.length() > 0) {
            this.currency = currency;
        } else {
            throw new IllegalArgumentException("Incorrect currency");
        }
    }

    public CountryData(String country, String capital, long population, String currency) {
        setCountry(country);
        setCapital(capital);
        setPopulation(population);
        setCurrency(currency);
    }

    @Override public String toString() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(this);
        return json;
    }
}
