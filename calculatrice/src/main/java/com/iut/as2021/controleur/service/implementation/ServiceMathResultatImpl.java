package com.iut.as2021.controleur.service.implementation;

import com.iut.as2021.controleur.facade.DtoFacadeManager;
import com.iut.as2021.controleur.service.interfaces.IServiceMathResultat;
import com.iut.as2021.dao.factory.DaoFactoryGeneric;
import com.iut.as2021.dao.entity.EntityMathResultat;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.exceptions.MathsTechnicalExceptions;
import com.iut.as2021.metier.MathResultat;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.valueOf;

@Service
public class ServiceMathResultatImpl implements IServiceMathResultat {

    private static Logger logger = Logger.getLogger(ServiceMathResultatImpl.class);

    @Autowired
    private DaoFactoryGeneric dao;

    @Autowired
    private DtoFacadeManager dto;

    @Override
    public void setDao(DaoFactoryGeneric daoFactoryGeneric) throws MathsExceptions {
        if (daoFactoryGeneric == null) {
            throw new MathsTechnicalExceptions("Attention la Dao est null ...");
        }
        this.dao = daoFactoryGeneric;
    }

    @Override
    public void setDTO(DtoFacadeManager dtoFacadeManager) throws MathsExceptions {
        if (dtoFacadeManager == null) {
            throw new MathsTechnicalExceptions("Attention le DTO manager est null ...");
        }
        this.dto = dtoFacadeManager;
    }

    @Override
    public void save(MathResultat mathResultat) {
        logger.info("****** Sauvegarde du MathResultat ******");
        EntityMathResultat entityMathResultat = dto.getDtoMathResultat().unadapt(mathResultat);
        dao.getDaoMathResult().persist(entityMathResultat);
    }

    @Override
    public void supprimerMathResultatById(Integer id) {
        logger.info("****** Suppression d'un MathResultat par son id ******");
        dao.getDaoMathResult().supprimerMathResultatById(valueOf(id));
    }

    @Override
    public MathResultat getMathResultatById(Integer id) {
        logger.info("****** Récupération du MathResultat par son id ******");
        return dto.getDtoMathResultat().adapt(dao.getDaoMathResult().readById(valueOf(id)));
    }

    @Override
    public List<MathResultat> mathResultatList() {
        List<MathResultat> mathResultats = new ArrayList<>();
        for (EntityMathResultat entityMathResultat : dao.getDaoMathResult().getList()) {
            mathResultats.add(dto.getDtoMathResultat().adapt(entityMathResultat));
        }
        logger.info("****** Récupération de la liste des MathResultat ******");
        return mathResultats;
    }
}
