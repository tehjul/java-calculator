package com.iut.as2021.dao.connexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connexion {
    private static Connexion instance;

    public static Connexion getInstance() {
        if (instance == null) {
            return new Connexion();
        }
        return instance;
    }

    private String url, login, pwd;
    private Connection maConnexion;

    private Connexion() {
        this.litFichier();
    }

    public Connection creeConnexion() throws SQLException {

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
