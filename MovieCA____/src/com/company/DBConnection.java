
package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection sConnection;

    public DBConnection() {
    }

    public static Connection getInstance() throws ClassNotFoundException, SQLException {
        String host = "localhost";
        String db = "movies";
        String user = "root";
        String password = "";
        if (sConnection == null || sConnection.isClosed()) {
            String url = "jdbc:mysql://" + host + "/" + db;
            Class.forName("com.mysql.cj.jdbc.Driver");
            sConnection = DriverManager.getConnection(url, user, password);
        }

        return sConnection;
    }
}
