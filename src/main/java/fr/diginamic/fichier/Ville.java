package fr.diginamic.fichier;

public class Ville {

    private final int codeRegion;
    private final String nomRegion;
    private final String codeDepartement;
    private final int codeVille;
    private final String nomVille;
    private final int populationTotale;

    public Ville(int codeRegion, String nomRegion, String codeDepartment,
                 int codeVille,
                 String nomVille, int populationTotale) {
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
        this.codeDepartement = codeDepartment;
        this.codeVille = codeVille;
        this.nomVille = nomVille;
        this.populationTotale = populationTotale;
    }


    public String getNomVille() {
        return nomVille;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public int getPopulationTotale() {
        return populationTotale;
    }

    public int getCodeRegion() {
        return codeRegion;
    }

    public int getCodeVille() {
        return codeVille;
    }

    @Override
    public String toString() {
        return nomVille + " (" + codeVille + "), Département: " + codeDepartement
                + ", Région: " + nomRegion + ", Population: " + populationTotale;
    }
}
