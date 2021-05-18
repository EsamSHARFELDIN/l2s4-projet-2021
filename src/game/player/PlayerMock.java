package game.player;

import game.action.Action;
import game.action.DoNothingAction;
import game.board.Board;
import game.board.RandomBoard;
import game.unit.Unit;

/**
 * This class is only used for test purpose of the abstract
 * class Player.
 *
 */
public class PlayerMock extends Player {
    public PlayerMock(String name, int rock, int sand, int wheat,
                      int wood, int gold) {
        super(name, rock, sand, wheat, wood, gold);
    }

    public Action chooseAction(Board board) {
        return new DoNothingAction();
    }

    public void remunerateAll() {}

    public void remunerate(Unit unit) {}

    public boolean canRemunerate(Unit unit) {
        return true;
    }

    public void convertResource() {}

    public int score() {
        return 0;
    }
}
