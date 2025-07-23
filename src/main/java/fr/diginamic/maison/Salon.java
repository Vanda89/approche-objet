package fr.diginamic.maison;

public class Salon extends Piece {
    public Salon(int superficie, int etage) {
        super(superficie, etage);
    }

    @Override
    public String getType() {
        return "SALON";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " - "  + super.toString();
    }
}
