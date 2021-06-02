package com.iut.as2021.dao.connexion;

import com.iut.as2021.tools.Loader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties p = Loader.getProperties("/bdd.properties");
            url = "jdbc:mysql://" + p.getProperty("url") + ":" + p.getProperty("port") + "/" + p.getProperty("bdd");
            login = p.getProperty("login");
            pwd = p.getProperty("pass");
        } catch (Exception ioe) {
            System.out.println("pb fichier properties " + ioe.getMessage());
        }
    }
}
