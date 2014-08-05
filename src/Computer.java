import java.util.ArrayList;
import java.util.Collections;

/**
 * Computer Object
 * 
 * @author Amar Bhatt
 *
 */
public class Computer extends Player {
	/**
	 * Constructor
	 * @param sym (X,O)
	 */
	public Computer(String sym) {
		super(sym);
	}//end Constructor


	@Override
	public int makeMove() {
		ArrayList<Integer> moves = Board.moves;
		Collections.shuffle(moves);
		return moves.get(0);
	}//end makeMove()

}//end Computer
