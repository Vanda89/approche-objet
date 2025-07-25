package fr.diginamic.recensement;

import fr.diginamic.fichier.Ville;

import java.util.List;

public class Recensement {
    private List<Ville> villes;

    public Recensement(List<Ville> villes) {
        this.villes = villes;
    }

    public List<Ville> getVilles() {
        return villes;
    }

    @Override
    public String toString() {
        return "Recensement avec %d villes.".formatted(villes.size());
    }
}
