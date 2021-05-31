package com.iut.as2021.facade;

import com.iut.as2021.dao.IDaoMathResult;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class CalculatriceManager {

    @Autowired
    private IDaoMathResult dao;

    private MathResultat calculatrice;

    public CalculatriceManager(IDaoMathResult dao){
        this.dao = dao;
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
        try {
            return dao.create(calculatrice);
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

}
