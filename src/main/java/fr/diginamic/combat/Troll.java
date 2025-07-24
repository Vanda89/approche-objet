package fr.diginamic.combat;

public class Troll extends Creature {

    public Troll() {
        super((int)(Math.random() * 6) + 10, (int)(Math.random() * 11) + 20);
    }

    @Override
    public int attaque() {
        return force + (int)(Math.random() * 10 + 1);
    }

    @Override
    public String getType() {
        return "Troll";
    }
}
