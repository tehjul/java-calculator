package com.iut.as2021.dao;

import com.iut.as2021.dao.entity.EntityMathResultat;
import com.iut.as2021.dao.interfaces.modele.IDaoMathResultat;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.sql.SQLException;

import static com.iut.as2021.dao.factory.DaoFactoryGeneric.getDAOFactory;
import static com.iut.as2021.dao.ETypeDao.MYSQL;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;

public class MySqlDaoTest {

    // Sans mockito :
    private IDaoMathResultat dao;

    // Avec mockito :
    private MySqlDao daoMock;

    @Before
    public void setUp() {
        dao = getDAOFactory(MYSQL).getDaoMathResult();
        daoMock = Mockito.mock(MySqlDao.class);
    }

    @Test
    public void testReadById() throws MathsExceptions, SQLException {
        EntityMathResultat entityMathResultat = dao.getMathResultatById(1);
        MathResultat resultat = new MathResultat(entityMathResultat.getExpression());
        assertEquals(resultat.calculate(), 5, 0);
    }

    @Test
    public void testReadByIdWithMockito() throws MathsExceptions, SQLException {
        MathResultat resultat = new MathResultat("2+3");
        Mockito.when(daoMock.readById(anyInt())).thenReturn(resultat);
        assertEquals(resultat.calculate(), 5, 0);
    }
}