package game.unit;

import game.tile.Tile;
import game.player.Player;

public class UnitMock extends Unit {
    public UnitMock(Tile tile, Player player) {
        super(tile, player);
    }

    public UnitMock(Tile tile) {
        this(tile, null);
    }

    public UnitMock() {
        this(null, null);
    }

    public int cost() {
        return 0;
    }
}
