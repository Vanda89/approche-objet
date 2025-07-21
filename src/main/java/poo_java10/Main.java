package poo_java10;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
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
    }
}
