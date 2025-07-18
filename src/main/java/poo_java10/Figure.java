package poo_java10;

import java.util.Collection;
import java.util.HashSet;


public abstract class Figure implements Comparable<Figure>
{
    protected final Point origin;

    public Figure( Point origin)  {
        this.origin = new Point();
    }

    public abstract String getType();

    // Passé de Array a List
    public abstract Collection<Point> getPoints();

    public abstract boolean couvre(Point p);

    @Override
    public abstract String toString();

    public void display() {
        System.out.println(this);
    }

    public double distanceOrigin()  {
        Point initPoint = new Point();
        return initPoint.distance(this.origin);

    }

    @Override
    public abstract boolean equals(Object obj);

   @Override
    public int compareTo(Figure figure) {
       double d1 = 0;
       try {
           d1 = this.distanceOrigin();
       } catch (Exception e) {
           System.out.println("X est en dehors de la limite fixé [0:99]");
           throw new RuntimeException(e);
       }
       double d2 = 0;
       try {
           d2 = figure.distanceOrigin();
       } catch (Exception e) {
           System.out.println("Y est en dehors de la limite fixé [0:99]");
           throw new RuntimeException(e);
       }
       if (d1 < d2) {
           return -1;
       } else if (d1 > d2) {
           return 1;
       }
       return 0;
   }
}
