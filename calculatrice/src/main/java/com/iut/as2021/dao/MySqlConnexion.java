package com.iut.as2021.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlConnexion {
    private static MySqlConnexion instance;

    public static MySqlConnexion getInstance() {
        if (instance == null) {
            instance = new MySqlConnexion();
        }
        return instance;
    }

    private String url, login, pwd;
    private Connection maConnexion;

    private MySqlConnexion() {

        this.litFichier();
    }

    public Connection getConnexion() throws SQLException {

        if (this.maConnexion==null || this.maConnexion.isClosed()) {
            this.maConnexion = DriverManager.getConnection(this.url, this.login, this.pwd);
        }
        return maConnexion;
    }

    private void litFichier() {

        Properties p = new Properties();

        File fichier = new File("config/bdd.properties");
        try {
            FileInputStream source = new FileInputStream(fichier);
            p.loadFromXML(source);
            this.url = "jdbc:mysql://" + p.getProperty("url") + ":" + p.getProperty("port") + "/" + p.getProperty("bdd") + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            this.login = p.getProperty("login");
            this.pwd = p.getProperty("pass");
        } catch (IOException ioe) {
            System.out.println("pb fichier properties " + ioe.getMessage());
        }
    }

}
