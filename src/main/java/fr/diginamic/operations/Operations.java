package fr.diginamic.operations;

public class Operations {

    /**
     * Calcule deux nombres en fonction de l'opérateur
     * @param a
     * @param b
     * @param o
     * @return un double = résultat de l'opération
     * @throws Exception
     */
    public static double calcul(double a, double b, char o) throws Exception {
        if (o == '+') {
            return a + b;
        } else if(o == '-'){
            return a - b;
        } else if (o == '*') {
            return a * b;
        } else if (o == '/') {
            return a / b;
        } else {
            throw new Exception("Mauvais opérateur testé");
        }


    }
}
