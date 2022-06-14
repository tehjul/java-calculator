package com.iut.as2021.dao.connexion;

import com.iut.as2021.dao.MySqlDao;
import com.iut.as2021.tools.Loader;

import java.sql.*;
import java.util.Properties;

public class Connexion {
    private static Connexion instance;
    private static String url, login, pwd;
    private static Connection maConnexion;

    private Connexion() {
        this.litFichier();
    }

    public static void clearDatabase() throws SQLException {
        String sql = "DROP TABLE IF EXISTS calculatrice; CREATE TABLE calculatrice (id int(11) NOT NULL AUTO_INCREMENT, expression varchar(250) COLLATE utf8_bin DEFAULT NULL, resultat double DEFAULT NULL, date date DEFAULT NULL, PRIMARY KEY (id)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;";
        PreparedStatement request = maConnexion.prepareStatement(sql);
        request.executeUpdate();
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
