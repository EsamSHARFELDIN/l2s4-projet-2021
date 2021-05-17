package game.action;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import game.Resource;
import game.action.Action;
import game.action.AgricolDoNothingAction;
import game.board.RandomBoard;
import game.exception.GameException;
import game.player.AgricolPlayer;
import game.player.Player;
import game.tile.*;
import game.unit.Unit;
import game.unit.Worker;

public class AgricolDoNothingActionTest {
    @BeforeClass
    public static void setAgricolGameContext() {
        Resource.setConversionValue(Resource.Stone, 8);
        Resource.setConversionValue(Resource.Sand, 5);
        Resource.setConversionValue(Resource.Wood, 2);
        Resource.setConversionValue(Resource.Wheat, 2);

        PlainTile.MAX_ARMY_SIZE = 1;
        PlainTile.ADDITIONAL_POWER = 0;
        PlainTile.ADDITIONAL_POINTS = 0;
        PlainTile.GOLD_WHEN_DOING_NOTHING = 1;
        PlainTile.COST_ADD = 1;
        PlainTile.COST_FACTOR = 1;

        MountainTile.MAX_ARMY_SIZE = 1;
        MountainTile.ADDITIONAL_POWER = 0;
        MountainTile.ADDITIONAL_POINTS = 0;
        MountainTile.GOLD_WHEN_DOING_NOTHING = 0;
        MountainTile.COST_ADD = 5;
        MountainTile.COST_FACTOR = 1;

        ForestTile.MAX_ARMY_SIZE = 1;
        ForestTile.ADDITIONAL_POWER = 0;
        ForestTile.ADDITIONAL_POINTS = 0;
        ForestTile.GOLD_WHEN_DOING_NOTHING = 1;
        ForestTile.COST_ADD = 1;
        ForestTile.COST_FACTOR = 1;

        DesertTile.MAX_ARMY_SIZE = 1;
        DesertTile.ADDITIONAL_POWER = 0;
        DesertTile.ADDITIONAL_POINTS = 0;
        DesertTile.GOLD_WHEN_DOING_NOTHING = 2;
        DesertTile.COST_ADD = 3;
        DesertTile.COST_FACTOR = 1;
    }

    @Test
    public void canConstructAction() {
        Action a = new AgricolDoNothingAction();
    }

    @Test
    public void canExecuteAction() throws GameException {
        /* Construire joueur */
        Player p = new AgricolPlayer("André");
        RandomBoard b = new RandomBoard(15, 10);

        /* Construire tuiles, workers, les placer sur les tuiles */
        Tile t1 = new PlainTile(0, 0);
        Tile t2 = new PlainTile(1, 1);
        Tile t3 = new PlainTile(2, 2);
        Tile t4 = new ForestTile(3, 3);
        Tile t5 = new ForestTile(4, 4);
        Tile t6 = new DesertTile(5, 5);
        Unit u1 = new Worker(t1, p);
        Unit u2 = new Worker(t2, p);
        Unit u3 = new Worker(t3, p);
        Unit u4 = new Worker(t4, p);
        Unit u5 = new Worker(t5, p);
        Unit u6 = new Worker(t6, p);

        /* Ajouter les unités */
        p.addUnit(u1);
        p.addUnit(u2);
        p.addUnit(u3);
        p.addUnit(u4);
        p.addUnit(u5);
        p.addUnit(u6);

        /* Mémoriser sa quantité d'or initiale */
        int initialGold = p.getGold();

        /* Executer execute */
        Action a = new AgricolDoNothingAction();
        a.execute(b, p);

        /* Calculer la quantité d'or supplémentaire que le joueur doit avoir gagné = 7 */

        /* assertEquals quantité initiale + surplus = nouvelle quantité */
        assertEquals(initialGold + 7, p.getGold());
    }
}
