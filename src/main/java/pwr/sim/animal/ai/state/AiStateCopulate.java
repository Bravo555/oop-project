package pwr.sim.animal.ai.state;

import pwr.sim.World;
import pwr.sim.animal.Animal;

public class AiStateCopulate implements IAiState {
    public AiStateCopulate(Animal animal) {
        this.world = animal.getWorld();
        this.animal = animal;
    }

    @Override
    public IAiState update() {
        IAiState other = checkHungerAndEnergy();
        if(other != null) {
            return other;
        }
        if(mate == null) {
            int minimum = 100000;
            for (Animal mate: world.getAnimals()) {
                if (mate.getClass().equals(animal.getClass())) {
                    int currentDistance = animal.getPosition().distanceSquared(mate.getPosition());
                    if (currentDistance < minimum) {
                        minimum = currentDistance;
                        this.mate = mate;
                    }
                }
            }
        }
        animal.approach(mate.getPosition());
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

    private final World world;
    private final Animal animal;
    private Animal mate;
}
