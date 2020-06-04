package pwr.sim.animal.ai.state;

import pwr.sim.Position2D;
import pwr.sim.World;
import pwr.sim.animal.Animal;

import java.util.List;

public class AiStateCopulate implements IAiState {
    public AiStateCopulate(Animal animal) {
        this.position = animal.getPosition();
        this.world = animal.getWorld();
        this.animal = animal;
        this.animals = world.getAnimals();
    }

    @Override
    public IAiState update() {
        IAiState other = checkHungerAndEnergy();
        if(other != null) {
            return other;
        }
        for (Animal mate: animals) {
            if (mate.getClass().equals(animal.getClass()) && mate != animal) {
                matePosition = mate.getPosition();
                distanceX = matePosition.getX() - position.getX();
                distanceY = matePosition.getY() - position.getY();
                if (Math.abs(distanceX) + Math.abs(distanceY) < minimum) {
                    minimum = Math.abs(distanceX) + Math.abs(distanceY);
                    minX = distanceX;
                    minY = distanceY;
                }
            }
        }
        if(minX < 0) {
            position.move(-1,0);
            minX++;
        } else if(minX > 0) {
            position.move(1,0);
            minX--;
        }
        if(minY < 0) {
            position.move(0,-1);
            minY++;
        } else if(minY > 0) {
            position.move(0,1);
            minY--;
        }
        if(minX == 0 && minY == 0) {
//            world.breed(this.animal);
            return new AiStatePop();
        }
        return null;
    }

    private IAiState checkHungerAndEnergy() {
        if(animal.getHunger() < 35 && animal.getHunger() < animal.getEnergy()) {
            return new AiStateLookForFood(animal);
        }
        if(animal.getEnergy() < 35) {
            return new AiStateSleep(animal);
        }
        return null;
    }

    private List<Animal> animals;
    private Animal animal;
    private World world;
    private Position2D position;
    private Position2D matePosition;
    private int distanceX = 0;
    private int distanceY = 0;
    private int minimum = 100000;
    private int minX = 0;
    private int minY = 0;
}
