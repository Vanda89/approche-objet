package poo_java10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Figure  {
    protected final Point origin;

    public Figure( Point origin) {
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

    @Override
    public abstract boolean equals(Object obj);
}
