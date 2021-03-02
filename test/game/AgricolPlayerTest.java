package game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AgricolPlayerTest {
	
	private AgricolPlayer player;

	@Before
	public void setUp() {
		player = new AgricolPlayer("BarFoo");
	}

	@Test
	public void testConstructor() {
		AgricolPlayer p = new AgricolPlayer("BooFar");
		
		Resource[] resources = Resource.values();
		for (int i=0; i < resources.length; i++)
			assertSame(0, p.getResource(resources[i]));
		
		assertSame(15, p.getGold());
	}
	@Test
	public void testConvertResource() {
		int initGoldStock = player.getGold();
		
		//test that convertResource() call does not throw an exception
		player.convertResource();
		
		assertTrue(initGoldStock <= player.getGold());
	}
}
