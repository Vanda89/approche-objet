package poo_java10;

import java.util.Set;

public class Carre extends Figure implements Surfacable {
    private int cote;
    private Point pointBD;
    private Point pointHG;
    private Point pointHD;

    public Carre(Point origin, int cote) throws DessinHorsLimiteException  {
        super(origin);
        this.pointBD = new Point(origin.getX() + cote, origin.getY());
        this.pointHG = new Point(origin.getX(), origin.getY() + cote);
        this.pointHD = new Point(origin.getX() + cote, origin.getY() + cote);
        this.cote = cote;
    }

    public Point getPointBasGauche() {
        return super.origin;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || (!getClass().isAssignableFrom(obj.getClass()) && !Rectangle.class.isAssignableFrom(obj.getClass())))
            return false;
        if (Rectangle.class.isAssignableFrom(obj.getClass())) {
            Rectangle r = ((Rectangle) obj);
            return r.getPointBasDroite().equals(pointBD) && r.origin.equals(super.origin)
                    && r.getPointHautGauche().equals(pointHG) && r.getPointHautDroite().equals(pointHD);
        } else {
            Carre r = ((Carre) obj);
            return r.pointBD.equals(pointBD) && r.origin.equals(super.origin)
                    && r.pointHG.equals(pointHG) && r.pointHD.equals(pointHD);
        }
    }



    @Override
    public String getType() {
        return "CARRE";
    }


    @Override
    public Set<Point> getPoints() {
        return (Set.of(getPointBasGauche(), getPointBasDroite(), getPointHautDroite(), getPointHautGauche()));
    }

    @Override
    public boolean couvre(Point p) {
        return p.getX() >= getPointBasGauche().getX() && p.getX() <= getPointHautDroite().getX()
                && p.getY() >= getPointHautGauche().getY() && p.getY() <= getPointBasDroite().getY();

    }

    @Override
    public String toString() {
        return "[CARRE ["
                + "[" + getPointBasGauche() + "] "
                + "[" + getPointBasDroite() + "] "
                + "[" + getPointHautGauche() + "] "
                + "[" + getPointHautDroite() + "]"
                + "]]";
    }


    @Override
    public double surface() {
        return cote * cote;
    }


}
