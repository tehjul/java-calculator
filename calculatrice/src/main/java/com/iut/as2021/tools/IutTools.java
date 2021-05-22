package com.iut.as2021.tools;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.MathResultat;

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

    public static String getNextInt(String expression, int pos) {
        String res = "";
        for (int i = pos; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == 32 && res != "") {
                return res;
            }
            if (c > 47 && c < 58) {
                res += c;
            }
        }
        return res;
    }

    public static boolean isGoodParenthesis(String expression){
        int index = 0;

        for (int i = 0; i < expression.length(); i++){
            if (expression.charAt(i) == '(') {
                System.out.println("J'ai une ouvrante");
                index++;
            } else if (expression.charAt(i) == ')') {
                System.out.println("J'ai une fermante");
                index--;
            }
        }
        return index == 0;
    }

    public static String TrimBorderParenthesis(String expression){
        if (expression.charAt(0) == '(' && expression.charAt(expression.length()-1) == ')'){
            return TrimBorderParenthesis(expression.substring(1, expression.length()-1).trim());
        }
        return expression;
    }

    public static int NbParentheses(String expression){
        int result = 0;
        for (int i = 0; i < expression.length(); i++){
            if (expression.charAt(i) == '(' || expression.charAt(i) == ')'){
                result++;
            }
        }
        return result;
    }

    public static int getFirstClosingParenthesis(String expression) throws MathsExceptions{
        if (!isGoodParenthesis(expression)){
            throw new MathsExceptions("Expression mal parenthesée");
        } else {
           for (int i = 0; i < expression.length(); i++){
               if (expression.charAt(i) == ')'){
                   return i;
               }
           }
        }
        return 0;
    }

    public static int getLastOpeningParenthesis(String expression) throws MathsExceptions{
        int last = 0;
        if (!isGoodParenthesis(expression)){
            throw new MathsExceptions("Expression mal parenthesée");
        } else {
            int pos = getFirstClosingParenthesis(expression);

            for (int i = 0; i < pos; i++) {
                if (expression.charAt(i) == '(') {
                    last = i;
                }
            }
        }
        return last;
    }

    public static MathResultat insideExpression(String expression) throws MathsExceptions {
        int closingpos = getFirstClosingParenthesis(expression);
        int openingpos = getLastOpeningParenthesis(expression);
        String newExpression = expression.substring(openingpos+1, closingpos);
        return new MathResultat(newExpression);
    }

    public static String deleteParenthesis(String expression, int pos1, int pos2) throws MathsExceptions{
        String result = "";
        for (int i = 0; i < expression.length(); i++){
            if (i != pos1 && i != pos2){
                result += expression.charAt(i);
            }
        }
        return result;
    }

    public static String deleteBetween2Pos(String expression, int pos1, int pos2) throws MathsExceptions{
        String result = "";
        for (int i = 0; i < expression.length(); i++){
            if (i < pos1 || i > pos2){
                result += expression.charAt(i);
            }
        }
        return result;
    }

    public static String addToPos(String expression, String exptoadd, int pos) throws MathsExceptions{
        String result = "";
        for (int i = 0; i < expression.length(); i++){
            result += expression.charAt(i);
            if (i == pos-1){
                for (int j = 0; j < exptoadd.length(); j++){
                    result += exptoadd.charAt(j);
                }
            }
        }
        return result;
    }

    public static String getEntireExpressionBetweenParenthesis(String expression) throws MathsExceptions {

        String result = "";
        while (NbParentheses(expression)!=0){
            int pos1 = getLastOpeningParenthesis(expression);
            int pos2 = getFirstClosingParenthesis(expression);
            MathResultat expressionToAdd = insideExpression(expression);
            String expression1 = deleteBetween2Pos(expression, pos1, pos2);
            String expression2 = deleteParenthesis(expression1, pos1, pos2);
            //String expression3 = addToPos(expression2, expressionToAdd, pos1);
            result = ""; //+ expression3;
        }
        return result;
    }


}

/*(10+(11+12))
1- on doit connaitre la première position d'une parenthese fermante (ici 10)
2- on doit connaitre la derniere position d'une parenthese ouvrante dont la position est inferieur à resultat algo 1 (ici 4)
3- faire le calcul entre ces deux positions (donc 11+12 = 23)
4- supprimer les parentheses traités c-à-d position 4 et 10 et on retourne la concatenation du reste avec le resultat entre les prentheses (donc il ne reste que "(10+23)")
5- appel recursif de la fonction jusqu'a ce qu'il n'y a plus de parenthese*/
