package com.iut.as2021.dao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestMySqlConnexion {
    private static final String DB_NAME = "sibille33u_cpoa";

    @Test
    public void testConnexionOk() throws SQLException, ClassNotFoundException {
        Connection connection = MySqlConnexion.getInstance().getConnexion();
        assertNotNull(connection);
        assertEquals(DB_NAME, connection.getCatalog());
    }
}
