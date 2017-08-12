package edu.csula.jaxrs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ResourceDatabase {
	public static final String database = "lab7";
    public static final String url = "jdbc:mysql://localhost/" + database;
    public static final String username = "root";
    public static final String password = "charu";

    public ResourceDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch( ClassNotFoundException e ) {
            throw new IllegalStateException(e);
        }
    }

    public Connection connection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
