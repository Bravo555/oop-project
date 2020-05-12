package pwr.sim;

import pwr.sim.animal.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class World {
    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width * height];
        for(int y = 0; y < this.height; y++) {
            for(int x = 0; x < this.width; x++) {
                this.tiles[y * width + x] = new Tile();
            }
        }
        this.animals = new ArrayList<>();
    }

    public void loadMap() throws IOException {
        File file = new File("assets\\map50x50.txt");
//        String absolutePath = file.getAbsolutePath();
//        System.out.println(absolutePath);
//        boolean exists = file.exists();
//        System.out.println("Czy istnieje: " + exists);
        char[][] map = new char[this.height][this.width];
        try {
//            Scanner read = new Scanner(new FileInputStream(file));
            FileReader fr = new FileReader(file);
            char[] buff = new char[(int) file.length()];
            fr.read(buff);
            int temp = 0;
            for (int y = 0; y < this.height; y++) {
                for (int x = 0; x < this.width; x++) {
                    if (buff[temp]!='\n' && buff[temp]!='\r') {
                        map[y][x] = buff[temp++];
                    } else {
                        temp++;
                        x--;
                    }
//                    if(map[y][x] == 'W'){
//                        this.tiles[y * width + x] = new WaterTile();
//                    } else if (map[y][x] == 'D'){
//                        this.tiles[y * width + x] = new DesertTile();
//                    } else if (map[y][x] == 'F'){
//                        this.tiles[y * width + x] = new ForestTile();
//                    }
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
//        for (int y = 0; y < this.height; y++) {
//            for (int x = 0; x < this.width; x++) {
//                System.out.print(map[y][x]);
//            }
//            System.out.println();
//        }
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
