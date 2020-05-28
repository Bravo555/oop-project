package pwr.sim.animal.ai.state;

import pwr.sim.World;
import pwr.sim.tile.ForestTile;
import pwr.sim.tile.Tile;

public class AiStateLookForFood implements IAiState {

    @Override
    public void update() {
        tile = World.getTile(position.x, position.y);
        if(tile instanceof ForestTile) {
            return new AiStateEatPlant();
//            tile.flora -= 5;
//            animal.hunger += 5;
        } else {
            if(!hasDestination) {
                for (int y = position.y - 5; y < position.y + 5; y++) {
                    for (int x = position.x - 5; y < position.y + 5; x++) {
                        tile = World.getTile(x, y);
                        if (tile instanceof ForestTile) {
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
    private Tile tile;
    private int distanceX = 0;
    private int distanceY = 0;
    private int minimum = 100000;
    private int minX = 0;
    private int minY = 0;
    private boolean hasDestination = false;
}
