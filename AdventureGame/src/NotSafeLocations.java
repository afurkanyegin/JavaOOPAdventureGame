
public abstract class NotSafeLocations extends Location{
	Enemy enemy;
	public NotSafeLocations(Player player,String name,Enemy enemy) {
		super(player);
		this.name = name;
		this.enemy = enemy;
		// TODO Auto-generated constructor stub
	}
	public boolean notDead() {
		return true;
	}
	
}
