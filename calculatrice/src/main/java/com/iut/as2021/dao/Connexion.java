package com.iut.as2021.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String URL = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/sibille33u_cpoa";

    public static Connection getConnexion() throws SQLException {

        Connection maConnexion = DriverManager.getConnection(URL, "sibille33u_appli", "32004260");

        return maConnexion;
    }
}
