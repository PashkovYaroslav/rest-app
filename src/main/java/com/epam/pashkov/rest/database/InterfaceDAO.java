package com.epam.pashkov.rest.database;

import com.epam.pashkov.rest.entity.CountryData;

import java.util.List;

/**
 * Created by Yaroslav on 09.12.2015.
 */
public interface InterfaceDAO {
    public List<CountryData> getAllCountries();
    public int addCountry(CountryData countryData);
    public int updateCountryPopulation(String country, long population);
    public int removeCountry(String country);
}
