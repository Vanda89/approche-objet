package fr.diginamic.combat;

public abstract class Potion {
    private String type;
    private final int ptsEffets;
    private final int duree;

    public Potion(String type, int ptsEffets, int duree) {
        this.type = type;
        this.ptsEffets = ptsEffets;
        this.duree = duree;
    }

    public abstract void appliquerEffet(Personnage p);


    public String getType() {
        return this.type;
    }


}
