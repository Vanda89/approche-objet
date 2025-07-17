package poo_java10;

import java.util.*;

public class Dessin {
private final Collection<Figure> figures;


    public Dessin() {
        this.figures = new HashSet<>();
    }

    public Dessin(Collection <Figure> figures) {
        this();
        this.figures.addAll(figures);
    }

    public boolean add(Figure figure) {
        return  figures.add(figure);
    }


    public Collection<Figure> getFigures() {
        return new HashSet<Figure>(figures);
    }
}
