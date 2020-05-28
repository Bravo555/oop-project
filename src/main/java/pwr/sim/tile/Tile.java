package pwr.sim.tile;

public abstract class Tile {
    public void draw() {
        System.out.print('-');
    }

    public abstract int getColor();
    public int flora;
}
