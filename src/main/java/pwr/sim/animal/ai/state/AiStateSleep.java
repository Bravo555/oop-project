package pwr.sim.animal.ai.state;

import pwr.sim.animal.Animal;

public class AiStateSleep implements IAiState {
    public AiStateSleep(Animal animal) {
        this.animal = animal;
    }

    @Override
    public IAiState update() {
        if(animal.getEnergy() > 90) {
            return new AiStatePop();
        }
        animal.changeEnergy(5);
        return null;
    }

    private final Animal animal;
}
