package fr.diginamic.combat;

public class PotionSoin extends Potion {
    public PotionSoin() {
        super("Soin", 0, 0);
    }

    @Override
    public void appliquerEffet(Personnage p) {
        int potionEffect = (int)(Math.random() * 6) + 5;
        int ptsDeVie = p.getPtsSante();
        p.setPtsSante( ptsDeVie + potionEffect);
    }
}
