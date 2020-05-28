package pwr.sim;

import pwr.sim.animal.*;
import pwr.sim.renderer.Renderer;
import pwr.sim.tile.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        Random pos = new Random();
        for(int i = 0; i < numAnimals; i += 2) {
            this.animals.add(new Wolf(new Position2D(pos.nextInt(50), pos.nextInt(50)), this));
            //this.animals.add(new Antelope(pos.nextInt(50), pos.nextInt(50)));
        }
    }

    public void draw() {
        Renderer.setCursorPosition(1,1);
        for(int y = 0; y < this.height; y++) {
            for(int x = 0; x < this.width; x++) {
                this.tiles[y * width + x].draw();
            }
            System.out.println();
        }
        Renderer.setCursorPosition(0, height + 1);
    }

    public void drawAnimal(Animal animal) {
        Position2D position = animal.getPosition();

        Renderer.setCursorToCell(position.x, position.y);
        char c = animal.getAnimalChar();

        // handle tile background
        int tileBackground = tiles[position.y * width + position.x].getColor();

        Renderer.drawColouredChar(c, 231, tileBackground);
    }

    public Tile getTile(int x, int y) {
        return tiles[y * width + x];
    }

    private final Tile[] tiles;
    private final List<Animal> animals;
    private final int width;
    private final int height;
}
