package game;

/**
 * 
 * representing the different types of resources, that the characters of the game can collect on the different tiles.
 *
 */
public enum Resource {
  
	Stone , Sand, Wheat, Wood;
	
	static int STONE_CONVERSION_VALUE;
	static int SAND_CONVERSION_VALUE;
	static int WHEAT_CONVERSION_VALUE;
	static int WOOD_CONVERSION_VALUE;

  /*
  * Creates a new resources among stone, sand, wheat or wood.
  */
	public Resource() {
		
	}

  /*
  * set the conversion value of the resource r to n.
  * @param r the resource that we want to modify the conversion value.
  * @param i the new conversion value.
  */
	public void setConversionValue(Resource r, int i){

	}

  /*
  * gives the conversion value of the resource.
  * @return the conversion value of the resource.
  */
	public int getConversionValue(){
		
	}

}