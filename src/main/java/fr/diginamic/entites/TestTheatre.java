package fr.diginamic.entites;

public class TestTheatre {
    public static void main(String[] args) {
        try {
            Theatre theatre = new Theatre("Théâtre de la mer", 35);
            theatre.inscrire(2, 10);
            System.out.println("Le nombre de clients dans le théâtre est de :" +
                    " " + theatre.getTotalClients() + " personnes");
            System.out.println("La recette actuelle est de : " + theatre.getRecette() + " euros");
            System.out.println();
            theatre.inscrire(6, 10);
            System.out.println("Le nombre de clients dans le théâtre est de :" +
                    " " + theatre.getTotalClients() + " personnes");
            System.out.println("La recette actuelle est de : " + theatre.getRecette() + " euros");
            System.out.println();
            theatre.inscrire(10, 10);
            theatre.inscrire(3, 10);
            System.out.println("Le nombre de clients dans le théâtre est de :" +
                    " " + theatre.getTotalClients() + " personnes");
            System.out.println("La recette actuelle est de : " + theatre.getRecette() + " euros");
            System.out.println();
            theatre.inscrire(1, 10);
            theatre.inscrire(6, 10);
            System.out.println("Le nombre de clients dans le théâtre est de :" +
                    " " + theatre.getTotalClients() + " personnes");
            System.out.println("La recette actuelle est de : " + theatre.getRecette() + " euros");
            System.out.println();
            theatre.inscrire(15, 10);
            System.out.println("Le nombre de clients dans le théâtre est de :" +
                    " " + theatre.getTotalClients() + " personnes");
            System.out.println("La recette actuelle est de : " + theatre.getRecette() + " euros");
            System.out.println();
        } catch (Exception e) {
            System.out.println("!!! Erreur : " + e.getMessage());
        }
    }
}
