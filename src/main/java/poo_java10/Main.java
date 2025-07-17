package poo_java10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Point p = new Point(50, 50);

        Rond rond = new Rond(p, 50);
        rond.display();

        Rectangle r = new Rectangle(p, 50, 50);
        r.display();
        Carre c = new Carre(p, 50);
        c.display();
        System.out.println("r.equals(c) : " + r.equals(c));
        System.out.println("c.equals(r) : " + c.equals(r));
        Carre c1 = new Carre(p, 51);
        c1.display();
        System.out.println("r.equals(c1) : " + r.equals(c1));
        System.out.println("c1.equals(r) : " + c1.equals(r));

        r.display();
        CarreHerite c2 = new CarreHerite(p, 50);
        c2.display();
        System.out.println("r.equals(c2) : " + r.equals(c2));
        System.out.println("c2.equals(r) : " + c2.equals(r));
        CarreHerite c3 = new CarreHerite(p, 51);
        c3.display();
        System.out.println("r.equals(c3) : " + r.equals(c3));
        System.out.println("c3.equals(r) : " + c3.equals(r));

        Point pEquals = new Point(50, 50);
        System.out.println("p.equals(pEquals) : " + p.equals(pEquals));
        Point pNonEquals = new Point(50, 51);
        System.out.println("p.equals(pNonEquals) : " + p.equals(pNonEquals));


        for (int i = 0; i < 10; i++) {
            Surfacable s = (Surfacable) FigureUtil.getRandomSurfacable();
            System.out.println("Surface = " + s.surface() + " pour " + s);
        }


        Figure[] figures = new Figure[10];
        for (int i = 0; i < 10; i++) {
            figures[i] = FigureUtil.getRandomFigure();
        }

        Collection<Figure> figuresGenerated = FigureUtil.genere(10);
        System.out.println(figuresGenerated);

        Point p1 = new Point(15, 15);
        Point p2 = new Point(28, 32);
        Dessin d = new Dessin();
        d.add(new Carre((new Point(20, 40)), 10));
        System.out.println(FigureUtil.getFigureInto(p1, d ));


    }
}
