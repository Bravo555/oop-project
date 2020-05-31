package pwr.sim.animal.ai.state;

import pwr.sim.animal.Animal;

public class AiStateSleep implements IAiState {
    public AiStateSleep(Animal animal) {
        this.animal = animal;
    }

    @Override
    public IAiState update() {
        animal.energy += 5;
        animal.hunger -= 3;
        return null;
    }

    private final Animal animal;
}
