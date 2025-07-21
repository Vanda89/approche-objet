package poo_java10;

public class CarreHerited extends Rectangle {
    public CarreHerited(Point origin, int cote) throws DessinHorsLimiteException  {
        super(origin, cote, cote);

    }

    public String getType() {
        return "CARRE HERITED";
    }


}
