package pwr.sim.animal.ai.state;

import pwr.sim.animal.Animal;
import pwr.sim.tile.Tile;

public class AiStateEatCorpse implements IAiState {
    public AiStateEatCorpse(Animal animal) {
        this.tile = animal.getWorld().getTile(animal.getPosition());
        this.flesh = tile.getFlora();
        this.animal = animal;
        this.hunger = animal.getHunger();
    }

    @Override
    public IAiState update() {
        if(flesh < 5 || hunger >= 100) {
            return new AiStatePop();
        }
        tile.changeFlesh(-5);
        animal.changeHunger(25);
        return null;
    }
    private int flesh;
    private int hunger;
    private Tile tile;
    private Animal animal;
}
