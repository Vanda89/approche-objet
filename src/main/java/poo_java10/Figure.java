package poo_java10;

import java.util.Collection;
import java.util.HashSet;


public abstract class Figure implements Comparable<Figure>
{
    protected final Point origin;
    private Couleur couleur;

    public Figure( Point origin, Couleur couleur)  {
        this.origin = origin;
        this.couleur = couleur;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }

    public abstract String getType();

    // Passé de Array a List
    public abstract Collection<Point> getPoints();

    public abstract String getFigureString();

    public static Figure getInstance(String line) {
        String[] parts = line.split(" ");
        String type = parts[0];

        switch (type.toLowerCase()) {
            case "rond":
                return Rond.getInstance(line);
            case "carre":
                return Carre.getInstance(line);
            case "rectangle":
                return Rectangle.getInstance(line);
            default:
                throw new IllegalArgumentException("Type de figure inconnu : " + type);
        }
    }

    public abstract boolean couvre(Point p);

    @Override
    public  String toString() {
        return getType() + ' ' + this.couleur;
    };

    public void display() {
        System.out.println(this);
    }

    public double distanceOrigin()  {
        Point initPoint = new Point();
        return initPoint.distance(this.origin);

    }

    @Override
    public  boolean equals(Object obj){
        if (this == obj) return true;
        if(!(obj instanceof Figure)) return false;
        return this.origin.equals(((Figure) obj).origin)
                && this.couleur.equals(((Figure) obj).couleur);    }


    @Override
    public int compareTo(Figure figure) {
        double d1 = distanceOrigin();
        double d2 = figure.distanceOrigin();
        if (d1 < d2) {
            return -1;
        } else if (d1 > d2) {
            return 1;
        }
        return 0;
    }


}
