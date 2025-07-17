package poo_java10;

public class Rectangle extends Figure implements Surfacable {
    private Point pointBD;
    private Point pointHG;
    private Point pointHD;

    public Rectangle(Point origin,
                     int length, int width) {
        super(origin);
        this.pointBD = new Point(origin.getX() + length, origin.getY());
        this.pointHG = new Point(origin.getX(), origin.getY() + width);
        this.pointHD = new Point(origin.getX() + length, origin.getY() + width);
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

    @Override
    public String toString() {
        return "[RECT ["
                + "[" + getPointBasGauche() + "] "
                + "[" + getPointBasDroite() + "] "
                + "[" + getPointHautGauche() + "] "
                + "[" + getPointHautDroite() + "]"
                + "]]";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return  true;
        if(obj == null || !getClass().isAssignableFrom(obj.getClass())) return false;
        Rectangle fig = (Rectangle) obj;
        return getPointBasDroite().equals(fig.getPointBasDroite()) && getPointBasGauche().equals(fig.getPointBasGauche()) && getPointHautDroite().equals(fig.getPointHautDroite()) && getPointHautGauche().equals(fig.getPointHautGauche());
    }
    @Override
    public double surface() {
        return ( (getPointBasDroite().getX() + getPointBasGauche().getY() ) + (getPointBasDroite().getX() + getPointHautDroite().getY()) ) * 2;
    }

}
