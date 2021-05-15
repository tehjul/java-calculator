package com.iut.as2021.dao;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class MySqlDAOTest {

    private IDaoMathResult dao;

    @Before
    public void setUp(){
        dao = (MySqlDAO) MySqlDAO.getInstance();
    }

    @Test
    public void testGetInstance() {
    }

    @Test
    public void testReadById() throws MathsExceptions, SQLException, ClassNotFoundException {
        MathResultat resultat = dao.readById(1);
        Assert.assertEquals(resultat.calculate(), 5, 1);
    }

    public void testGetlast() {
    }

    public void testGetAll() {
    }

    public void testUpdate() {
    }

    public void testCreate() {
    }

    public void testDelete() {
    }
}