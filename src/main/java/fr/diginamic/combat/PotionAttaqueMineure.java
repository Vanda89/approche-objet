package fr.diginamic.combat;

public class PotionAttaqueMineure extends Potion  {
    public PotionAttaqueMineure() {
        super("Attaque mineure", 3, 1);
    }

    @Override
    public void appliquerEffet(Personnage p) {
        p.augmenterBonusAttaque(3, 1);

    }
}
