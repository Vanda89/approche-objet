package fr.diginamic.combat;

public class PotionAttaqueMajeure extends Potion  {
    public PotionAttaqueMajeure() {
        super("Attaque majeure", 5, 2);
    }

    @Override
    public void appliquerEffet(Personnage p) {
        p.augmenterBonusAttaque(5, 2);
    }
}
