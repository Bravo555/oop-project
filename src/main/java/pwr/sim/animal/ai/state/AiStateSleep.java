package pwr.sim.animal.ai.state;

public class AiStateSleep implements IAiState {
    @Override
    public void update() {
        animal.energy += 5;
        animal.hunger -= 3;
    }
}
