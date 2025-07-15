package poo_java10;

public class FigureUtil {
    private static Point getRandomPoint() {
        int x =
                (int) (Math.random() * 100) + 1;
        int y =
                (int) (Math.random() * 100) + 1;

        return new Point(x, y);
    }

    public static Rond getRandomRond() {
        Point centre = getRandomPoint();
        int rayon =
                (int) (Math.random() * 50) + 1;

        return new Rond(centre, rayon);

    }

    public static Rectangle getRandomRectangle() {
        Point origin = getRandomPoint();
        int length =
                (int) (Math.random() * 100) + 1;
        int width =
            (int) (Math.random() * 100) + 1;

        return new Rectangle(origin, length
                ,width );

    }


}
