package pwr.sim.animal.ai;

import pwr.sim.animal.Animal;
import pwr.sim.animal.ai.state.AiStatePop;
import pwr.sim.animal.ai.state.AiStateRoam;
import pwr.sim.animal.ai.state.IAiState;

import java.util.Stack;

public class AiBehaviour {
    public AiBehaviour() {
        currentState = new Stack<>();
    }
    public AiBehaviour(Animal animal) {
        this.animal = animal;
        currentState = new Stack<>();
        currentState.push(new AiStateRoam(this.animal));
    }

    public void update() {
        IAiState newState = currentState.peek().update();
        if(newState != null) {
            // TODO this is bad. we should fix this
            if(newState instanceof AiStatePop) {
                currentState.pop();
                return;
            }
            pushState(newState);
        }
    }

    protected void pushState(IAiState other) {
        if(currentState.peek().getClass().equals(other.getClass())){
            return;
        }
        currentState.push(other);
    }

    public String debugInfo() {
        return currentState.peek().debugInfo();
    }

    protected final Stack<IAiState> currentState;
    public Animal animal;
}
