package poo_java10;


import java.util.Set;

public class Segment extends Figure {
    private final Point finalPoint;

    public Segment(Point origin, int longueur, boolean horizontal) throws DessinHorsLimiteException {
        super(origin);
        finalPoint = new Point(origin.getX() + (horizontal ? longueur : 0),
                origin.getY() + (horizontal ? 0 : longueur));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (!getClass().isAssignableFrom(o.getClass()) && !o.getClass().isAssignableFrom(getClass())))
            return false;
        Segment s = ((Segment) o);
        return s.origin.equals(origin) && s.finalPoint.equals(finalPoint);
    }

    @Override
    public String toString() {
        return "Segment [origin=" + origin + ", finalPoint=" + finalPoint +
                "]";
    }

    @Override
    public String getType() {
        return "SEGMENT";
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
