package com.iut.as2021.controleur.service.interfaces;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;
import com.iut.as2021.modele.BoMathResultat;

import java.util.List;

public interface IServiceMathResultat extends IServiceGeneric{

    void save(BoMathResultat boMathResultat);

    void supprimerMathResultatById(Integer id);

    BoMathResultat getMathResultatById(Integer id) throws MathsExceptions;

    List<BoMathResultat> mathResultatList() throws MathsExceptions;

    String calculer(String expression) throws MathsExceptions;
}
