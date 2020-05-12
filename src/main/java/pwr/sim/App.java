package pwr.sim;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        World world;
        try {
            world = new World("assets/map50x50.txt");
            world.populate(10);
            world.draw();
            world.update();
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
