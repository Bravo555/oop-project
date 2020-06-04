package pwr.sim.animal.ai.state;

import pwr.sim.Position2D;
import pwr.sim.World;
import pwr.sim.animal.Animal;
import pwr.sim.tile.ForestTile;
import pwr.sim.tile.Tile;

public class AiStateLookForFood implements IAiState {
    public AiStateLookForFood(Animal animal) {
        this.world = animal.getWorld();
        this.animal = animal;
    }

    @Override
    public IAiState update() {
        if(animal.getHunger() >= 99) {
            return new AiStatePop();
        }
        Position2D position = animal.getPosition();
        int minimum = 100000;
        if(world.getTile(position) instanceof ForestTile && world.getTile(position).getFlora() > 0) {
            return new AiStateEatPlant(animal);
        }
        if(destination == null) {
            for (int y = position.getY() - 5; y < position.getY() + 5; y++) {
                for (int x = position.getX() - 5; x < position.getX() + 5; x++) {
                    Tile tile = world.getTile(x, y);
                    if (tile instanceof ForestTile && tile.getFlora() > 0) {
                        int currentDistance = animal.getPosition().distanceSquared(new Position2D(x, y, world));
                        if (currentDistance < minimum) {
                            minimum = currentDistance;
                            destination = new Position2D(x, y, world);
                        }
                    }
                }
            }
        }
        if(destination == null) {
            return null;
        }
        animal.approach(destination);
        if(animal.getPosition().equals(destination)) {
            destination = null;
            return new AiStateEatPlant(animal);
        }
        return null;
    }

    private final World world;
    private final Animal animal;
    private Position2D destination;
}