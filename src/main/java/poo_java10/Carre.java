package poo_java10;

public class Carre  {
    private int cote;
    private Point pointBG;
    private Point pointBD;
    private Point pointHG;
    private Point pointHD;
    public Carre(Point origin, int cote) {
    this.pointBG = origin;
    this.pointBD = new Point(pointBG.getX() + cote, pointBG.getY());
    this.pointHG = new Point(pointBG.getX(), pointBG.getY() + cote);
    this.pointHD = new Point(pointBG.getX() + cote, pointBG.getY() + cote );

    this.cote = cote;
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
    public String toString() { return "[CARRE ["
            + "[" + getPointBasGauche() + "] "
            + "[" + getPointBasDroite() + "] "
            + "[" + getPointHautGauche() + "] "
            + "[" + getPointHautDroite() + "]"
            + "]]";}
    public void display() {
        System.out.println(this);
    }




}
