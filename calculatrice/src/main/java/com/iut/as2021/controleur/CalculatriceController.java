package com.iut.as2021.controleur;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.facade.CalculatriceManager;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

import static com.iut.as2021.config.BeanManager.getNewBean;


public class CalculatriceController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private String expression;
    private String resultat;
    private String error;
    private static final String MANAGER_NAME = "calculatriceManager";

    @Autowired
    private CalculatriceManager manager;

    public CalculatriceController() {
        if (this.manager == null) {
            System.out.println("Injection manuelle ...");
            this.manager = (CalculatriceManager) getNewBean(MANAGER_NAME);
        }
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String runCalcul() {
        try {
            resultat = manager.calculer(expression);
            manager.saveResult();
            return ActionSupport.SUCCESS;
        } catch (MathsExceptions | SQLException e) {
            System.out.println("Il y a une erreur ..");
            error = e.getMessage();
            return ActionSupport.ERROR;
        }
    }
}
