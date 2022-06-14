package com.iut.as2021.controleur.facade;

import com.iut.as2021.modele.DtoMathResultat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoFacadeManager {

    @Autowired
    private DtoMathResultat dtoMathResultat;

    public DtoMathResultat getDtoMathResultat(){
        return dtoMathResultat;
    }

    public void setDtoMathResultat(DtoMathResultat dtoMathResultat) {
        this.dtoMathResultat = dtoMathResultat;
    }
}
