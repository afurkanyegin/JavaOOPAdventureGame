import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {

		System.out.println("Welcome");
		System.out.println("Enter Character Name: a");
		// String playerName = scan.nextLine();
		player = new Player("a");
		player.selectCharacter();
		start();

	}

	public void start() {
		while (true) {
			System.out.println("----------");
			System.out.println("----------");
			System.out.println("1 - Safe House");
			System.out.println("2 - Cave");
			System.out.println("3 - Forest");
			System.out.println("4 - River");
			System.out.println("5 - Store");
			System.out.print("Select Destination : ");
			int selectedLocation = scan.nextInt();

			while (selectedLocation < 1 || selectedLocation > 5) {
				System.out.print("Please Select Valid Destination : ");
				selectedLocation = scan.nextInt();
			}
			switch (selectedLocation) {
			case 1: {
				location = new SafeHouse(player);
				break;
			}
			case 2: {
				location = new SafeHouse(player);
				break;
			}
			case 3: {
				location = new SafeHouse(player);
				break;
			}
			case 4: {
				location = new SafeHouse(player);
				break;
			}
			case 5: {
				location = new SafeHouse(player);
				break;
			}
			default:
				location = new SafeHouse(player);
				break;
			}
		

			if (!location.notDead()) {
				System.out.println("Game Over");
				break;
			}
		}
	}
};