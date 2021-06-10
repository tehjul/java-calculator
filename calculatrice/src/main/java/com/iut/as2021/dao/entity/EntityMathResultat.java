package com.iut.as2021.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "TBL_CALCULATRICE")
public class EntityMathResultat implements Serializable {

    private static final long serialVersionUID = 1L;

    public EntityMathResultat(){
        // for JPA ...
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "expression")
    private String expression;

    @Column(name = "resultat")
    private double resultat;

    @Column(name = "date")
    private Date date;

    @Override
    public boolean equals(Object objet){
        if (objet == null){
            return false;
        }
        if (!(objet instanceof EntityMathResultat)) {
            return false;
        }
        EntityMathResultat other = (EntityMathResultat) objet;
        return this.id.equals(other.id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getResultat() {
        return resultat;
    }

    public void setResultat(double resultat) {
        this.resultat = resultat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}
