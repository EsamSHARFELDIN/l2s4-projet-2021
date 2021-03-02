package game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WarPlayerTest {

	private WarPlayer player;
	
	@Before
	public void before() {
		this.player = new WarPlayer("Alice");
	}
	@Test
	public void testConstructor() {
		WarPlayer p = new WarPlayer("FooBar");
		
		assertSame(35, p.getWarriorStock());
		assertSame(10, p.getFoodStock());
		assertSame(0, p.getGold());
	}
	@Test
	public void testConvertResource() {
		int initFoodStock = player.getFoodStock();
		
		//test that convertResource() call does not throw an exception
		player.convertResource();
		
		assertTrue(initFoodStock <= player.getFoodStock());
	}
	@Test
	public void testDecrementFoodStock() {
		player.decrementFoodStock(5);
		
		assertSame(5, player.getFoodStock());
		
		//food stock can not be negative
		player.decrementFoodStock(40);
		
		assertSame(0, player.getFoodStock());
	}
	@Test
	public void testDecrementWarriorStock() {
		player.decrementWarriorStock(5);
		
		assertSame(30, player.getWarriorStock());
		
		//warrior stock can not be negative
		player.decrementWarriorStock(40);
		
		assertSame(0, player.getWarriorStock());
	}
	@Test
	public void testGetFoodStock() {
		assertSame(10, player.getFoodStock());
		
		player.decrementFoodStock(1);
		assertSame(9, player.getFoodStock());
		
		player.incrementFoodStock(10);
		assertSame(19, player.getFoodStock());
	}
	@Test
	public void testGetWarriorStock() {
		assertSame(35, player.getWarriorStock());
		
		player.incrementWarriorStock(10);
		assertSame(45, player.getWarriorStock());
		
		player.decrementWarriorStock(15);
		assertSame(30, player.getWarriorStock());
	}
	@Test
	public void testIncrementFoodStock() {
		player.incrementFoodStock(1000);
		
		assertSame(1010, player.getFoodStock());
	}
	@Test
	public void testIncrementWarriorStock() {
		player.incrementWarriorStock(100000);
		
		assertSame(100035, player.getWarriorStock());
	}

}
