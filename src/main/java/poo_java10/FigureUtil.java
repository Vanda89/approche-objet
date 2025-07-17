package poo_java10;

import java.util.Random;

public class FigureUtil {
    private static Point getRandomPoint() {
        Random rand = new Random();
        return new Point(rand.nextInt(100) + 1, rand.nextInt(100) + 1);
    }

    public static Rond getRandomRond() {
        Random rand = new Random();
        return new Rond(getRandomPoint(), rand.nextInt(100) + 1);
    }

    public static Rectangle getRandomRectangle() {
        Random rand = new Random();
        return new Rectangle(getRandomPoint(), rand.nextInt(100) + 1, rand.nextInt(100) + 1);
    }

    public static Carre getRandomCarre() {
        Random rand = new Random();
        return new Carre(getRandomPoint(), rand.nextInt(100) + 1);
    }

    public static CarreHerite getRandomCarreHerite() {
        Random rand = new Random();
        return new CarreHerite(getRandomPoint(), rand.nextInt(100) + 1);
    }

    public static Segment getRandomSegment() {
        Random rand = new Random();
        return new Segment(getRandomPoint(),rand.nextInt(100) + 1, rand.nextBoolean());
    }


    public static Figure getRandomFigure() {
        Random rand = new Random();
        return switch (rand.nextInt(5)) {
            case 0 -> getRandomCarre();
            case 1 -> getRandomCarreHerite();
            case 2 -> getRandomRectangle();
            case 3 -> getRandomRond();
            default -> getRandomSegment();
        };
    }




    public static Figure getRandomSurfacable() {
        Random rand = new Random();
        return switch (rand.nextInt(4)) {
            case 0 -> getRandomCarre();
            case 1 -> getRandomCarreHerite();
            case 2 -> getRandomRectangle();
            default -> getRandomRond();
        };
    }

}

