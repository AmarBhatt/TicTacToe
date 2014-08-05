import java.util.ArrayList;

/**
 * Creates and Modifies Game Board w/ validation
 * 
 * @author Amar Bhatt
 *
 */
public class Board {
	
	/**
	 * The game board
	 */
	public static ArrayList<ArrayList<String>> board;  //2D Array
	/**
	 * The dimension of the board 3x3
	 */
	public static final int SIZE = 3;
	/**
	 * List of possible moves
	 */
	public static ArrayList<Integer> moves;
	
	/**
	 * Constructor - makes 3x3 board
	 * 
	 * Sets moves list
	 */
	public Board(){
		board = new ArrayList<ArrayList<String>>();  
		moves = new ArrayList<Integer>();
		int m = 1;
		for (int i=0; i<SIZE;i++){
			board.add(new ArrayList<String>());
		}//end for
		for (int row = 0; row<SIZE; row++){
			for (int col=0; col<SIZE; col++){
				board.get(row).add("-");
				moves.add(m);
				m++;
			}//end for
		}//end for
		printBoard();
	}//end Constructor

	/**
	 * Checks if there is a row, column, or diagonal winner combination
	 * in relation to the last move played
	 * 
	 * 
	 * @param row  Row of last move on board
	 * @param col  Column of last move on board
	 * @return boolean True = Winner, False = Keep Playing
	 */
	public boolean isWinner(int row, int col){
		// Called after every move, if true, last player wins
		
		ArrayList<String> valid = new ArrayList<String>(3);
		
		//check row
		for (int i=0; i<SIZE; i++){
			if(board.get(row).get(i).equals("-")){ //row not complete
				break;
			}//end if
			valid.add(board.get(row).get(i));
			if (valid.size() != 1){
				if (!(valid.get(i-1).equals(valid.get(i)))){//not valid
					break;
				}//end if
			}//end if
			if (i == 2){ //Winner!
				return true;
			}//end if
		}//end for
		valid.clear();
		//check columns
		for (int i=0; i<SIZE; i++){
			if(board.get(i).get(col).equals("-")){ //column not complete
				break;
			}//end if
			valid.add(board.get(i).get(col));
			if (valid.size() != 1){
				if (!(valid.get(i-1).equals(valid.get(i)))){//not valid
					break;
				}//end if
			}//end if
			if (i == 2){//Winner
				return true;
			}//end if
		}//end for
		
		valid.clear();
		//check diagonal  left to right (00,11,22)==>row col
		if ((row == col)){
			for (int i=0; i<SIZE; i++){
				if(board.get(i).get(i).equals("-")){//diagonal not complete
					break;
				}//end if
				valid.add(board.get(i).get(i));
				if (valid.size() != 1){
					if (!(valid.get(i-1).equals(valid.get(i)))){//not valid
						break;
					}//end if
				}//end if
				if (i == 2){//Winner!
					return true;
				}//end if
			}//end for
		}//end if
		
		valid.clear();
		//check diagonal right to left (02,11,20)==> row col
		if((Math.abs(row - col) == SIZE - 1)){
			int j = SIZE - 1; //Go backwards
			for (int i=0; i<SIZE; i++){
				if(board.get(i).get(j).equals("-")){//diagonal not complete
					break;
				}//end if
				valid.add(board.get(i).get(j));
				if (valid.size() != 1){
					if (!(valid.get(i-1).equals(valid.get(i)))){//not valid
						break;
					}//end if
				}//end if
				if (i == 2){//Winner!
					return true;
				}//end if
				j -= 1;
			}//end for
		}//end if			
		return false;  //no Winner yet
	}//end isWinner
	/**
	 * Checks if there are no more moves to be made
	 * @return boolean True = No More Moves
	 */
	public boolean isFull() {		
		return moves.isEmpty(); //Are there anymore possible moves?
	}//end isFull
	
	/**
	 * Updates board for placed move
	 * Updates moves list
	 * 
	 * @param row  Row of move on Board
	 * @param col  Column of move on Board
	 * @param sym  Symbol being placed (X,O)
	 * @param move Position number
	 */
	public void setMove(int row, int col, String sym, Integer move){
			board.get(row).set(col, sym);
			moves.remove(move);
	}//end setMove
	
	/**
	 * 
	 * Finds row,column value for a numeric position on the board
	 * 
	 * @param position
	 * @return ArrayList of [row,column]
	 */
	public  ArrayList<Integer> findRC (int position){
		int current = 0;
		int row = 0;
		int col = 0;
		for (int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				current++;
				if (current == position){
					row = i;
					col = j;
					break;
				}//end if
			}//end for
			if (current == position){
				break;
			}//end if
		}//end for
		ArrayList<Integer> rc = new ArrayList<Integer>(2);
		rc.add(row);
		rc.add(col);
		return rc;
	}//end findRC
	
	/**
	 * Prints current board status
	 */
	public void printBoard(){
		for (int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				System.out.print(board.get(i).get(j).toString() + " ");
			}//end for
			System.out.println();
		}//end for
	}//end printBoard

	/**
	 * Gets a list of all possible moves
	 * 
	 * @return moves list
	 */
	public ArrayList<Integer> getMoves(){
		return moves;
	}//end getMoves
}//end Board
