package poo_java10;


public class Main {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Figure 01 :" + FigureUtil.createRandomFigure("01"));
            System.out.println("Figure 02 :" + FigureUtil.createRandomFigure("02"));
            System.out.println("Figure 03 :" + FigureUtil.createRandomFigure("03"));
            System.out.println("Figure 04 :" + FigureUtil.createRandomFigure("04"));
            System.out.println("Figure 05 :" + FigureUtil.createRandomFigure("05"));
            System.out.println("Figure 06 :" + FigureUtil.createRandomFigure("06"));
            System.out.println("Figure 07 :" + FigureUtil.createRandomFigure("07"));
        } catch (DessinHorsLimiteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("--------------------------------------");

        System.out.println("Figure 03 :" + FigureUtil.get("03"));
        System.out.println("Figure 05 :" + FigureUtil.get("05"));
        System.out.println("Figure 01 :" + FigureUtil.get("01"));
        System.out.println();

        Point p = new Point();
        Carre c = new Carre(p, 4, Couleur.JAUNE);
        Rectangle rect = new Rectangle(p, 4, 4, Couleur.JAUNE);
        Rectangle rect2 = new Rectangle(p, 5, 5, Couleur.JAUNE);
        Rectangle rect3 = new Rectangle(new Point(5, 8), 4, 4, Couleur.BLEU);

        System.out.println("Est ce que les deux figures " + c + " et " + rect +
                " sont égales : " + c.equals(rect));
        System.out.println();
        System.out.println("Est ce que les deux figures " + c + " et " + rect2 +
                " sont égales : " + c.equals(rect2) + " // attendu false car pas" +
                " de" +
                " mêmes dimensions.");
        System.out.println();
        System.out.println("Est ce que les deux figures " + c + " et " + rect3 +
                " sont égales : " + c.equals(rect3) + " // attendu false car pas" +
                " de" +
                " la même couleur");

        System.out.println();

        // Test du save
        Carre c2 = new Carre(new Point(9,4), 10, Couleur.JAUNE);
        Rectangle rect4 = new Rectangle(new Point(5, 8), 6, 4, Couleur.BLEU);
        Rond r4 = new Rond(new Point(6,3), 7, Couleur.VERT);
        Dessin dSaveTest = new Dessin();

        dSaveTest.add(c2);
        dSaveTest.add(rect4);
        dSaveTest.add(r4);
        FigureUtil.save(dSaveTest, "src/main/resources/dessin.txt");
        System.out.println("Dessin sauvegardé avec " + c2 + " ; " + rect4  +
                " ; " + r4);

        System.out.println();

        // Test du load
        Dessin dLoadTest = FigureUtil.load("src/main/resources/dessin.txt");
        System.out.println("Dessin chargé");
        for (Figure f : dLoadTest.getFigures()) {
            System.out.println(f);
        }
    }
}
