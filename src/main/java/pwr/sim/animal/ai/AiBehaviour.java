package pwr.sim.animal.ai;

import pwr.sim.Position2D;
import pwr.sim.animal.Animal;
import pwr.sim.animal.ai.state.AiStatePop;
import pwr.sim.animal.ai.state.AiStateRoam;
import pwr.sim.animal.ai.state.IAiState;

import java.util.Stack;

public class AiBehaviour {
    public AiBehaviour() {
        currentState = new Stack<>();
    }
    public AiBehaviour(Position2D position) {
        currentState = new Stack<>();
        currentState.push(new AiStateRoam(animal, position));
    }

    public void update() {
        IAiState newState = currentState.peek().update();
        if(newState != null) {
            if(newState instanceof AiStatePop) {
                currentState.pop();
                return;
            }
            currentState.push(newState);
        }
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    protected Stack<IAiState> currentState;
    public Position2D position;
    private Animal animal;
}
