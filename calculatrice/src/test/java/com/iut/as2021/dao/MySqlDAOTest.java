package com.iut.as2021.dao;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

import static com.iut.as2021.dao.DaoFactory.getDAOFactory;
import static com.iut.as2021.dao.ETypeDao.MYSQL;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;

public class MySqlDAOTest {

    // Sans mockito :
    private IDaoMathResult dao;

    // Avec mockito :
    private MySqlDAO daoMock;

    @Before
    public void setUp(){
        dao = getDAOFactory(MYSQL).getDaoMathResult();
        daoMock = Mockito.mock(MySqlDAO.class);
    }

    public void testGetInstance() {
    }

    @Test
    public void testReadById() throws MathsExceptions, SQLException, ClassNotFoundException {
        MathResultat resultat = dao.readById(1);
        assertEquals(resultat.calculate(), 5, 1);
    }

    @Test
    public void testReadByIdWithMockito() throws MathsExceptions, SQLException, ClassNotFoundException {
        MathResultat resultat = new MathResultat("2+3");
        Mockito.when(daoMock.readById(anyInt())).thenReturn(resultat);
        assertEquals(resultat.calculate(), 5, 1);

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