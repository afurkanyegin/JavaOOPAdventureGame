
public class SafeHouse extends SafeLocations{

	public SafeHouse(Player player) {
		super(player, "Safe House");
		// TODO Auto-generated constructor stub
	}
	public boolean notDead() {
		player.setHealth(player.getFullHealth());
		System.out.println("You are at Safe House");
		System.out.println("Health is Fulled!");
		return true;

}
};
