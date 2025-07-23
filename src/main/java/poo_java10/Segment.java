package poo_java10;


import java.util.Set;

public class Segment extends Figure {
    private final Point finalPoint;

    public Segment(Point origin, Point finalPoint, Couleur couleur) throws DessinHorsLimiteException {
        super(origin, couleur);
        this.finalPoint = finalPoint;
    }

    public Segment(Point origin, int longueur, boolean horizontal,
                   Couleur couleur ) throws DessinHorsLimiteException {
        super(origin, couleur);
        finalPoint = new Point(origin.getX() + (horizontal ? longueur : 0),
                origin.getY() + (horizontal ? 0 : longueur));
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        if ((!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass())))
            return false;
        Segment fig = ((Segment) obj);
        return fig.finalPoint.equals(finalPoint);
    }

    @Override
    public String toString() {
        return "[" + getType() + "["
                + "[" + origin + "] "
                + "[" + finalPoint
                + "], couleur = "
                + getCouleur()
                + "]]";
    }

    @Override
    public String getType() {
        return "SEGMENT";
    }

    public Point getFinalPoint() {
        return finalPoint;
    }

    @Override
    public String getFigureString() {
        return String.format("Segment x1=%d y1=%d x2=%d y2=%d couleur=%s",
                origin.getX(), origin.getY(), finalPoint.getX(), finalPoint.getY(),
                getCouleur());
    }

    public static Segment getInstance(String line) {
        String[] parts = line.split(" ");
        int x1 = Integer.parseInt(parts[1].split("=")[1]);
        int y1 = Integer.parseInt(parts[2].split("=")[1]);
        int x2 = Integer.parseInt(parts[3].split("=")[1]);
        int y2 = Integer.parseInt(parts[4].split("=")[1]);
        Couleur couleur = Couleur.valueOf(parts[5].split("=")[1]);

        Point start = new Point(x1, y1);
        Point end = new Point(x2, y2);

        return new Segment(start, end, couleur);
    }


    @Override
    public Set<Point> getPoints() {
        return Set.of(origin, finalPoint);
    }

    @Override
    public boolean couvre(Point p) {
        return p.getX() >= origin.getX() && p.getX() <= finalPoint.getX()
                && p.getY() >= origin.getY() && p.getY() <= finalPoint.getY();
    }
}
