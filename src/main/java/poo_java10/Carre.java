package poo_java10;

import java.util.Set;

public class Carre extends Figure implements Surfacable {
    private int cote;
    private Point pointBD;
    private Point pointHG;
    private Point pointHD;

    public Carre(Point origin, int cote) throws DessinHorsLimiteException {
        this(origin, cote, Couleur.getCouleurDefault());
    }

    public Carre(Point origin, int cote, Couleur couleur) throws DessinHorsLimiteException {
        super(origin, couleur);
        this.pointBD = new Point(origin.getX() + cote, origin.getY());
        this.pointHG = new Point(origin.getX(), origin.getY() + cote);
        this.pointHD = new Point(origin.getX() + cote, origin.getY() + cote);
        this.cote = cote;
    }

    public int getCote() {
        return cote;
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
    public String getFigureString() {
        return String.format("Carre x=%d y=%d cote=%d couleur=%s",
                origin.getX(), origin.getY(), this.cote, getCouleur());
    }

    public static Carre getInstance(String line) {
        String[] parts = line.split(" ");
        int x = Integer.parseInt(parts[1].split("=")[1]);
        int y = Integer.parseInt(parts[2].split("=")[1]);
        int cote = Integer.parseInt(parts[3].split("=")[1]);
        Couleur couleur = Couleur.valueOf(parts[4].split("=")[1]);
        return new Carre(new Point(x, y), cote, couleur);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass()) && !Rectangle.class.isAssignableFrom(obj.getClass()))
            return false;

        if (Rectangle.class.isAssignableFrom(obj.getClass())) {
            Rectangle fig = ((Rectangle) obj);
            return fig.getPointBasDroite().equals(pointBD) && fig.origin.equals(super.origin)
                    && fig.getPointHautGauche().equals(pointHG) && fig.getPointHautDroite().equals(pointHD);
        } else {
            Carre fig = ((Carre) obj);
            return fig.pointBD.equals(pointBD) && fig.origin.equals(super.origin)
                    && fig.pointHG.equals(pointHG) && fig.pointHD.equals(pointHD);
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
        return "[" + getType() + "["
                + "[" + getPointBasGauche() + "] "
                + "[" + getPointBasDroite() + "] "
                + "[" + getPointHautGauche() + "] "
                + "[" + getPointHautDroite() + "]" +
                ", couleur = " + getCouleur()
                + "]]";
    }


    @Override
    public double surface() {
        return cote * cote;
    }


}
