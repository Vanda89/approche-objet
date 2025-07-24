package fr.diginamic.combat;

public abstract class Creature {
    protected final int force;
    protected int ptsSante;

    protected Creature(int force, int ptsSante) {
        this.force = force;
        this.ptsSante = ptsSante;
    }

    protected abstract int attaque();

    protected void subirDegats(int degats) {
        this.ptsSante -= degats;
    }


    protected boolean estVivant() {
        return ptsSante > 0;
    }

    public abstract String getType();

    public int getForce() {
        return force;
    }

    public int getPtsSante() {
        return ptsSante;
    }
}
