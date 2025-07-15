package poo_java10;

public class Rectangle {
    private Point pointBG;
    private Point pointBD;
    private Point pointHG;
    private Point pointHD;


    public Rectangle(Point origin,
                     int longueur, int largeur) {
        this.pointBG = origin;
        this.pointBD = new Point(pointBG.getX() + longueur, pointBG.getY());
        this.pointHG = new Point(pointBG.getX(), pointBG.getY() + largeur);
        this.pointHD = new Point(pointBG.getX() + longueur, pointBG.getY() + largeur);
    }

    public Point getPointBasGauche() {
        return this.pointBG;
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

    public void display() {
        System.out.println(this);
    }

}
