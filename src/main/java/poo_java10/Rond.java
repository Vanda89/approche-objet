package poo_java10;

import java.util.Set;

public class Rond extends Figure implements Surfacable {
    private final int rayon;

    public Rond(Point origin,
                int rayon )  {
        this(origin, rayon, Couleur.getCouleurDefault());

    }

    public Rond(Point origin,
                int rayon, Couleur couleur )  {
        super(origin, couleur);
        this.rayon = rayon;

    }

    @Override
    public String getType() {
        return "ROND";
    }

    @Override
    public String toString() {
        return "[" + getType() + "[" + '['+ origin + ']' + ' ' + this.rayon +
                ", couleur = " + getCouleur() + "]]";
    }

    public Point getCentre() {
        return origin;
    }
    public int getRayon() {return this.rayon;}


    @Override
    public Set<Point> getPoints() {
        return (Set.of(getCentre()));
    }

    @Override
    public String getFigureString() {
        return String.format("Rond x=%d y=%d rayon=%d couleur=%s",
                getCentre().getX(), getCentre().getY(), getRayon(), getCouleur());
    }

    public static Rond getInstance(String line) {
        String[] parts = line.split(" ");
        int x = Integer.parseInt(parts[1].split("=")[1]);
        int y = Integer.parseInt(parts[2].split("=")[1]);
        int rayon = Integer.parseInt(parts[3].split("=")[1]);
        Couleur couleur = Couleur.valueOf(parts[4].split("=")[1]);
        return new Rond(new Point(x, y), rayon, couleur);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if(!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass()) ) return false;
        Rond fig = (Rond) obj;
        return this.getRayon() == fig.getRayon();
    }


    @Override
    public double surface() {
        return (rayon * rayon) * Math.PI;
    }

    @Override
    public boolean couvre(Point p) {
        int difX = Math.abs(p.getX() - origin.getX());
        int difY = Math.abs(p.getY() - origin.getY());
        return (Math.abs(Math.sqrt((difX*difX) + (difY*difY))) <= rayon);
    }
}
