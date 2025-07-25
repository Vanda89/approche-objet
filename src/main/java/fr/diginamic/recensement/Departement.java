package fr.diginamic.recensement;

import fr.diginamic.fichier.Ville;

import java.util.ArrayList;
import java.util.List;

public class Departement {
    private final String codeDepartement;
    private List<Ville> villes;


    public Departement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
        this.villes = new ArrayList<>();
    }

    public List<Ville> getVilles() {
        return villes;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public int getPopulationRegion() {
        return villes.stream().mapToInt(Ville::getPopulationTotale).sum();
    }

    @Override
    public String toString() {
        return codeDepartement;
    }

    public int getPopulationDepartement() {
        return villes.stream().mapToInt(Ville::getPopulationTotale).sum();
    }
}
