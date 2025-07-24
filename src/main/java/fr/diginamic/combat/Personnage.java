package fr.diginamic.combat;

import java.util.ArrayList;
import java.util.List;

public class Personnage {
    private int force;
    private int ptsSante;
    private int score;
    private List<Potion> inventaire;
    private int bonusAttaque;
    private int bonusAttaqueDuree;


    public Personnage() {
        // Entre 12 et 18
        this.force = (int)(Math.random() * 7) + 12;
        // Entre 20 et 50
        this.ptsSante = (int)(Math.random() * 31) + 20;
        this.score = 0;
        this.inventaire = new ArrayList<>();
        // Ajout des potions
        this.inventaire.add(new PotionSoin());
        this.inventaire.add(new PotionAttaqueMineure());
        this.inventaire.add(new PotionAttaqueMajeure());

    }

    public void consommerPotion(Potion p) {
        p.appliquerEffet(this);
       this.inventaire.remove(p);
    }

    public int attaque() {
        if (bonusAttaqueDuree > 0 ) {
            return force + bonusAttaque + (int)(Math.random() * 10 + 1);
        }
        return force + (int)(Math.random() * 10 + 1);
    }

    public void subirDegats(int degats) {
        this.ptsSante -= degats;
    }

    protected boolean estVivant() {
        return ptsSante > 0;
    }

    public void augmenterBonusAttaque(int effet, int duree) {
        this.bonusAttaque = effet;
        this.bonusAttaqueDuree = duree;
    }

    public void reduireBonusAttaque() {
        if (bonusAttaqueDuree > 0) {
            bonusAttaqueDuree--;
            if (bonusAttaqueDuree == 0) {
                bonusAttaque = 0;
            }
        }
    }

    public void augmenterScore(Creature c) {
        if (c instanceof Loup) {
            score += 1;
        } else if (c instanceof Gobelin) {
            score += 2;
        } else if (c instanceof Troll) {
            score += 5;
        }
    }

    public int getForce() {
        return force;
    }

    public int getPtsSante() {
        return ptsSante;
    }

    public void setPtsSante(int ptsSante) {
        this.ptsSante = ptsSante;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Potion> getInventaire() {
        return inventaire;
    }

    public int getNbPotions() {
        return inventaire.size();
    }


    public int getNbPotionsParType(String type) {

        int nbPotionsdeMemeType = 0;
        for (Potion p  : inventaire ) {
            if(p.getType().equalsIgnoreCase(type)) {
                nbPotionsdeMemeType++;
            }
        }
        return nbPotionsdeMemeType;
    }
}
