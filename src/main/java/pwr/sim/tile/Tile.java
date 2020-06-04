package pwr.sim.tile;

public abstract class Tile {
    public void draw() {
        System.out.print('-');
    }

    public abstract int getColor();

    public int getFlora() {
        return this.flora;
    }

    public void changeFlora(int shift) {
        this.flora += shift;
    }

    public void changeFlesh(int shift) {
        this.flesh += shift;
    }

    private int flora = 20;
    private int flesh;
}
