package com.iut.as2021.controleur.service.interfaces;

import com.iut.as2021.controleur.facade.DtoFacadeManager;
import com.iut.as2021.dao.factory.DaoFactoryGeneric;
import com.iut.as2021.exceptions.MathsExceptions;

public interface IServiceGeneric {

    void setDao(DaoFactoryGeneric daoFactoryGeneric) throws MathsExceptions;

    void setDTO(DtoFacadeManager dtoFacadeManager) throws MathsExceptions;

}
