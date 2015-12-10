package com.epam.pashkov.rest.management;

import com.epam.pashkov.rest.database.CountriesDAO;
import com.epam.pashkov.rest.entity.CountryData;

import java.util.List;

/**
 * User: Yaroslav_Pashkov
 * Date: 08.12.2015
 * Time: 13:07
 */
public class Management {
    private static CountriesDAO countriesDAO = new CountriesDAO();

    public static List<CountryData> getAllCountries() {
        return countriesDAO.getAllCountries();
    }

    public static CountryData getCountry(String country) {
        return countriesDAO.getCountry(country);
    }

    public static void createCountry(CountryData countryData) {
        countriesDAO.addCountry(countryData);
    }

    public static int changePopulation(String country, long population) {
         return countriesDAO.updateCountryPopulation(country, population);
    }

    public static int removeCountry(String country) {
        return countriesDAO.removeCountry(country);
    }
}
