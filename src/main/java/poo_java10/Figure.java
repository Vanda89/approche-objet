package poo_java10;

public abstract class Figure  {
    protected final Point origin;

    public Figure( Point origin) {
        this.origin = new Point();

    }

    public abstract String getType();

    @Override
    public abstract String toString();

    public void display() {
        System.out.println(this);
    }

    @Override
    public abstract boolean equals(Object obj);
}
