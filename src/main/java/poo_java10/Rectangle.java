package poo_java10;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Rectangle extends Figure implements Surfacable {
    private Point pointBD;
    private Point pointHG;
    private Point pointHD;
    private int length;
    private int height;

    public Rectangle(Point origin,
                     int length, int height ) throws DessinHorsLimiteException  {
        this(origin, length, height, Couleur.getCouleurDefault());

    }

    public Rectangle(Point origin,
                     int length, int height, Couleur couleur ) throws DessinHorsLimiteException  {
        super(origin, couleur);
        this.pointBD = new Point(origin.getX() + length, origin.getY());
        this.pointHG = new Point(origin.getX(), origin.getY() + height);
        this.pointHD = new Point(origin.getX() + length,
                origin.getY() + height);
        this.length = length;
        this.height = height;
    }

    public String getType() {
        return "RECT";
    }

    public Point getPointBasGauche() {
        return this.origin;
    }

    public Point getPointBasDroite() {
        return this.pointBD;
    }

    public Point getPointHautGauche() {
        return this.pointHG;
    }

    public Point getPointHautDroite() {
        return this.pointHD;
    }

    public int getLength() {
        return this.length;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public Set<Point> getPoints() {
        return (Set.of(getPointBasGauche(), getPointBasDroite(), getPointHautDroite(), getPointHautGauche()));
    }

    @Override
    public String getFigureString() {
        return String.format("Rectangle x=%d y=%d length=%d height=%d couleur=%s",
                origin.getX(), origin.getY(), length, height, getCouleur());
    }

    public static Rectangle getInstance(String line) {
        String[] parts = line.split(" ");
        int x = Integer.parseInt(parts[1].split("=")[1]);
        int y = Integer.parseInt(parts[2].split("=")[1]);
        int length = Integer.parseInt(parts[3].split("=")[1]);
        int height = Integer.parseInt(parts[4].split("=")[1]);
        Couleur couleur = Couleur.valueOf(parts[5].split("=")[1]);
        return new Rectangle(new Point(x, y), length, height, couleur);
    }

    @Override
    public boolean couvre(Point p) {
        return p.getX() >= getPointBasGauche().getX() && p.getX() <= getPointHautDroite().getX()
                && p.getY() >= getPointHautGauche().getY() && p.getY() <= getPointBasDroite().getY();

    }

    @Override
    public String toString() {
        return "[" + getType() + "["
                + "[" + getPointBasGauche() + "] "
                + "[" + getPointBasDroite() + "] "
                + "[" + getPointHautGauche() + "] "
                + "[" + getPointHautDroite() + "]" +
                ", couleur = " + getCouleur()
                + "]]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if(!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass()) && !Carre.class.isAssignableFrom(obj.getClass())) return false;

        if(Carre.class.isAssignableFrom(obj.getClass())) {
            Carre fig = ((Carre) obj);
            return getPointBasDroite().equals(fig.getPointBasDroite())
                    && getPointHautDroite().equals(fig.getPointHautDroite())
                    && getPointHautGauche().equals(fig.getPointHautGauche());
        } else {
            Rectangle fig = (Rectangle) obj;

            return getPointBasDroite().equals(fig.getPointBasDroite())
                    && getPointHautDroite().equals(fig.getPointHautDroite())
                    && getPointHautGauche().equals(fig.getPointHautGauche());
        }

    }


    @Override
    public double surface() {
        return ( (getPointBasDroite().getX() + getPointBasGauche().getY() ) + (getPointBasDroite().getX() + getPointHautDroite().getY()) ) * 2;
    }
}
