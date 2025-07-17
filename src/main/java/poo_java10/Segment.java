package poo_java10;

public class Segment extends Figure {
    private Point pointRight;

    public Segment(Point origin, int length, boolean isSurfacable) {
        super(origin);
        this.pointRight =  new Point(origin.getX() + (isSurfacable ? length : 0), origin.getY() + (isSurfacable ? 0 : length));

    }

    @Override
    public String getType() {
        return "SEGMENT";
    }

    public Point getPointLeft() {
        return this.origin;
    }

    public Point getPointRight() {
        return this.pointRight;
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
        return ((this.origin == seg.origin) && (this.pointRight == seg.pointRight));
    }
}
