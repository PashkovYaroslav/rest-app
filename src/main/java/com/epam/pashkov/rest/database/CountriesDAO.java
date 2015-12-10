package com.epam.pashkov.rest.database;

import com.epam.pashkov.rest.entity.CountryData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 09.12.2015.
 */
public class CountriesDAO implements InterfaceDAO {

    public List<CountryData> getAllCountries() {
        List<CountryData> countryDataList = new ArrayList<CountryData>();
        Connection connection = null;

        try {
            connection = ConnectorDB.getConnection();
            ResultSet rs;
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("select * from Countries");
            while (rs.next()) {
                countryDataList.add(new CountryData(rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5)));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return countryDataList;
    }

    public CountryData getCountry(String country) {
        CountryData countryData = null;
        Connection connection = null;

        try {
            connection = ConnectorDB.getConnection();
            ResultSet rs;
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(String.format("select * from Countries where Country='%s'", country));
            while (rs.next()) {
                countryData = new CountryData(rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5));
                break;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return countryData;
    }

    public int addCountry(CountryData countryData) {
        int result = 0;
        Connection connection = null;

        try {
            connection = ConnectorDB.getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(String
                .format("insert into Countries (ID, Country, Capital, Population, Currency) " + "values (NULL, '%s', '%s', %s, '%s');",
                    countryData.getCountry(), countryData.getCapital(), countryData.getPopulation(), countryData.getCurrency()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int updateCountryPopulation(String country, long population) {
        int result = 0;
        Connection connection = null;

        try {
            connection = ConnectorDB.getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(String.format("update Countries set Population=%s where Country='%s';", population, country));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int removeCountry(String country) {
        int result = 0;
        Connection connection = null;

        try {
            connection = ConnectorDB.getConnection();
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(String.format("delete from Countries where Country='%s';", country));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
