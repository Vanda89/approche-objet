package poo_java10;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Rond extends Figure implements Surfacable {
    private final int rayon;

    public Rond(Point origin,
                int rayon) {
        super(origin);
        this.rayon = rayon;

    }

    @Override
    public String getType() {
        return "ROND";
    }

    @Override
    public String toString() {
        return "[ROND " + '[' + '['+ origin + ']' + ' ' + this.rayon + "]]";
    }

    public Point getCentre() {
        return origin;
    }


    @Override
    public Set<Point> getPoints() {
        return (Set.of(getCentre()));
    }

    @Override
    public boolean couvre(Point p) {
       return Point.getDistance(origin, p) <= rayon;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return  true;
        if(obj == null || !getClass().isAssignableFrom(obj.getClass())) return false;
        Rond fig = (Rond) obj;
        return getCentre().equals(fig.origin);
    }

    @Override
    public double surface() {
        return (rayon * rayon) * Math.PI;
    }
}
