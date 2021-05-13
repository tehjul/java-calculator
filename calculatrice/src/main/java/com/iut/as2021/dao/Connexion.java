package com.iut.as2021.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    public static Connection instance = null;

    private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String URL_MYSQL = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/sibille33u_cpoa";
    private static final String USER = "sibille33u_appli";
    private static final String PASSWORD = "32004260";

    private Connexion() {
    }

    public static Connection getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = creerConnection();
        }
        return instance;
    }

    private static Connection creerConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER_CLASS_NAME);
        return DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
    }

}
