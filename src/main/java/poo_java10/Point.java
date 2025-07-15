package poo_java10;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Rond r = new Rond(new Point(3, 4), 5);
        r.display();

        Rectangle rect = new Rectangle(new Point(1, 2), 6, 3);
        rect.display();
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
