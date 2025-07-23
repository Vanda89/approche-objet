package fr.diginamic.essais;

import fr.diginamic.operations.CalculMoyenne;

public class TestMoyenne {
    public static void main(String[] args) {
        CalculMoyenne array =
                new CalculMoyenne();
        array.add(12.0);
        array.add(24.0);
        array.add(36.0);
        array.add(48.0);
        System.out.println("La moyenne du tableau est de : " + array.calcul());

        CalculMoyenne array2 =
                new CalculMoyenne();
        array2.add(60.0);
        System.out.println("La moyenne du tableau est de : " + array2.calcul());



    }
}
