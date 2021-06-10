package com.iut.as2021.modele;

import com.iut.as2021.dao.entity.EntityMathResultat;
import com.iut.as2021.dao.interfaces.IdtoGeneric;
import com.iut.as2021.metier.MathResultat;

public class DtoMathResultat implements IdtoGeneric<MathResultat, EntityMathResultat> {

    @Override
    public MathResultat adapt(EntityMathResultat entityMathResultat) {
        if (entityMathResultat != null){
            MathResultat mathResultat = new MathResultat();
            mathResultat.setExpression(entityMathResultat.getExpression());
            return mathResultat;
        }
        return null;
    }

    @Override
    public MathResultat adaptById(Integer id) {
        MathResultat mathResultat = new MathResultat();
        mathResultat.setId(id);
        return mathResultat;
    }

    @Override
    public EntityMathResultat unadapt(MathResultat mathResultat) {
        EntityMathResultat entityMathResultat = new EntityMathResultat();
        entityMathResultat.setExpression(mathResultat.getExpression());
        return entityMathResultat;
    }
}
