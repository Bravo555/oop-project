package pwr.sim.animal;

import pwr.sim.Position2D;
import pwr.sim.World;
import pwr.sim.animal.ai.AiBehaviour;
import pwr.sim.animal.ai.state.AiStateLookForFood;
import pwr.sim.animal.ai.state.AiStateSleep;
import pwr.sim.animal.ai.state.IAiState;
import pwr.sim.tile.Tile;
import pwr.sim.tile.WaterTile;

public abstract class Animal {
    public void update() {
        changeHunger(-10);
        changeEnergy(-5);
        if(health <= 0 || energy <= 0 || hunger <= 0) {
            //Erase animal object
            world.getTile(position).changeFlesh(20);
        }
        aiBehaviour.update();
    }

    // code object oriented but introduces unnecessary allocations
    public void approach(Position2D dest) {
        Position2D diff = position.delta(dest);
        int x = diff.getX();
        int y = diff.getY();
        int stepX = 0, stepY = 0;
        if(x < 0) {
            stepX = -1;
        } else if(x > 0) {
            stepX = 1;
        }
        if(y < 0) {
            stepY = -1;
        } else if(y > 0) {
            stepY = 1;
        }
        position.move(stepX, stepY);
    }

    // this method does the tile lookup twice:
    // first we check the tile type by using getTile(x, y) and return if given tile is a water tile
    // then we use position.move(x, y) which uses getTile a second time to check if tile we want is within bounds
    // what should happen is:
    // 1. get the desired tile, return null if outside bounds
    // 2. move to this tile if tile != null AND is not a water tile without the second lookup
    // TODO make move method not check if tile is valid twice
    public void move(int x, int y) {
        int newx = this.position.getX() + x;
        int newy = this.position.getY() + y;
        Tile tile = this.world.getTile(newx, newy);
        if(tile instanceof WaterTile) {
            return;
        }
        nextPosition.move(newx, newy);
    }

    public void setAiBehaviour(AiBehaviour aiBehaviour) {
        this.aiBehaviour = aiBehaviour;
    }

    public void draw() {
        world.drawAnimal(this);
    }

    public Position2D getPosition() {
        return this.position;
    }

    public void setPosition(Position2D position) throws Exception {
        if(this.world.getTile(position) instanceof WaterTile) {
            throw new Exception("Can't place " + this.getClass().toString() + " on water");
        }
        this.position = new Position2D(position);
        this.nextPosition = new Position2D(position);
    }

    public World getWorld() {
        return this.world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    abstract public char getAnimalChar();

    public int getEnergy() {
        return this.energy;
    }

    public void changeEnergy(int shift) {
        this.energy += shift;
    }

    public int getHunger() {
        return this.hunger;
    }

    public void changeHunger(int shift) {
        this.hunger += shift;
    }

    public int getHealth() { return this.health; }

    public void changeHealth(int shift) {
        this.health += shift;
    }

    public IAiState checkHungerAndEnergy() {
        if(hunger < 35 && hunger < energy) {
            return new AiStateLookForFood(this);
        }
        if(energy < 35) {
            return new AiStateSleep(this);
        }
        return null;
    }

    public void swap() {
        position.setPosition(nextPosition.getX(), nextPosition.getY());
    }

    public String getStringInfo() {
        return String.format("%s, HP: %d, HUN: %d, ENG: %d, POS: %s, STATE: %s",
            this.getClass().getSimpleName(),
            health,
            hunger,
            energy,
            position.toString(),
            aiBehaviour.debugInfo()
        );
    }

    private AiBehaviour aiBehaviour;
    protected World world;
    private int health = 100;
    protected Position2D position;
    protected Position2D nextPosition;
    private int energy = 80;
    private int hunger = 80;
}
