package fr.diginamic.essais;

import fr.diginamic.operations.Operations;


public class TestOperations {
    public static void main(String[] args) {
       try {
            double result = Operations.calcul(3, 4, '+');
            System.out.println("  " + result);
            result = Operations.calcul(3, 4, '-');
            System.out.println(" " + result);
            result = Operations.calcul(3, 4, '*');
            System.out.println(" " + result);
            result = Operations.calcul(3, 4, '/');
            System.out.println(" " + result);
            result = Operations.calcul(3, 4, '%');
            System.out.println(" " + result);
        } catch (Exception e) {
           System.out.println("!!! Erreur : " + e.getMessage());
       }

    }

}
