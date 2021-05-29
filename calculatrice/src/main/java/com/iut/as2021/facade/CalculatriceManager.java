package com.iut.as2021.facade;

import com.iut.as2021.dao.DaoFactory;
import com.iut.as2021.dao.ETypeDao;
import com.iut.as2021.dao.IDaoMathResult;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.sql.SQLException;

import static com.iut.as2021.dao.DaoFactory.getDAOFactory;
import static com.iut.as2021.dao.ETypeDao.MYSQL;

public class CalculatriceManager {

    private IDaoMathResult dao;

    private MathResultat calculatrice;

    private double resultat;

    private static final String APPLICATION_CONTEXT_FILE = "applicationContext.xml";

    public CalculatriceManager(IDaoMathResult dao){
        // on va prépare l'injection
        // on continue à préparer l'injection..
        //ClassPathResource cp = new ClassPathResource(APPLICATION_CONTEXT_FILE);
        // XmlBeanFactory factory = new XmlBeanFactory(cp);
        // dao = (IDaoMathResult) factory.getBean("dao");
        this.dao = dao;
        // dao = (IDaoMathResult) getDAOFactory(MYSQL);
    }

    public String calculer(String expression) throws MathsExceptions {
        try {
            this.calculatrice = new MathResultat(expression);
            return String.valueOf(calculatrice.calculate());
        } catch (Exception e) {
            throw new MathsExceptions(e.getMessage());
        }
    }

    public boolean saveResult() throws SQLException {
        return dao.create(calculatrice);
    }

}
