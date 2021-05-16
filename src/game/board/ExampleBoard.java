package game.board;

import game.tile.DesertTile;
import game.tile.ForestTile;
import game.tile.MountainTile;
import game.tile.OceanTile;
import game.tile.PlainTile;
import game.tile.Tile;

/**
 * A board representing the "Figure 1" in the project brief
 * with this convention with the colors:
 * blue represents an Ocean Tile, dark green represents a 
 * Forest Tile, light green represents Plain Tile, yellow 
 * represents Desert Tile and brown represents Mountain Tile.
 * This board can be used for test purpose.
 *
 */
public class ExampleBoard extends Board {
	
    /**
     * create a board representing the "Figure 1" in the
     * project brief.
     */
    public ExampleBoard() {
        super(7, 6);
        populate();
    }
    
    /* Initialize the tiles of the board according to "Figure 1"
     * in the project brief. 
     */
    private void populate() {
        this.tiles = new Tile[][]{
        	// 1st row
        	{new OceanTile(0, 0), new OceanTile(1, 0), new OceanTile(2, 0), new OceanTile(3, 0), new PlainTile(4, 0), new DesertTile(5, 0), new OceanTile(6, 0)},
        	// 2nd row
        	{new OceanTile(0, 1), new ForestTile(1, 1), new MountainTile(2, 1), new OceanTile(3, 1), new PlainTile(4, 1), new PlainTile(5, 1), new OceanTile(6, 1)},
        	// 3rd row
        	{new OceanTile(0, 2), new OceanTile(1, 2), new OceanTile(2, 2), new OceanTile(3, 2), new OceanTile(4, 2), new OceanTile(5, 2), new OceanTile(6, 2)},
        	// 4th row
        	{new OceanTile(0, 3), new PlainTile(1, 3), new MountainTile(2, 3), new PlainTile(3, 3), new DesertTile(4, 3), new OceanTile(5, 3), new OceanTile(6, 3)},
        	// 5th row
        	{new OceanTile(0, 4), new ForestTile(1, 4), new PlainTile(2, 4), new PlainTile(3, 4), new DesertTile(4, 4), new OceanTile(5, 4), new OceanTile(6, 4)},
        	// 6th row
        	{new OceanTile(0, 5), new OceanTile(1, 5), new OceanTile(2, 5), new OceanTile(3, 5), new OceanTile(4, 5), new OceanTile(5, 5), new OceanTile(6, 5)},
        };
    }
}
