import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main activity for tic tac toe.
 * 
 * Simulates the game between user and computer
 * 
 * @author Amar Bhatt
 * 
 */
public class TicTacToe {
	
	/**
	 * Input handler for User
	 */
	private static Scanner in;
	
	/**
	 * main()
	 * 
	 * Welcomes player, asks for desired symbol (X,O),
	 * creates Board, Human, and Computer Objects.
	 * 
	 * Calls simulate()
	 * 
	 * @param args    Not Used
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe!");		
		in = new Scanner(System.in);
		System.out.println("Choose your symbol (X,O): ");
		String sym = in.next();
		while(true){
			if (sym.equals("X") || sym.equals("O")){
				break;
			}//end if
			System.out.println("Choose your symbol (X,O): ");
			sym = in.next();
		}//end while
		
		Human human = new Human(sym);
		Computer computer;
		if (sym.equals("X")){
			computer = new Computer("O");
		}//end if
		else {
			computer = new Computer("X");
		}//end else
		
		System.out.println("To play: Enter the postion number of the '-' where you \n want to place your symbol." +
				"\n The numeric positions on the board are as follows: \n" +
				" 1 2 3 \n 4 5 6 \n 7 8 9 ");
		System.out.println("\n Best of Luck!");
		
		Board board = new Board();
		
		simulate(board, human, computer);

	}//end main
	
	/**
	 * simulate()
	 * 
	 * Simulates game play between human and computer
	 * 
	 * Declares winner or tie
	 * 
	 * Calls to update game board
	 * 
	 * Exits Game
	 * 
	 * @param board  The Game Board
	 * @param human  The User Player
	 * @param computer  The Computer Player
	 */
	public static void simulate (Board board, Human human, Computer computer){
		boolean humanMove; //Turn toggle
		if (human.getSymbol().equals("X")){// X goes first
			 humanMove = true;
		}//end if
		else{
			humanMove=false;
		}//end else
		boolean winner = false;
		int move; //Position of move
		ArrayList<Integer> rc; //row-column of move
		while (!board.isFull() && !winner){
			if(humanMove){ //User's turn
				System.out.println("Your Move...");
				System.out.println("Enter tile number (1-9): ");
				move = human.makeMove();
				while((move == 0) && (!board.getMoves().contains(move))){ //Move not valid
					System.out.println("Invalid Move. Try again");
					board.printBoard();
					System.out.println("Enter tile number (1-9): ");
					move = human.makeMove();
				}//end while				
				rc = board.findRC(move);
				board.setMove(rc.get(0), rc.get(1), human.getSymbol(), move);
			}//end if
			
			else{ //Computer's turn
				System.out.println("Computer Player's Move...");
				move = computer.makeMove();
				rc = board.findRC(move);
				board.setMove(rc.get(0), rc.get(1), computer.getSymbol(), move);
				
			}//end else
			
			//Check board Status
			board.printBoard();
			if (board.isWinner(rc.get(0), rc.get(1))){
				if (humanMove){//Last move from Player
					System.out.println("You Win!");
				}//end if
				else {//Last move from Computer
					System.out.println("Computer Player Wins!");
				}//end else
				winner = true; //There was a winner
			}//end if
			humanMove = !humanMove; //Toggle player turns
		}//end while
		
		if(winner){
			System.exit(0);
		}//end if
		else{
			System.out.println("It's a tie!");
			System.exit(0);
		}//end else
	}//end simulate

}// end TicTacToe
