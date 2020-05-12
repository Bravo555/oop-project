package pwr.sim;

import pwr.sim.animal.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class World {
    public World(int width, int height, Tile[] tiles) {
        this.width = width;
        this.height = height;
        this.tiles = tiles;
        this.animals = new ArrayList<>();
    }

    public World(String filename) throws Exception {
        ArrayList<Tile> tileList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();

        int width = line.length();

        int y = 0;
        for(; line != null; y++) {
            if(line.length() != width) {
                throw new Exception("Wrong length in line " + (y + 1) + ". Map not rectangular");
            }

            for(int x = 0; x < width; x++) {
                char tile = line.charAt(x);
                if(tile == 'W') {
                    tileList.add(new WaterTile());
                } else if (tile == 'D') {
                    tileList.add(new DesertTile());
                } else if (tile == 'F') {
                    tileList.add(new ForestTile());
                }
            }
            line = reader.readLine();
        }

        int height = y;
        System.out.println(height);
        Tile[] tiles = new Tile[width * height];

        this.width = width;
        this.height = height;
        this.tiles = tileList.toArray(tiles);
        this.animals = new ArrayList<>();
    }

    public void update() {
        for(Animal animal: this.animals) {
            animal.update();
        }
    }

    // TODO: to properly configure how many animals of each species should be generated, we should use factory pattern
    public void populate(int numAnimals) {
        for(int i = 0; i < numAnimals; i++) {
            this.animals.add(new Wolf());
        }
    }

    public void draw() {
        for(int y = 0; y < this.height; y++) {
            for(int x = 0; x < this.width; x++) {
                this.tiles[y * width + x].draw();
            }
            System.out.println();
        }
    }

    private Tile[] tiles;
    private List<Animal> animals;
    private int width;
    private int height;
}
