package game;
 
public class AgricolDoNothingActionTest {
  @Test
  public void canConstructAction() {
    Action a = new AgricolDoNothingAction();
  }

  @Test
  public void canExecuteAction() {
    /* Construire joueur */
    Player p = new AgricolPlayer("André");
    Board b = new Board(15, 10);
    /* Construire tuiles, workers, les placer sur les tuiles */ 
    Tile t1 = new PlainTile();
    Tile t2 = new PlainTile();
    Tile t3 = new PlainTile();
    Tile t4 = new ForestTile();
    Tile t5 = new ForestTile();
    Tile t6 = new DesertTile();
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
    a.execute(p, b);
    /* Calculer la quantité d'or supplémentaire que le joueur doit avoir gagné = 7 */

    /* assertEquals quantité initiale + surplus = nouvelle quantité */
    assertEquals(initialGold + 7, p.getGold());
  }
}