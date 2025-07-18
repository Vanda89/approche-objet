package poo_java10;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {



        Point p = new Point(50, 50);
        Point p1 = new Point(15, 15);
        Point p2 = new Point(28, 32);
        Point pEquals = new Point(50, 50);
        Point pNonEquals = new Point(50, 51);

            Point p3 = new Point(-3, -5);
            System.out.println(p3);




        Dessin d = new Dessin();
        d.add(new Carre((new Point(20, 40)), 10));

        Rond rond = new Rond(p, 50);
        rond.display();

        Rectangle r = new Rectangle(p, 50, 50);
        r.display();

        Carre c = new Carre(p, 50);
        c.display();
        Segment seg = new Segment(p, 25, false);
        Carre c1 = new Carre(p, 51);
        c1.display();
        CarreHerite c2 = new CarreHerite(p, 50);
        c2.display();
        CarreHerite c3 = new CarreHerite(p, 51);
        c3.display();
        Segment seg2 = new Segment( pEquals, 40, false );
        Segment seg3 = new Segment( pEquals, 80, false );
        Segment seg4 = new Segment( pEquals, 80, false );

        System.out.println(FigureUtil.getRandomSpecificFig("03"));
        System.out.println(FigureUtil.get("3"));


        System.out.println("r.equals(c) : " + r.equals(c));
        System.out.println("c.equals(r) : " + c.equals(r));
        System.out.println("r.equals(c1) : " + r.equals(c1));
        System.out.println("c1.equals(r) : " + c1.equals(r));
        System.out.println("r.equals(seg) : " + r.equals(seg));
        System.out.println("seg.equals(r) : " + seg.equals(r));
        System.out.println("seg.equals(c) : " + seg.equals(c));
        System.out.println("r.equals(c2) : " + r.equals(c2));
        System.out.println("c2.equals(r) : " + c2.equals(r));
        System.out.println("r.equals(c3) : " + r.equals(c3));
        System.out.println("c3.equals(r) : " + c3.equals(r));
        System.out.println("p.equals(pEquals) : " + p.equals(pEquals));
        System.out.println("p.equals(pNonEquals) : " + p.equals(pNonEquals));
        System.out.println("seg.equals(seg2) : " + seg.equals(seg2));
        System.out.println("seg3.equals(seg4) : " + seg3.equals(seg4));

        for (int i = 0; i < 10; i++) {
            Surfacable s = (Surfacable) FigureUtil.getRandomSurfacable();
            System.out.println("Surface = " + s.surface() + " pour " + s);
        }

        Figure[] figures = new Figure[10];
        for (int i = 0; i < 10; i++) {
            figures[i] = FigureUtil.getRandomFigure();
        }

        Collection<Figure> figuresGenerated = FigureUtil.genered(10);
        System.out.println("figuresGenerated" + figuresGenerated);
        System.out.println("FigureUtil.getFigureInto(p1, d )" + FigureUtil.getFigureInto(p1, d ));

      //  e.getMessage()
      //  AutoCloseable()
      /*
        try() {
            // code à tester
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try() {
            }
        }
        */
    }
}
