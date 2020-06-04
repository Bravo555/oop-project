package pwr.sim.animal.ai.state;

import pwr.sim.animal.Animal;
import pwr.sim.tile.Tile;

public class AiStateEatPlant implements IAiState {
    public AiStateEatPlant(Animal animal) {
        this.tile = animal.getWorld().getTile(animal.getPosition());
        this.animal = animal;
    }
    @Override
    public IAiState update() {
        if(tile.getFlora() < 5 || animal.getHunger() >= 100) {
            return new AiStatePop();
        }
        tile.changeFlora(-10);
        animal.changeHunger(20);
        return null;
    }

    private final Tile tile;
    private final Animal animal;
}
