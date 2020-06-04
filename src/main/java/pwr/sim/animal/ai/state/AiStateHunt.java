package pwr.sim.animal.ai.state;

import pwr.sim.Position2D;
import pwr.sim.World;
import pwr.sim.animal.Animal;
import pwr.sim.animal.Antelope;
import pwr.sim.animal.Hippo;

import java.util.List;

public class AiStateHunt implements IAiState {
    public AiStateHunt(Animal animal) {
        World world = animal.getWorld();
        this.animal = animal;
        this.animals = world.getAnimals();
    }

    @Override
    public IAiState update() {
        if (animal.getHunger() == 100) {
            return new AiStatePop();
        }
        if(prey == null) {
            int minimum = 100000;
            for (Animal prey: animals) {
                if ((prey instanceof Antelope || prey instanceof Hippo) && prey.getHealth() > 0) {
                    int currentDistance = animal.getPosition().distanceSquared(prey.getPosition());
                    if(currentDistance < minimum) {
                        minimum = currentDistance;
                        this.prey = prey;
                    }
                }
            }
        }
        if(prey == null) {
            return null;
        }
        animal.approach(prey.getPosition());
        if(animal.getPosition().equals(prey.getPosition())) {
            prey.changeHealth(-100);
            prey = null;
            return new AiStateEatCorpse(animal);
        }
        return null;
    }

    private final List<Animal> animals;
    private final Animal animal;
    private Animal prey = null;
}
