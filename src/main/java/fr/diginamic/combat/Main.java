package fr.diginamic.combat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Personnage personnage = null;
        boolean continuer = true;

        while (continuer) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Bienvenue dans le jeu !");
            System.out.println("Menu principal");
            System.out.println("1. Créer votre personnage");
            System.out.println("2. Combattre une créature");
            System.out.println("3. Prendre une potion");
            System.out.println("4. Afficher le score");
            System.out.println("5. Sortir");

            int userChoice = scanner.nextInt();


            switch (userChoice) {
                case 1:
                    personnage = new Personnage();
                    GameUtility.afficherPersonnage(personnage);
                    break;
                case 2:
                    if (personnage == null) {
                        System.out.println("Veuillez créer d'abord un personnage " +
                                "! (Choix 1)");
                    } else if (!personnage.estVivant()) {
                        GameUtility.afficherScore(personnage);
                    } else {
                        Creature creature = GameUtility.genererCreatureAleatoire();
                        GameUtility.afficherCreature(creature);
                        Combat combat = new Combat(personnage, creature);
                        combat.lancerCombat(scanner);

                    }
                    break;

                case 3:
                    Potion p = GameUtility.choisirPotion(personnage, scanner);
                    if (p != null) {
                        personnage.consommerPotion(p);
                        System.out.println("Potion consommée !");
                    } else {
                        System.out.println("Aucune potion consommée.");
                    }
                    break;

                case 4:
                    GameUtility.afficherScore(personnage);
                    break;

                case 5:
                    System.out.println("Au revoir !");
                    scanner.close();
                    System.exit(0);
                    continuer = false;
            }
        }


    }
}
