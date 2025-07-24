package fr.diginamic.combat;

import java.util.Scanner;

public class Combat {
    private Personnage personnage;
    private Creature creature;

    public Combat(Personnage personnage, Creature creature) {

        this.personnage = personnage;
        this.creature = creature;

    }

    public void lancerCombat(Scanner scanner) {
        int degats;
        while (personnage.estVivant() && creature.estVivant()) {
            int attaquePerso = personnage.attaque();
            int attaqueCreature = creature.attaque();
            System.out.println("Le personnage attaque avec " + attaquePerso + " points");
            System.out.println("La créature attaque avec " + attaqueCreature + " points");
            int ptsSantePerso = personnage.getPtsSante();
            System.out.println("Le personnage a " + ptsSantePerso + " points");
            int ptsSanteCreature = creature.getPtsSante();
            System.out.println("La créature a " + ptsSanteCreature + " points");


            if (attaquePerso > attaqueCreature) {
                degats = attaquePerso - attaqueCreature;
                System.out.println("Le personnage inflige " + degats + " points de dégâts à la créature.");
                creature.subirDegats(degats);
                if (!creature.estVivant()) {
                    System.out.println("La créature est morte !");
                    personnage.augmenterScore(creature);
                    GameUtility.afficherScore(personnage);
                    GameUtility.tirageRecompence(personnage);
                    break;
                }
            } else if (attaquePerso < attaqueCreature) {
                degats = attaqueCreature - attaquePerso;
                System.out.println("La créature inflige " + degats + " points de dégâts au personnage.");
                personnage.subirDegats(degats);
                if (!personnage.estVivant()) {
                    GameUtility.afficherScore(personnage);
                    break;
                }
            } else {
                System.out.println("Egalité ! Aucun dégâts infligés");
            }
            personnage.reduireBonusAttaque();


        }
    }


}
