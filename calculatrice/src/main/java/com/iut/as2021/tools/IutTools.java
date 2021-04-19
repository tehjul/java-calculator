package com.iut.as2021.tools;

public class IutTools {

    public static String getLeftExpression(String expression, int pos) {
        return expression.substring(0, pos).trim();
    }

    public static String getRightExpression(String expression, int pos) {
        return expression.substring(pos + 1).trim();
    }

    public static char getNextOperand(String expression, int pos) {
        for (int i = pos; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == 42 || c == 43 || c == 45 || c == 47){
                return c;
            }
        }
        return 32;
    }
}
