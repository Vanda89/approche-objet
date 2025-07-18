package poo_java10;


import java.util.Set;

public class Segment extends Figure {
    private final Point pointRight;

    public Segment(Point origin, int length, boolean isSurfacable) {
        super(origin);
        this.pointRight = new Point(origin.getX() + (isSurfacable ? length : 0), origin.getY() + (isSurfacable ? 0 : length));
    }

    @Override
    public String getType() {
        return "SEGMENT";
    }

    @Override
    public Set<Point> getPoints() {
        return (Set.of(getPointLeft(), getPointRight()));
    }

    public Point getPointLeft() {
        return this.origin;
    }

    public Point getPointRight() {
        return this.pointRight;
    }

    @Override
    public boolean couvre(Point p) {
        int xMin = Math.min(getPointLeft().getX(), getPointRight().getX());
        int xMax = Math.max(getPointLeft().getX(), getPointRight().getX());
        int yMin = Math.min(getPointLeft().getY(), getPointRight().getY());
        int yMax = Math.max(getPointLeft().getY(), getPointRight().getY());


        return p.getX() >= xMin
                && p.getX() >= xMax
                && p.getY() <= yMin
                && p.getY() <= yMax;
    }

    @Override
    public String toString() {
        return "[" + getType() + " [" + getPointLeft() + " to " + getPointRight() + "]]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !getClass().isAssignableFrom(obj.getClass())) return false;
        Segment seg = (Segment) obj;
        return this.origin.equals(seg.origin) && this.pointRight.equals(seg.pointRight);
    }

}
