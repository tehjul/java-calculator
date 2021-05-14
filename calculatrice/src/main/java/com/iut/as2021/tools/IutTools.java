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

    public int NbParentheses(String expression) throws MathsExceptions {

        int posOuvrante = 0;
        int posFermante = 0;

        if(expression.charAt(0) == ')' || expression.charAt(expression.length()-1) == '('){
            throw new MathsExceptions("erreur expression : placement parenthese");
        }

        if (expression.equals("()")){
            throw new MathsExceptions(" erreur expression : vide entre parenthese");
        }

        for (int i=0; i<expression.length(); i++){
            if(expression.charAt(i)==')'){
                posFermante = i;
            }
            for (int j = i; j !=0; j--){
                if(expression.charAt(j)=='('){
                    posOuvrante = j;
                }
            }
        }

        return 0;
    }
}

/*(10+(11+12))
1- on doit connaitre la première position d'une parenthese fermante (ici 10)
2- on doit connaitre la derniere position d'une parenthese ouvrante dont la position est inferieur à resultat algo 1 (ici 4)
3- faire le calcul entre ces deux positions (donc 11+12 = 23)
4- supprimer les parentheses traités c-à-d position 4 et 10 et on retourne la concatenation du reste avec le resultat entre les prentheses (donc il ne reste que "(10+23)")
5- appel recursif de la fonction jusqu'a ce qu'il n'y a plus de parenthese*/
