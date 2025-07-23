package fr.diginamic.chaines;

import java.util.Arrays;

public class ManipulationChaine {
    public static String chaine = "Durand;Marcel;2 523.5";

    public static void main(String[] args) {
        char firstChar = chaine.charAt(0);
        System.out.println("Premier caractère: " + firstChar);

        int chaineLength = chaine.length();
        System.out.println("La longueur de la chaine est de : " + chaineLength);

        int indexOfChar = chaine.indexOf(';');
        System.out.println("Le premier ; est à l'index : " + indexOfChar);

        String lastName = chaine.substring(0 , indexOfChar);
        System.out.println(lastName);

        String inUpperCase = lastName.toUpperCase();
        System.out.println(inUpperCase);

        String inLowerCase = lastName.toLowerCase();
        System.out.println(inLowerCase);

        char chaineSeparator = ';';
        String[] newChaine = chaine.split(String.valueOf(chaineSeparator));
        System.out.println(Arrays.toString(newChaine));


        Salarie salarie = new Salarie();
        salarie.setLastName(lastName);
        System.out.println("Le nom du salarié est : " + salarie.getLastName());
        salarie.setFirstName(newChaine[1]);
        System.out.println("Le prénom du salarié est : " + salarie.getFirstName());
        salarie.setSalary(Double.parseDouble(newChaine[2].replace(" ", "")));
        System.out.println("Son salaire est de : " + salarie.getSalary());
    }

}
