package ma.enset.app.dao;

import java.sql.*;

public class SingletonConnexionDB {
    private static Connection connection;
    static{
        // Charger le pilot JDPC pour MYSQL
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Établir la connexion avec la base de données
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_CATALOGUE", "root", "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}
