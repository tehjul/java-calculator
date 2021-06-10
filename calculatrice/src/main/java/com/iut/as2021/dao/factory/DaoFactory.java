package com.iut.as2021.dao.factory;

import com.iut.as2021.dao.IDaoMathResult;
import com.iut.as2021.dao.interfaces.modele.IDaoMathResultat;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.annotation.Autowire.BY_TYPE;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Configurable(preConstruction = true, autowire = BY_TYPE)
@Scope(SCOPE_PROTOTYPE)
public class DaoFactory extends DaoFactoryGeneric{

    Logger logger = Logger.getLogger(DaoFactory.class);

    @Autowired
    private IDaoMathResultat daoMathResultat;

    @Override
    public IDaoMathResultat getDaoMathResult() {
        if (daoMathResultat == null){
            logger.debug("'Dao MathResultat' est nul");
        }
        return daoMathResultat;
    }
}
