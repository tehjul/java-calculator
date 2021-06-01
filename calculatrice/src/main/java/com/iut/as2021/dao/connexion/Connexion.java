package com.iut.as2021.dao.connexion;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connexion {
    private static Connexion instance;
    private static String url, login, pwd;
    private static Connection maConnexion;

    private Connexion() {
        this.litFichier();
    }

    public static Connection creeConnexion() throws SQLException {

        if (maConnexion==null || maConnexion.isClosed()) {
            instance = new Connexion();
            maConnexion = DriverManager.getConnection(url, login, pwd);
        }
        return maConnexion;
    }

    private void litFichier() {
        Properties p = new Properties();
        File fichier = new File("config/bdd.properties");
        try {
            FileInputStream source = new FileInputStream(fichier);
            p.loadFromXML(source);
            url = "jdbc:mysql://" + p.getProperty("url") + ":" + p.getProperty("port") + "/" + p.getProperty("bdd");
            login = p.getProperty("login");
            pwd = p.getProperty("pass");
        } catch (IOException ioe) {
            System.out.println("pb fichier properties " + ioe.getMessage());
        }
    }
}
