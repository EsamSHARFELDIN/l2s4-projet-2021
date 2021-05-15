package game;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import game.Board;
import game.exception.IllegalGameActionException;
import game.exception.UnknownTileException;
import game.player.Player;
import game.tile.OceanTile;
import game.tile.Tile;
import game.unit.Unit;
import game.unit.Worker;

public class BoardTest {

    @Test (expected = IllegalArgumentException.class)
    public void cannotBuildBoardIfHeightInferior1() {
      Board b = new Board(3, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotBuildBoardIfWidthInferior2() {
      Board b = new Board(1, 12);
    }


    
    @Test
    public void canBuildBoardWithGoodArguments() {
      Board b = new Board(2, 1);
    }

    /* Cond 1 */
    /* - 2/3 de tuiles océan */
    @Test
    public void boardFollowsTheOceanRules() {
      Board b = new Board(10, 15);
      int cpt = 0;
      /* Cond 1 */
      /* 2 boucles imbriquées en comptant les tuiles océan (en utilisant instanceof),
        et on vérifie que le nombre de tuiles océan <= (0.667 * hauteur * largeur)
        */
      for (int i = 0; i < b.height; i++) {
        for (int j = 0; j < b.width; j++) {
          if (b.tiles[i][j] instanceof OceanTile){
            cpt += 1;
          }
        }
      }
      assertTrue(cpt <= (0.667 * b.width * b.height));
    }
    
    
    /**
     * @param tiles a list of tiles
     * @return true iff there is at least one non OceanTile 
     * among <code>tiles</code>
     */
    private boolean anyNonOceanTile(List<Tile> tiles) {
    	for(Tile t : tiles) {
    		if (!(t instanceof OceanTile)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    @Test
    public void boardFollowsTheTerrestrialRules(){
      Board b = new Board(10, 15);
      for (int x = 0; x < b.width; x++) {
        for (int y = 0; y < b.height; y++) {
        	Tile current = null;
        	try {
        		current = b.tileAt(x, y);
        	} catch (UnknownTileException e) {
        		System.out.println(e.getMessage());
        	}
        	// current is not an ocean tile
        	if (!(current instanceof OceanTile)) {
	        	List<Tile> adjTiles = null;
	        	try {
	        		adjTiles = b.adjacentTiles(x, y);
	        	} catch (UnknownTileException e) {
	        		System.out.println(e.getMessage());
	        	}
	        	// at least one neighbor of current should not be an OceanTile
	        	assertTrue(anyNonOceanTile(adjTiles));
        	}
        }
      }
    }

    @Test
    public void isFullWhenNotFull() {
      /* Créer un plateau, sans rien faire de plus et vérifier que isFull renvoie false */
      /* Vérifier aussi en ajoutant une seule unité sur une seule tuile */
      Board b = new Board(10, 15);
      Player p;
      boolean done = false;
      /* Ajouter une unité à la première tuile terrestre */
      for (int i = 0; i < b.height && !done; i++) {
        for (int j = 0; j < b.width && !done; j++) {
          if (!(b.tiles[i][j] instanceof OceanTile)) {
            b.tiles[i][j].setUnit(new Worker(b.tiles[i][j], p));
            done = true;
          }
        }
      }
      assertFalse(b.isFull());
    }

    @Test
    public void IsFullWhenFull() {
      /* On itère sur toutes les tuiles et on met une unité sur chaque cases qui n'est pas de type océan*/
      Board b = new Board(10, 15);
      Player p;
      /* Ajouter une unité à la première tuile terrestre */
      for (int i = 0; i < b.height; i++) {
        for (int j = 0; j < b.width; j++) {
          if (!(b.tiles[i][j] instanceof OceanTile)) {
            b.tiles[i][j].setUnit(new Worker(b.tiles[i][j], p));
          }
        }
      }
      assertTrue(b.isFull());
    }

    @Test (expected = UnknownTileException.class)
    public void tileAtOutOfBounds() {
      /* accéder à une tuile incorrecte (hors limte) */
      Board b = new Board(10, 15);
      b.tileAt(12, 22);
    }

    @Test
    public void tileAtOK() {
      Board b = new Board(10, 15);
      for (int i = 0; i < b.height; i++) {
        for (int j = 0; j < b.width; j++) {
          assertSame(b.tiles[i][j], b.tileAt(j, i));
        }
      }
    }

    @Test (expected = UnknownTileException.class)
    public void setUnitAtUnknownTile(){
      Board b = new Board(10, 15);
      Tile t;
      Player p;
      b.setUnitAt(12, 22, new Worker(t, p));
    }

    @Test(expected = IllegalGameActionException.class)   
    public void setUnitOnOceanTile() {
      /* trouver une tuile de type OceanTile dans le tableau, essayer de faire setUnit dessus */
      Board b = new Board(10, 15);
      Tile t;
      Player p;
      boolean done = false;
      for (int i = 0; i < b.height && !done; i++) {
        for (int j = 0; j < b.width && !done; j++) {
          if (b.tiles[i][j] instanceof OceanTile){
            b.setUnitAt(j, i, new Worker(t, p));
            done = true;
          }
        }
      }
    }

    @Test
    public void setUnitOK() {
      /* trouver case correcte, faire setUnit, vérifier avec assertSame */
      Board b = new Board(10, 15);
      Tile t;
      Player p;
      Unit u;
      boolean done = false;
      int i, j;
      for (i = 0; i < b.height && !done; i++) {
        for (j = 0; j < b.width && !done; j++) {
          if (!(b.tiles[i][j] instanceof OceanTile)) {
            u = new Worker(b.tiles[i][j], p);
            b.setUnitAt(j, i, u);
            done = true;
          }
        }
      }
      assertSame(u, b.tiles[i][j].getUnit());
    }
    
    @Test (expected = UnknownTileException.class)
    public void adjacentTilesOutOfBounds() {
      Board b = new Board(10, 15);
      b.getAdjacentTiles(12, 22);
    }

    @Test
    public void adjacentTilesMid() { /* au milieu */
      Board b = new Board(15, 10);
      List<Tile> list = b.getAdjacentTiles(7, 7);
      assertEquals(4, list.size());
      assertTrue(list.contains(b.tiles[6][6]));
      assertTrue(list.contains(b.tiles[7][6]));
      assertTrue(list.contains(b.tiles[6][7]));
      assertTrue(list.contains(b.tiles[8][8]));
    }

    @Test
    public void adjacentTilesSurLesCotes() { /* sur un bord du tableau */

    }

    @Test
    public void adjacentTilesPourLesCoins() { /* sur un coin */
      
    }
}