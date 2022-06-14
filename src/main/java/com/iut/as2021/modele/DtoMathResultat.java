package com.iut.as2021.modele;

import com.iut.as2021.dao.entity.EntityMathResultat;
import com.iut.as2021.dao.interfaces.IDtoGeneric;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;
import org.springframework.stereotype.Component;

@Component
public class DtoMathResultat implements IDtoGeneric<BoMathResultat, EntityMathResultat> {

    @Override
    public BoMathResultat adapt(EntityMathResultat entityMathResultat) throws MathsExceptions {
        if (entityMathResultat != null){
            BoMathResultat mathResultat = new BoMathResultat();
            mathResultat.setExpression(entityMathResultat.getExpression());
            mathResultat.setRes(String.valueOf((new MathResultat(entityMathResultat.getExpression())).calculate()));
            return mathResultat;
        }
        return null;
    }

    @Override
    public BoMathResultat adaptById(Integer id) {
        BoMathResultat mathResultat = new BoMathResultat();
        mathResultat.setId(id);
        return mathResultat;
    }

    @Override
    public EntityMathResultat unadapt(BoMathResultat boMathResultat) {
        EntityMathResultat entityMathResultat = new EntityMathResultat();
        entityMathResultat.setExpression(boMathResultat.getExpression());
        entityMathResultat.setResultat(boMathResultat.getRes());
        return entityMathResultat;
    }
}
