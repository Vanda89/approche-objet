package poo_java10;

import java.util.*;

public class Dessin {
    private final Collection<Figure> figures;

    public Dessin() {
        figures = new HashSet<Figure>();
    }

    public Dessin(Collection<Figure> figures) {
        this();
        this.figures.addAll(figures);
    }

    public boolean add(Figure figure) {
        return figures.add(figure);
    }

    public Collection<Figure> getFigures() {
        // Si on veut retourner une copie de la liste
        //return new HashSet<Figure>(figures);

        // Si on veut retourner une référence sur la liste
        return figures;
    }
}
