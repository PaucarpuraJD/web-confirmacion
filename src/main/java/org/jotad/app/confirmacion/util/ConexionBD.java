package org.jotad.app.confirmacion.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static String url = "jdbc:mysql://localhost:3306/bd_confirmacion?serverTimeZone=America/Lima";
    private static String username = "root";
    private static String password = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
