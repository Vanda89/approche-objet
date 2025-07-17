package poo_java10;

public class Point {
    private final static int INIT_X =
            25;
    private final static int INIT_Y =
            25;
    private final int x;
    private final int y;
    private String type;

    public Point() {
        this(INIT_X, INIT_Y);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public  int getX() {
        return x;
    }

    public  int getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !getClass().isAssignableFrom(obj.getClass())) return false;
        Point p = (Point) obj;
        return ((p.x == getX()) && (p.y == getY()));
    }


}
