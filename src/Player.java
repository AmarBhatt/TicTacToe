/**
 * Defines Player methods
 * 
 * 
 * @author Amar Bhatt
 *
 */
public abstract class Player {
	
	/**
	 * X,O symbol for player
	 */
	private String symbol;
	
	/**
	 * Constructor
	 * 
	 * @param sym  X or O symbol
	 */
	public Player(String sym) {
		symbol = sym;
	}//end Constructor
	
	/**
	 * Returns player's symbol (X,O)
	 * 
	 * @return  symbol (X,O)
	 */
	public String getSymbol(){
		return symbol;
	}//end getSymbol
	
	/**
	 * Gets and validates next move
	 * 
	 * @return  integer stating next move
	 */
	public abstract int makeMove();

}//end Player
