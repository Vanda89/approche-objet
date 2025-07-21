package poo_java10;

import java.util.*;

public class FigureUtil {
    private static HashMap<String, Figure> figures;

    private static Point getRandomPoint() throws DessinHorsLimiteException {
        Random rand = new Random();
        return new Point(rand.nextInt(98), rand.nextInt(98));
    }

    public static Rond getRandomRond() throws DessinHorsLimiteException {
        Random rand = new Random();
        Point p = getRandomPoint();
        return new Rond(p, rand.nextInt(100 - Math.max(p.getX(), p.getY())));
    }

    public static Rectangle getRandomRectangle() throws DessinHorsLimiteException {
        Random rand = new Random();
        Point p = getRandomPoint();
        return new Rectangle(p, rand.nextInt(100 - p.getX()), rand.nextInt(100 - p.getY()));
    }

    public static Carre getRandomCarre() throws DessinHorsLimiteException {
        Random rand = new Random();
        Point p = getRandomPoint();
        return new Carre(p, rand.nextInt(100 - Math.max(p.getX(), p.getY())));
    }

    public static CarreHerited getRandomCarreHerite() throws DessinHorsLimiteException {
        Random rand = new Random();
        Point p = getRandomPoint();
        return new CarreHerited(p, rand.nextInt(100 - Math.max(p.getX(), p.getY())));
    }

    public static Segment getRandomSegment() throws DessinHorsLimiteException {
        Random rand = new Random();
        Point p = getRandomPoint();
        boolean h = rand.nextBoolean();
        return new Segment(p, (h ?  rand.nextInt(100 - p.getX()) : rand.nextInt(100 - p.getY())), h);
    }

    public static Figure getRandomFigure() throws DessinHorsLimiteException {
        Random rand = new Random();
        return switch (rand.nextInt(5)) {
            case 0 -> getRandomCarre();
            case 1 -> getRandomCarreHerite();
            case 2 -> getRandomRectangle();
            case 3 -> getRandomRond();
            default -> getRandomSegment();
        };
    }

    public static Surfacable getRandomSurfacable() throws DessinHorsLimiteException {
        Random rand = new Random();
        return switch (rand.nextInt(4)) {
            case 0 -> getRandomCarre();
            case 1 -> getRandomCarreHerite();
            case 2 -> getRandomRectangle();
            default -> getRandomRond();
        };
    }

    public static Collection<Point> getPoints(Collection<Figure> figures) {
        HashSet<Point> points = new HashSet<>();

        for (Figure figure : figures) {
            points.addAll(figure.getPoints());
        }

        return points;
    }

    public static Collection<Figure> genere(int nbFigures) throws DessinHorsLimiteException {
        Collection<Figure> figures = new HashSet<>(nbFigures);

        for (int i = 0; i < nbFigures; i++) {
            figures.add(getRandomFigure());
        }

        return figures;
    }

    public static Figure getFigureEn(Point p, Dessin d) {
        Iterator<Figure> figures = d.getFigures().iterator();
        while (figures.hasNext()) {
            Figure figure = figures.next();
            if (figure.couvre(p)) {
                figures.remove();
                return figure;
            }
        }
        return null;
    }

    public static void afficheFigureEn(Point p, Dessin d) {
        Figure figure = getFigureEn(p, d);
        if (figure != null) {
            System.out.println("Point " + p + " est dans " + figure);
        } else {
            System.out.println("Point " + p + " n'est dans aucune figure du dessin");
        }
    }

    public static Collection<Figure> trieProcheOrigine(Dessin d) {
//        ArrayList<Figure> list = new ArrayList<>(d.getFigures());
//        Collections.sort(list);
//        return list;
        return new TreeSet<>(d.getFigures());
    }

    public static Collection<Surfacable> trieDominant(Dessin d) {
        ArrayList<Surfacable> list = new ArrayList<>();
        for (Figure figure : d.getFigures()) {
            if (Surfacable.class.isAssignableFrom(figure.getClass())) {
                list.add((Surfacable) figure);
            }
        }
        list.sort(new Comparator<>() {
            @Override
            public int compare(Surfacable o1, Surfacable o2) {
                if (o1.surface() > o2.surface()) {
                    return -1;
                } else if (o1.surface() < o2.surface()) {
                    return 1;
                }
                return 0;
            }
        });
        return list;
    }

    public static Figure createRandomFigure(String key) throws DessinHorsLimiteException {
        Figure figure = getRandomFigure();
        if (figures == null) {
            figures = new HashMap<>();
        }
        figures.put(key, figure);
        return figure;
    }

    public static Figure get(String key) {
        if (figures == null) {
            return null;
        }
        return figures.get(key);
    }
}

