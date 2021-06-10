package com.iut.as2021.dao.interfaces.modele;

import com.iut.as2021.dao.entity.EntityMathResultat;
import com.iut.as2021.dao.interfaces.IDaoGeneric;

public interface IDaoMathResultat extends IDaoGeneric<EntityMathResultat> {

    void supprimerMathResultatById(Integer id);

    EntityMathResultat getMathResultatById(Integer id);
}
