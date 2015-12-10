import com.epam.pashkov.rest.client.Methods;
import com.epam.pashkov.rest.entity.CountryData;
import com.epam.pashkov.rest.helpers.TestHelpers;
import com.sun.jersey.api.client.ClientResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;

/**
 * User: Yaroslav_Pashkov
 * Date: 10.12.2015
 * Time: 15:15
 */

public class QueriesTests {
    String country = "Poland";
    String capital = "Warsaw";
    long population = 1740119;
    String currency = "EUR";

    TestHelpers testHelpers = new TestHelpers();

    @Test
    public void checkGet() {
        Methods methods = new Methods();
        Collection<CountryData> countryData = methods.get();
        System.out.println(countryData);
        Assert.assertTrue(!countryData.isEmpty(), "The list of countries is empty");
    }

    @Test
    public void checkGetByCountry() {
        Methods methods = new Methods();
        CountryData countryData = methods.getByCountry(country);
        Assert.assertTrue(countryData.getCapital().equals(capital), "Country is not found");
    }

    @Test
    public void checkPost() {
        Methods methods = new Methods();
        CountryData countryData = new CountryData(country, capital, population, currency);
        ClientResponse clientResponse = methods.post(countryData);
        Assert.assertTrue(testHelpers.isCountriesContains(methods.get(), countryData), "POST is unsuccessful");
    }

    @Test
    public void checkPut() {
        String country = "Poland-test";
        long population = 1;
        Methods methods = new Methods();
        ClientResponse clientResponse = methods.post(new CountryData(country, capital, population, currency));
        clientResponse = methods.put(country, 1);
        Assert.assertTrue(testHelpers.isPopulationEquals(methods.get(), country, population), "PUT is unsuccessful");
    }

    @Test
    public void checkDelete() {
        String country = "Poland-test";
        Methods methods = new Methods();
        CountryData countryData = new CountryData(country, capital, population, currency);
        ClientResponse clientResponse = methods.post(countryData);
        clientResponse = methods.delete(country);
        Assert.assertTrue(!testHelpers.isCountriesContains(methods.get(), countryData), "DELETE is unsuccessful");
    }
}
