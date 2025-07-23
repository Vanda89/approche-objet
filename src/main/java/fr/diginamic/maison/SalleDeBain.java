package fr.diginamic.maison;

public class SalleDeBain extends Piece {
    public SalleDeBain(int superficie, int etage) {
        super(superficie, etage);
    }

    @Override
    public String getType() {
        return "SALLE DE BAIN";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " - "  + super.toString();
    }
}
