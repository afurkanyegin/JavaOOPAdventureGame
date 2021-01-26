import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome");
		System.out.println("Enter Character Name: a");
		//String playerName = scan.nextLine();
		player = new Player("a");
		player.selectCharacter();
		
	}
};