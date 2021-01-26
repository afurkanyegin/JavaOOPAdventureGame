
public abstract class SafeLocations extends Location {

	public SafeLocations(Player player,String name) {
		super(player);
		this.name = name;
	}
	
	public boolean notDead() {
		return true;
	}

}
