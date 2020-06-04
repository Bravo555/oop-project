package pwr.sim.animal.ai.state;

import pwr.sim.Position2D;
import pwr.sim.World;
import pwr.sim.animal.Animal;
import pwr.sim.animal.Antelope;
import pwr.sim.animal.Hippo;

import java.util.List;

public class AiStateHunt implements IAiState {
    public AiStateHunt(Animal animal) {
        this.position = animal.getPosition();
        this.world = animal.getWorld();
        this.animal = animal;
        this.animals = world.getAnimals();
    }

    @Override
    public IAiState update() {
        if (animal.getHunger() == 100) {
            return new AiStatePop();
        }
        for (Animal prey: animals) {
            if ((prey instanceof Antelope || prey instanceof Hippo) && prey.getHealth() > 0) {
                preyPosition = prey.getPosition();
                distanceX = preyPosition.getX() - position.getX();
                distanceY = preyPosition.getY() - position.getY();
                if (Math.abs(distanceX) + Math.abs(distanceY) < minimum) {
                    minimum = Math.abs(distanceX) + Math.abs(distanceY);
                    minX = distanceX;
                    minY = distanceY;
                    this.prey = prey;
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
            prey.changeHealth(-100);
            prey = null;
            return new AiStateEatCorpse(animal);
        }
        return null;
    }

    private List<Animal> animals;
    private Animal animal;
    private World world;
    private Position2D position;
    private Position2D preyPosition;
    private int distanceX = 0;
    private int distanceY = 0;
    private int minimum = 100000;
    private int minX = 0;
    private int minY = 0;
    private Animal prey = null;
}
