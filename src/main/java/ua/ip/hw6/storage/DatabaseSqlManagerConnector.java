package ua.ip.hw6.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseSqlManagerConnector {
    private String url;
    private Properties properties;

    public DatabaseSqlManagerConnector(Properties properties, String user, String password) {
        init(properties, user, password);
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void init(Properties properties,String user, String password) {
        url = String.format("jdbc:postgresql://%s:%s/%s",properties.get("host"), properties.get("port"),
                properties.get("databaseName"));
        this.properties = new Properties();
        this.properties.setProperty("user", user);
        this.properties.setProperty("password", password);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Error loading postgres driver", ex);
        }
    }

    public String getUrl() {
        return url;
    }
    public String getUser(){
        return properties.getProperty("user");
    }
    public String getPassword(){
        return properties.getProperty("password");
    }
}
