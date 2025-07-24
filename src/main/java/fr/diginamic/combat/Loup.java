package fr.diginamic.combat;

public class Loup extends Creature{

    public Loup() {
        super((int)(Math.random() * 6) + 3, (int)(Math.random() * 6) + 5);

    }

    @Override
    public int attaque() {
        return force + (int)(Math.random() * 10 + 1);
    }

    @Override
    public String getType() {
        return "Loup";
    }

}
