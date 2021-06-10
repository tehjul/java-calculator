package com.iut.as2021.controleur.service.interfaces;

import com.iut.as2021.metier.MathResultat;

import java.util.List;

public interface IServiceMathResultat extends IServiceGeneric{

    void save(MathResultat mathResultat);

    void supprimerMathResultatById(Integer id);

    MathResultat getMathResultatById(Integer id);

    List<MathResultat> mathResultatList();
}
