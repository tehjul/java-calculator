package com.iut.as2021.tools;

public class IutTools {

    public static String getLeftExpression(String expression, int pos) {
        return expression.substring(0, pos).trim();
    }

    public static String getRightExpression(String expression, int pos) {
        return expression.substring(pos + 1).trim();
    }
}
