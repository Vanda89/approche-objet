package poo_java10;

public class Point {
    final static int INIT_X =
            25;
    final static int INIT_Y =
            25;
    private final int x;
    private final int y;
    private String type;

    public Point()   {
        this(INIT_X, INIT_Y);
    }

    public Point(int x, int y)  {
        if((x<0) || (y<0)|| x > 99 || y> 99) {
            System.out.println("exception !");
            throw new DessinHorsLimiteException("!!!");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    static public double getDistance(Point p1, Point p2) {
        int difX = Math.abs(p1.getX() - p2.getX());
        int difY = Math.abs(p1.getY() - p2.getY());
        return Math.sqrt((difX * difX) + (difY * difY));
    }

     public double distance(Point p ) {
        return getDistance(this, p);
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


