package pwr.sim;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        World world = new World(50, 50);
        world.populate(10);
        world.loadMap();
        world.draw();
        world.update();
    }
}
