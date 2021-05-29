package com.iut.as2021.dao.controleur;

import com.iut.as2021.facade.CalculatriceManager;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;



public class MathControleur extends ActionSupport {

    private String expression;
    private String resultat;
    private String error;

    private static final String APPLICATION_CONTEXT_FILE = "applicationContext.xml";

    public MathControleur() {

        ClassPathResource cp = new ClassPathResource(APPLICATION_CONTEXT_FILE);
        XmlBeanFactory factory = new XmlBeanFactory(cp);

        this.manager = (CalculatriceManager) factory.getBean("calculatriceManager");
    }

    private CalculatriceManager manager;

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
        } catch (Exception e) {
            error = e.getMessage();
            return ActionSupport.ERROR;
        }
    }
}
