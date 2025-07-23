package fr.diginamic.maison;

public abstract class Piece {
    private final int superficie;
    private final int etage;

    protected Piece(int superficie, int etage) {
        if (superficie <= 0) {
            throw new IllegalArgumentException("La superficie ne peut pas " +
                    "être négative ou égale à 0.");
        }
        if (etage < 0) {
            throw new IllegalArgumentException("L'étage ne peut pas être négatif.");
        }
        this.superficie = superficie;
        this.etage = etage;
    }

    public int getSuperficie() {
        return superficie;
    }

    public int getEtage() {
        return etage;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "Étage : " + etage + ", Superficie : " + superficie + " m²";
    }
}
