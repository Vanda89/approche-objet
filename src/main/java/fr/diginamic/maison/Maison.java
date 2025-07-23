package fr.diginamic.maison;

import java.util.ArrayList;
import java.util.List;

public class Maison {
    private List<Piece> pieces;

    public Maison() {
        this.pieces = new ArrayList<>();
    }

    public void ajouterPiece(Piece... pieces) {
        if (pieces == null) {
            throw new IllegalArgumentException("La pièce ajoutée est de type " +
                    "null");
        }
        for (Piece p : pieces) {
            if (p == null) {
                throw new IllegalArgumentException("La pièce ajoutée est de " +
                        "type null");
            }
            if (p.getSuperficie() <= 0 || p.getSuperficie() < 0) {
                throw new IllegalArgumentException("La pièce a des données " +
                        "incohérentes");
            }
            this.pieces.add(p);
        }
    }

    public double getSuperficie() {
        double superficie = 0;
        for (Piece p : pieces) {
            superficie += p.getSuperficie();
        }
        return superficie;
    }

    public double getSuperficieEtage(int etage) {
        double etageSuperficie = 0;
        for (Piece p : pieces) {
            if (etage == p.getEtage()) {
                etageSuperficie += p.getSuperficie();
            }
        }
        return etageSuperficie;
    }

    @Override
    public String toString() {
        return "La maison est composée de " + pieces;
    }

    public double getSuperficieParTypePiece(String type){
        double superficiePiece = 0;
       for (Piece p  : pieces) {
           if(p.getType().equalsIgnoreCase(type)) {
               superficiePiece += p.getSuperficie();
           }
       }
        return superficiePiece;
    }

    public int getNbPiecesParTypePiece(String type) {
        int nbPiecesdeMemeType = 0;
        for (Piece p  : pieces) {
            if(p.getType().equalsIgnoreCase(type)) {
                nbPiecesdeMemeType++;
            }
        }
        return nbPiecesdeMemeType;
    }


}
