package fr.diginamic.combat;

public class Gobelin extends Creature {

    public Gobelin() {
        super((int)(Math.random() * 6) + 5, (int)(Math.random() * 6) + 10);

    }

    @Override
    public int attaque() {
        return force + (int)(Math.random() * 10 + 1);
    }

    @Override
    public String getType() {
        return "Gobelin";
    }
}
