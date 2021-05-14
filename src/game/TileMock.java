package game;

/**
 * This class is just a mock of the class Tile. It's only for test
 * purpose of the abstract class Tile.
 */

public class TileMock extends Tile {

    public TileMock(int x, int y) {
        super(x, y);
    }

    @Override
    public Resource getResource() {
        return null;
    }

    public int getGoldWhenDoingNothing() {
        return 0;
    }

    public int getAdditionnalPower() {
        return 0;
    }

    public int getAdditionnalPoints() {
        return 0;
    }

    public int getMaxArmySize() {
        return 0;
    }

    public int getCostAdd() {
        return 0;
    }

    public int getCostFactor() {
        return 0;
    }

    public void print() {}
}
