package fr.diginamic.recensement;

import fr.diginamic.fichier.Ville;

import java.util.ArrayList;
import java.util.List;


public class Region {
    private final int codeRegion;
    private final String nomRegion;
    private List<Ville> villes;


    public Region(int codeRegion, String nomRegion) {
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
        this.villes = new ArrayList<>();
    }


    public List<Ville> getVilles() {
        return villes;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public int getCodeRegion() {
        return codeRegion;
    }

    public int getPopulationRegion() {
        return villes.stream().mapToInt(Ville::getPopulationTotale).sum();
    }

    @Override
    public String toString() {
        return nomRegion + codeRegion + getPopulationRegion();
    }
}
