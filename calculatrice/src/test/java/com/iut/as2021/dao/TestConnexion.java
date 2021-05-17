package com.iut.as2021.dao;

import com.iut.as2021.dao.connexion.Connexion;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestConnexion {
    private static final String DB_NAME = "sibille33u_cpoa";

    @Test
    public void testConnexionOk() throws SQLException {
        Connection connection = Connexion.getInstance().creeConnexion();
        assertNotNull(connection);
        assertEquals(DB_NAME, connection.getCatalog());
    }

    @Test
    public void testConnexionIsSingleton() throws SQLException{
        Connection connection1 = Connexion.getInstance().creeConnexion();
        Connection connection2 = Connexion.getInstance().creeConnexion();
        assertEquals(connection1, connection2);
    }
}
