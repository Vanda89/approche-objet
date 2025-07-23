package poo_java10;

import java.io.*;
import java.util.*;

public class FigureUtil {
    private static HashMap<String, Figure> figures;

    private static Point getRandomPoint() throws DessinHorsLimiteException {
        Random rand = new Random();
        return new Point(rand.nextInt(98), rand.nextInt(98));
    }

    public static Couleur getRandomCouleur() {
        Random rand = new Random();
        Couleur[] couleurs = Couleur.values();
        return couleurs[rand.nextInt(couleurs.length)];
    }

    public static Rond getRandomRond() throws DessinHorsLimiteException {
        Random rand = new Random();
        Point p = getRandomPoint();
        return new Rond(p, rand.nextInt(100 - Math.max(p.getX(), p.getY())), getRandomCouleur());
    }

    public static Rectangle getRandomRectangle() throws DessinHorsLimiteException {
        Random rand = new Random();
        Point p = getRandomPoint();
        return new Rectangle(p, rand.nextInt(100 - p.getX()), rand.nextInt(100 - p.getY()), getRandomCouleur());
    }

    public static Carre getRandomCarre() throws DessinHorsLimiteException {
        Random rand = new Random();
        Point p = getRandomPoint();
        return new Carre(p, rand.nextInt(100 - Math.max(p.getX(), p.getY())), getRandomCouleur());
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
        return new Segment(p, (h ? rand.nextInt(100 - p.getX()) :
                rand.nextInt(100 - p.getY())), h, getRandomCouleur());
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
        return new TreeSet<>(d.getFigures());
    }

    public static Collection<Surfacable> trieDominant(Dessin d) {
        ArrayList<Surfacable> list = new ArrayList<>();
        for (Figure figure : d.getFigures()) {
            if (Surfacable.class.isAssignableFrom(figure.getClass())) {
                list.add((Surfacable) figure);
            }
        }
        list.sort((o1, o2) -> {
            if (o1.surface() > o2.surface()) {
                return -1;
            } else if (o1.surface() < o2.surface()) {
                return 1;
            }
            return 0;
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

    public static void save(Dessin d, String fileName) throws IOException {
        PrintWriter drawingOutput = new PrintWriter(new FileWriter(fileName));

        // On récupère, on vérifie le type d'instance et on printf les infos
        for (Figure f : d.getFigures()) {
            if (f instanceof Rond) {
                Rond r = (Rond) f;
                int x = r.getCentre().getX();
                int y = r.getCentre().getY();
                int rayon = r.getRayon();
                String couleur = String.valueOf(r.getCouleur());
                // d=decimal, s = string, n=saut de ligne
                drawingOutput.printf("Rond x=%d y=%d rayon=%d couleur=%s%n", x, y, rayon, couleur);

            } else if (f instanceof Carre) {
                Carre c = (Carre) f;
                int x = c.getPointBasGauche().getX();
                int y = c.getPointBasGauche().getY();
                int cote = c.getCote();
                String couleur = String.valueOf(c.getCouleur());
                drawingOutput.printf("Carre x=%d y=%d cote=%d couleur=%s%n",
                        x, y, cote, couleur);


            } else if (f instanceof Rectangle) {
                Rectangle rect = (Rectangle) f;
                int x = rect.getPointBasGauche().getX();
                int y = rect.getPointBasGauche().getY();
                int length = rect.getLength();
                int height = rect.getHeight();
                String couleur = String.valueOf(rect.getCouleur());
                drawingOutput.printf("Rectangle x=%d y=%d length=%d height=%d couleur=%s%n", x, y, length, height, couleur);
            }
        }
        // On vide le tampon et on ferme
        drawingOutput.flush();
        drawingOutput.close();

    }

    public static Dessin load(String fileName) throws IOException {
        BufferedReader drawingReader = new BufferedReader(new FileReader(fileName));
        Dessin d = new Dessin();
        String line;

        while ((line = drawingReader.readLine()) != null) {
            // On découpe la ligne en parties à chaque espace après avoir
            String[] parts = line.trim().split(" ");
            // On stocke le type de figure pour faire les vérifications
            // d'instance en ignorant la casse
            String type = parts[0];

            if (type.equalsIgnoreCase("rond")) {
                int x = Integer.parseInt(parts[1].split("=")[1]);
                int y = Integer.parseInt(parts[2].split("=")[1]);
                int rayon = Integer.parseInt(parts[3].split("=")[1]);
                Couleur couleur = Couleur.valueOf(parts[4].split("=")[1]);
                Rond r = new Rond(new Point(x, y), rayon, couleur);
                d.add(r);

            } else if (type.equalsIgnoreCase("carre")) {
                int x = Integer.parseInt(parts[1].split("=")[1]);
                int y = Integer.parseInt(parts[2].split("=")[1]);
                int cote = Integer.parseInt(parts[3].split("=")[1]);
                Couleur couleur = Couleur.valueOf(parts[4].split("=")[1]);
                Carre c = new Carre(new Point(x, y), cote, couleur);
                d.add(c);

            } else if (type.equalsIgnoreCase("rectangle")) {
                int x = Integer.parseInt(parts[1].split("=")[1]);
                int y = Integer.parseInt(parts[2].split("=")[1]);
                int length = Integer.parseInt(parts[3].split("=")[1]);
                int height = Integer.parseInt(parts[4].split("=")[1]);
                Couleur couleur = Couleur.valueOf(parts[5].split("=")[1]);
                Rectangle rect = new Rectangle(new Point(x, y), length, height, couleur);
                d.add(rect);
            }
        }

        drawingReader.close();
        return d;
    }


}


