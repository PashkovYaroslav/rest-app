package com.epam.pashkov.rest.helpers;

import com.epam.pashkov.rest.entity.CountryData;

import java.util.Collection;

/**
 * User: Yaroslav_Pashkov
 * Date: 10.12.2015
 * Time: 15:40
 */

public class TestHelpers {
    public boolean isCountriesContains(Collection<CountryData> countryDataCollection, CountryData countryData) {
        boolean result = false;
        for(CountryData country : countryDataCollection) {
            if(country.getCountry().equals(countryData.getCountry())) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isPopulationEquals(Collection<CountryData> countryDataCollection, String countryTitle, long population) {
        boolean result = false;
        for(CountryData country : countryDataCollection) {
            if(country.getCountry().equals(countryTitle)) {
                result = country.getPopulation() == population ? true : false;
                break;
            }
        }
        return result;
    }
}
