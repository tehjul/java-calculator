package com.iut.as2021.controleur.facade;

import com.iut.as2021.controleur.service.interfaces.IServiceMathResultat;
import com.iut.as2021.dao.IDaoMathResult;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.exceptions.MathsTechnicalExceptions;
import com.iut.as2021.metier.MathResultat;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

import static org.apache.log4j.Logger.getLogger;

@Component
public class CalculatriceManager {

    private static final Logger logger = getLogger(CalculatriceManager.class);

    @Autowired
    private IServiceMathResultat serviceMathResultat;

/*    @Autowired
    private IDaoMathResult dao;
    private MathResultat calculatrice;


    public CalculatriceManager(IDaoMathResult dao){
        this.dao = dao;
    }*/

    public List<MathResultat> getMathResultats() throws MathsTechnicalExceptions {
        logger.info(" -> Liste des MathResultat demandés par le certification manager");
        try {
            return serviceMathResultat.mathResultatList();
        } catch (Exception e) {
            throw new MathsTechnicalExceptions(e.getMessage());
        }
    }

    public MathResultat getMathResultatById(String id) {
        logger.info(" -> Demande des informations mathresultat par le certification manager");
        return serviceMathResultat.getMathResultatById(Integer.valueOf(id));
    }

    public void sauverMathResultat(MathResultat mathResultat) throws MathsTechnicalExceptions {
        logger.info(" -> Sauvegarde du mathresultat courant par le certification manager");
        try {
            serviceMathResultat.save(mathResultat);
        } catch (Exception e) {
            throw new MathsTechnicalExceptions("Erreur technique lors de la sauvegarde du mathresultat");
        }
    }

    public void suppressionMathResultatById(String id) {
        logger.info(" -> Suppression du mathresultat demandée par le certification manager");
        serviceMathResultat.supprimerMathResultatById(Integer.valueOf(id));
    }

/*    public String calculer(String expression) throws MathsExceptions {
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
    }*/

}