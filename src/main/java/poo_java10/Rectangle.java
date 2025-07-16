package poo_java10;

public class Rectangle {
    private Point pointBG;
    private Point pointBD;
    private Point pointHG;
    private Point pointHD;


    public Rectangle(Point origin,
                     int length, int width) {
        this.pointBG = origin;
        this.pointBD = new Point(pointBG.getX() + length, pointBG.getY());
        this.pointHG = new Point(pointBG.getX(), pointBG.getY() + width);
        this.pointHD = new Point(pointBG.getX() + length, pointBG.getY() + width);
    }
    public String getType() {
        return "RECT";
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return  true;
        if(obj == null || !getClass().isAssignableFrom(obj.getClass())) return false;
        Rectangle fig = (Rectangle) obj;
        return getPointBasDroite().equals(fig.getPointBasDroite()) && getPointBasGauche().equals(fig.getPointBasGauche()) && getPointHautDroite().equals(fig.getPointHautDroite()) && getPointHautGauche().equals(fig.getPointHautGauche());
    }

}
