//package ua.ip.hw7.storage;
//
//import org.flywaydb.core.Flyway;
//
//public class DatabaseInitService {
//    public void initDb(String Url, String user,String pass){
//        Flyway flyway = Flyway
//                .configure()
//                .dataSource(Url,user,pass)
//                .load();
//        flyway.migrate();
//    }
//}