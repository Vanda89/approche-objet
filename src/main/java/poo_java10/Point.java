package poo_java10;

public class Point {
    private final static int INIT_X =
            25;
    private final static int INIT_Y =
            25;
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(INIT_X, INIT_Y);
    }


    public static void main(String[] args) {
        Rond r1 =
                new Rond(new Point(3, 4), 5);
        // r1.display();

        Rectangle rect1 =
                new Rectangle(new Point(1, 2), 6, 3);
        // rect1.display();

        Rond r2 =
                FigureUtil.getRandomRond();
        r2.display();

        Rectangle rect2 =
                FigureUtil.getRandomRectangle();
        rect2.display();


    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }

    public int getX() {
        return this.x;
    }



    public int getY() {
        return this.y;
    }


}
