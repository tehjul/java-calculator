package com.iut.as2021.facade;

import com.iut.as2021.dao.IDaoMathResult;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

import static org.apache.log4j.Logger.getLogger;

@Component
public class CalculatriceManager {

    @Autowired
    private IDaoMathResult dao;
    private MathResultat calculatrice;
    private static final Logger logger = getLogger(CalculatriceManager.class);

    public CalculatriceManager(IDaoMathResult dao){
        this.dao = dao;
    }

    public String calculer(String expression) throws MathsExceptions {
        try {
            this.calculatrice = new MathResultat(expression);
            logger.info("expression saisie : " + calculatrice.getExpression() + " resultat retourné : "+ calculatrice.getValue());
            return String.valueOf(calculatrice.calculate());
        } catch (Exception e) {
            throw new MathsExceptions(e.getMessage());
        }
    }

    public boolean saveResult() throws SQLException {
        try {
            logger.info("Sauvegarde dans la BDD");
            return dao.create(calculatrice);
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

}
