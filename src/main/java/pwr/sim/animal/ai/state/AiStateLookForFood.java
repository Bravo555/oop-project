package pwr.sim.animal.ai.state;

import pwr.sim.Position2D;
import pwr.sim.World;
import pwr.sim.tile.ForestTile;

public class AiStateLookForFood implements IAiState {
    public AiStateLookForFood(Position2D position) {
        this.position = position;
    }

    @Override
    public IAiState update() {
        if(World.getTile(position.x, position.y) instanceof ForestTile) {
            return new AiStateEatPlant();
        } else {
            if(!hasDestination) {
                for (int y = position.y - 5; y < position.y + 5; y++) {
                    for (int x = position.x - 5; y < position.y + 5; x++) {
                        if (World.getTile(x, y) instanceof ForestTile) {
                            distanceX = x - position.x;
                            distanceY = y - position.y;
                            if (Math.abs(distanceX) + Math.abs(distanceY) < minimum) {
                                minimum = Math.abs(distanceX) + Math.abs(distanceY);
                                minX = distanceX;
                                minY = distanceY;
                                hasDestination = true;
                            }
                        }
                    }
                }
            } else {
                if(minX < 0) {
                    position.x--;
                    minX++;
                } else if(minX > 0) {
                    position.x++;
                    minX--;
                }
                if(minY < 0) {
                    position.y--;
                    minY++;
                } else if(minY > 0) {
                    position.y++;
                    minY--;
                }
                if(minX == 0 && minY == 0) hasDestination = false;
            }
        }
    }
    private Position2D position;
    private int distanceX = 0;
    private int distanceY = 0;
    private int minimum = 100000;
    private int minX = 0;
    private int minY = 0;
    private boolean hasDestination = false;
}
