package com.iut.as2021.modele;

import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class BoMathResultat {

    private Integer id;

    @Size(message = "{expression.expression.invalid}")
    @NotEmpty(message = "Merci de rentrer une expression")
    private String expression;

    private String res;

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

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public boolean isNew() {return id == null;}
}
