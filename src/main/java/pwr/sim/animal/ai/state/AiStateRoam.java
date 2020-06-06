package pwr.sim.animal.ai.state;

import pwr.sim.animal.Animal;

public class AiStateRoam implements IAiState {
    public AiStateRoam(Animal animal) {
        this.animal = animal;
    }

    @Override
    public IAiState update() {
        if(phase == 0) {
            animal.move(1, 0);
        } else if(phase == 1) {
            animal.move(0, 1);
        } else if(phase == 2) {
            animal.move(-1, 0);
        } else if(phase == 3) {
            animal.move(0, -1);
        }
        phase = (phase + 1)%4;
        numTicks++;
        if(animal.wantToMate) {
            return new AiStateCopulate(animal);
        } else if(animal.isHungry) {
            return new AiStateLookForFood(animal);
        } else if(animal.isTired) {
            return new AiStateSleep(animal);
        }

        if(numTicks >= 6) {
            numTicks = 0;
            return new AiStateCopulate(animal);
        }

        return null;
    }

    private int phase = 0;
    private int numTicks = 0;
    private final Animal animal;
}
