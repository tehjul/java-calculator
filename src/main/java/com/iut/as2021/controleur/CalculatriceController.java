/*
package com.iut.as2021.controleur;

import com.iut.as2021.controleur.facade.CalculatriceManager;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.exceptions.MathsTechnicalExceptions;
import com.iut.as2021.metier.MathResultat;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;


import static org.apache.log4j.LogManager.getLogger;

public class CalculatriceController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private String expression;
    private String resultat;
    private String error;
    private List<MathResultat> historique;
    private static final String MANAGER_NAME = "calculatriceManager";

    private static final Logger logger = getLogger(CalculatriceController.class);

    @Autowired
    private CalculatriceManager manager;

    public CalculatriceController() {
        if (this.manager == null) {
            logger.info("Injection manuelle du manager");
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

    public String getHistorique() throws MathsTechnicalExceptions {
        historique = manager.getMathResultats();
        return ActionSupport.SUCCESS;
    }
}
*/
