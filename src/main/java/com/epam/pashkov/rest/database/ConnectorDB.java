package com.epam.pashkov.rest.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Yaroslav on 09.12.2015.
 */
public class ConnectorDB {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        ResourceBundle resource = ResourceBundle.getBundle("settings");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        Class.forName(resource.getString("db.driver"));
        return DriverManager.getConnection(url, user, pass);
    }
}
