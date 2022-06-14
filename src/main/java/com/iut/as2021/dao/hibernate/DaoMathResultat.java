package com.iut.as2021.dao.hibernate;

import com.iut.as2021.dao.AbstractDao;
import com.iut.as2021.dao.entity.EntityMathResultat;
import com.iut.as2021.dao.interfaces.modele.IDaoMathResultat;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class DaoMathResultat extends AbstractDao<Integer, EntityMathResultat> implements IDaoMathResultat {

    @Override
    public EntityMathResultat readById(Integer id) {
        return getByKey(id);
    }

    @Override
    public void supprimerMathResultatById(Integer id) {
        delete(getByKey(id));
    }

    @Override
    public EntityMathResultat getMathResultatById(Integer id) {
        return searchElement(((criteriaBuilder, root) -> criteriaBuilder.equal(root.get("id"), id)));
    }
}
