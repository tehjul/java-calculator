package com.iut.as2021.enumerations;

public enum EOperation {
    INCONNUE(0, ""),
    ADDITION(1, "+"),
    SOUSTRACTION(2, "-"),
    MULTIPLICATION(3, "*"),
    DIVISION(4, "/");

    private int code;
    private String operateur;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    private EOperation(int code, String operateur) {
        this.code = code;
        this.operateur = operateur;
    }
}
