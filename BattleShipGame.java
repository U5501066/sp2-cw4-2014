import java.util.Scanner;

/**
 * 
 * @author Main Class for Battle Ship
 *
 */
public class BattleShipGame {
	public static final Scanner s = new Scanner(System.in);
	public static int x;
	public static int y;
	
	public static void main(String[] args) {
		
		boolean choice = false;
		do
		{
			// Creating Ocean and place ships on it randomly
			Ocean ocean = new Ocean();
			ocean.placeAllShipsRandomly();
			ocean.print();
			
			// Until game is not over user have to play the game
			while ( !ocean.isGameOver() ){
				// Taking valid input from user
				takeInput();
				
				// Then shoot at that location
				if ( ocean.shootAt(x, y) )
					System.out.println("Hit");
				else
					System.out.println("Miss");
				
				// After shooting print the new screen
				ocean.print();
				System.out.println("Shipped sunked : " + ocean.getShipsSunk());
			}
			
			
			// When game over the print total shipped fire, ask from user to play again"
			System.out.println("Total Shipped Fired : " + ocean.getShotsFired());
			System.out.println("Do you want to play again ( yes | no): " );
			String temp = s.next();
			
			// Checking user choice and by using that choice continue loop
			if ( temp.equalsIgnoreCase("yes")){
				choice = true;
			}else{
				choice = false;
			}
		}while ( choice );
		
	}
	
	// Function to take valid input from user
	public static void takeInput(){
		
		boolean input_valid= false;
		while ( !input_valid)
		{
			
			System.out.print("Enter Location in format x,y : ");
			String input = s.next();
			
			String []temp = input.split(",");
			if (temp.length == 2){
				try{
					x = Integer.parseInt(temp[0]);
					y = Integer.parseInt(temp[1]);
					if ( x >= 0 && x < Ocean.OCEAN_SIZE && y >= 0 && y < Ocean.OCEAN_SIZE)
						input_valid = true;
					else
						input_valid = false;
				}catch(Exception e){
					input_valid = false;
				}
			}else{
				input_valid = false;
			}
			
			if ( !input_valid ){
				System.out.println("Please, Input Valid number in valid format");
			}
		}
	}
}
