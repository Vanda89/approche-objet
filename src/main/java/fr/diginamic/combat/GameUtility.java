package fr.diginamic.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameUtility {

    public static Creature genererCreatureAleatoire() {
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0:
                return new Loup();
            case 1:
                return new Gobelin();
            case 2:
                return new Troll();
            default:
                return null;
        }
    }


    public static void afficherInventaire(Personnage p) {
        // Verifie l'état de l'inventaire
        if (p.getInventaire() == null || p.getInventaire().isEmpty()) {
            System.out.println("Votre inventaire est vide !");
            return;
        }

        System.out.println("Votre inventaire dispose des potions suivantes : ");
        // Création d'une liste avec chacune des potions en 1 fois
        List<String> typesAffiches = new ArrayList<>();

        for (Potion potion  : p.getInventaire()) {
            String type = potion.getType();
            if (!typesAffiches.contains(type)) {
                typesAffiches.add(type);
            }
        }

        // Affichage final des potions avec leur index, leur type et leur nombre
        for (int i = 0; i < typesAffiches.size(); i++) {
            String type = typesAffiches.get(i);
            int nb = p.getNbPotionsParType(type);
            System.out.println((i + 1) + ". " + type + " (" + nb + ")");
        }
    }

    public static Potion choisirPotion(Personnage p,
                                       Scanner scanner) {
        if (p.getInventaire().isEmpty()) {
            System.out.println("Votre inventaire est vide !");
            return null;
        }
        afficherInventaire(p);
        while (true) {
            try {
                int choix = scanner.nextInt();
                scanner.nextLine();

                if (choix >= 1 && choix <= p.getInventaire().size()) {
                    return p.getInventaire().get(choix - 1);
                } else {
                    System.out.println("Numéro invalide.");
                }

            } catch (Exception e) {
                System.out.println("Entrée invalide, recommencez votre choix.");
                scanner.nextLine();
            }

        }

    }

    public static void afficherPersonnage(Personnage p) {
        System.out.println("Le personnage dispose de " + p.getPtsSante() +
                " points de vie, de " + p.getForce() +
                " points de force et d'un inventaire avec " + p.getNbPotions() + " potions");
        afficherInventaire(p);
    }

    public static void afficherCreature(Creature c) {
        System.out.println("La créature est de type " + c.getType() + " elle " +
                "a" +
                " " + c.getPtsSante() + " points de vie et " + c.getForce() +
                " points de force.");
    }


    public static void afficherScore(Personnage p) {
        if (p.estVivant()) {
            System.out.println("Le score du personnage est de " + p.getScore() + " points.");

        } else {
            System.out.println("Votre personnage est décédé. Il a " +
                    "obtenu le score de " + p.getScore() +
                    " points. Veuillez créer un nouveau personnage ! " +
                    "(Choix 1) ");
        }

    }


    public static void tirageRecompence(Personnage personnage) {
        Random random = new Random();
        switch (random.nextInt(5)) {
            case 1:
                personnage.getInventaire().add(new PotionSoin());
                System.out.println("Vous recevez une Potion de soin !");
                break;
            case 2:
                personnage.getInventaire().add(new PotionAttaqueMineure());
                System.out.println("Vous recevez une potion d'attaque mineure" +
                        " !");
                break;
            case 3:
                personnage.getInventaire().add(new PotionAttaqueMajeure());
                System.out.println("Vous recevez une potion d'attaque majeure" +
                        " !");
                break;
            case 4:
                personnage.setScore(personnage.getScore() + 5);
                System.out.println("Vous recevez 5 points de score !");
                break;
            default:
                System.out.println("Pas de récompense cette fois !");
                break;
        }

    }
}
