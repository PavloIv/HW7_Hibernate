package ua.ip.hw6.storage;

import java.util.Properties;

public class DatabaseInitConnection {
    public static DatabaseSqlManagerConnector getInitService(){
        String dbUsername = System.getenv("dbUsername");
        String dbPassword = System.getenv("dbPassword");

        PropertiesConfig propertiesConfig = new PropertiesConfig();
        Properties properties = propertiesConfig.loadProperties("application.properties");

        DatabaseSqlManagerConnector  sqlConnector = new DatabaseSqlManagerConnector(properties, dbUsername,dbPassword);
        new DatabaseInitService().initDb(sqlConnector.getUrl(), sqlConnector.getUser(), sqlConnector.getPassword());

        return sqlConnector;
    }
}
