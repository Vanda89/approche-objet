package poo_java10;

public class Rond {
    private Point centre;
    private int rayon;

    public Rond(Point centre,
                int rayon) {

        this.centre = centre;
        this.rayon = rayon;

    }
    @Override
    public String toString() {
        return "[ROND " + '[' + '['+ this.centre + ']' + ' ' + this.rayon + "]]";
    }

    public void display() {
        System.out.println(this);
    }
}
