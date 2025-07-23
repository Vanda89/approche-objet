package fr.diginamic.essais;

import fr.diginamic.maison.*;


public class TestMaison {
    public static void main(String[] args) {
        try {
            Maison maison = new Maison();
            Chambre chambre = new Chambre(24, 0);
            Chambre chambre2 = new Chambre(20, 1);
            Chambre chambre3 = new Chambre(16, 1);
            Cuisine cuisine = new Cuisine(15, 0);
            Salon salon = new Salon(18, 0);
            Salon salon2 = new Salon(18, 2);
            SalleDeBain salleDeBain = new SalleDeBain(12, 0);
            SalleDeBain salleDeBain2 = new SalleDeBain(14, 1);
            WC wc = new WC(6, 0);
            WC wc2 = new WC(6, 1);

            maison.ajouterPiece(chambre, chambre2, chambre3, cuisine, salon,
                    salon2, salleDeBain, salleDeBain2, wc, wc2);
            System.out.println(maison);
            double superficieTotale = maison.getSuperficie();
            System.out.println("La superficie de la maison est de : " + superficieTotale + " m²");
            double superficieRDC = maison.getSuperficieEtage(0);
            System.out.println("La superficie du RDC est de : " + superficieRDC + " m²");
            double superficiePremier = maison.getSuperficieEtage(1);
            System.out.println("La superficie du premier est de : " + superficiePremier + " m²");
            double superficieSecond = maison.getSuperficieEtage(2);
            System.out.println("La superficie du second est de : " + superficieSecond + " m²");
            System.out.println();
            System.out.println("Le nombre de chambres est de : " + maison.getNbPiecesParTypePiece("chambre"));
            System.out.println("La superficie totale des chambres est de : " + maison.getSuperficieParTypePiece("chambre") + " m²");
            System.out.println();
            maison.ajouterPiece(null);
        } catch (Exception e) {
            System.out.println("!!!Erreur lors de l'ajout des pièces : " + e.getMessage());
        }

        try {
            Maison maison = new Maison();
            maison.ajouterPiece(new Chambre(-10, 1));
            System.out.println(maison);

        } catch (Exception e) {
            System.out.println("!!!Erreur lors de l'ajout des pièces : " + e.getMessage());
        }

        try {
            Maison maison = new Maison();
            maison.ajouterPiece(new Chambre(10, -1));
            System.out.println(maison);

        } catch (Exception e) {
            System.out.println("!!!Erreur lors de l'ajout des pièces : " + e.getMessage());
        }

    }
}
