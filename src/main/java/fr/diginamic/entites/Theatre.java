package fr.diginamic.entites;

public class Theatre {
    public final String name;
    private final int maxCapacity;
    private int totalClients;
    private int recette;

    public Theatre(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.totalClients = 0;
        this.recette = 0;
    }

    /**
     * Inscrit des personnes sur le registre du théâtre
     * Verifie la capacité de personnes dans le théâtre et incrémente la
     * recette en fonction du nombre de places achetées
     * @param nbClients
     * @param placePrice
     * @throws Exception
     */
    public void inscrire(int nbClients, int placePrice) throws Exception {
        if (totalClients + nbClients <= maxCapacity) {
            totalClients += nbClients;
            recette = placePrice * nbClients;
        } else {
            throw new Exception("Capacité maximale atteinte");
        }

    }

    public int getTotalClients() {
        return totalClients;
    }

    public int getRecette() {
        return recette;
    }
}
