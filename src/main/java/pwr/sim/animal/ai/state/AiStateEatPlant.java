package pwr.sim.animal.ai.state;

import pwr.sim.animal.Animal;
import pwr.sim.tile.Tile;

public class AiStateEatPlant implements IAiState {
    public AiStateEatPlant(Animal animal) {
        this.tile = animal.getWorld().getTile(animal.getPosition().x, animal.getPosition().y);
        this.animal = animal;
    }

    @Override
    public IAiState update() {
        tile.flora -= 5;
        animal.hunger += 5;
        return null;
    }
    private Tile tile;
    private Animal animal;
}
