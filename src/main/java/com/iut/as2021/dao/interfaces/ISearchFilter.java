package com.iut.as2021.dao.interfaces;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface ISearchFilter<T> {

    Predicate buildPredicate(CriteriaBuilder criteriaBuilder, Root<T> root);
}
