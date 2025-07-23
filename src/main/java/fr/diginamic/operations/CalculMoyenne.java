package fr.diginamic.operations;


import java.util.Arrays;

public class CalculMoyenne {
    private double[] arrayOfDouble = new double[0];


    public void add(double d) {
        // Create a new array with length n + 1 that current array and its
        // entries
        double[] newArray =
                Arrays.copyOf(arrayOfDouble, arrayOfDouble.length + 1);
        // Put the new value at the end
        newArray[newArray.length - 1] = d;
        // Reassign the values in the current array
        arrayOfDouble = newArray;
    }

    /**
     *  Calcule la moyenne des entrées du tableau,
     *  parcourt le tableau pour ajouter les entrées,
     *  retourne la moyenne
     * @return double
     */
    public double calcul() {
       if (arrayOfDouble.length == 0) return 0;

       double sum = 0;
       for (double d : arrayOfDouble) {
           sum += d;
       }
       return sum / arrayOfDouble.length;
    }
}
