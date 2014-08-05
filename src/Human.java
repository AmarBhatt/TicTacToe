import java.util.Scanner;

/**
 * Human object
 * 
 * @author Amar Bhatt
 *
 */
public class Human extends Player {

	/**
	 * Constructor
	 * @param sym (X,O)
	 */
	public Human(String sym){
		super(sym);
	}//end Constructor

	@Override
	public int makeMove() {
		Scanner in =  new Scanner(System.in);
		String current = in.next();
		if (current.length() > 1){ //Just in case someone wants to break the code
			return 0;
		}//end if
		if(Character.isDigit(current.charAt(0))){
			Integer move = Integer.parseInt(current);
			if (move <10 && move>0){//1-9
				if (Board.moves.contains(move)){				
					return move;
				}//end if
				else{
					return 0;
				}//end else
			}//end if
		}//end if
		return 0;
	}//makeMove
}//end Human
