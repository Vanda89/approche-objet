package fr.diginamic.maison;

public class WC extends Piece{
    public WC(int superficie, int etage) {
        super(superficie, etage);
    }

    @Override
    public String getType() {
        return "WC";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " - "  + super.toString();
    }
}
