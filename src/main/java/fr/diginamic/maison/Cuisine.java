package fr.diginamic.maison;

public class Cuisine extends Piece {
    public Cuisine(int superficie, int etage) {
        super(superficie, etage);
    }

    @Override
    public String getType() {
        return "CUISINE";
    }

    @Override
    public String toString() {
        return this.getType() + " - "  + super.toString();
    }
}
