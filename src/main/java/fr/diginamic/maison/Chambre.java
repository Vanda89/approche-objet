package fr.diginamic.maison;

public class Chambre extends Piece {
    public Chambre(int superficie, int etage) {
        super(superficie, etage);
    }

    public String getType() {
        return "CHAMBRE";
    }

    @Override
    public String toString() {
        return this.getType() + " - " + super.toString();
    }



}
