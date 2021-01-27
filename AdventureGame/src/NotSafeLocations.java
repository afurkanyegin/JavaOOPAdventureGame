import java.util.Iterator;

public abstract class NotSafeLocations extends Location{
	protected Enemy enemy;
	protected String award;
	public NotSafeLocations(Player player,String name,Enemy enemy,String award) {
		super(player);
		this.name = name;
		this.enemy = enemy;
		this.award=award;
		// TODO Auto-generated constructor stub
	}
	public boolean notDead() {
		int enemyCount= enemy.enemyCount()	;
		System.out.println("Your location is : "+this.getName());
		System.out.println("Be careful! There is "+ enemyCount +" "+enemy.getName()+" in this location!");
		System.out.println("<F>ight or <R>un");
		String selectedAction = scan.nextLine();
		selectedAction = selectedAction.toUpperCase();
		if(selectedAction.equals("F")) {
			if(combat(enemyCount)) {
				System.out.println(this.getName()+ " location has been cleared !");
				if (this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println(" You have won! "+ this.award);
					player.getInv().setFood(true);
				} else if (this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println(" You have won! "+ this.award);
					player.getInv().setWater(true);
				} else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println(" You have won! "+ this.award);
					player.getInv().setFirewood(true);
				}
				return true;
			}
			if(player.getHealth()<=0) {
				System.out.println("You are dead!");
				return false;
			}
		}
		return true;
	}
	public boolean combat(int enemyCount) {
		for(int i=0;i<enemyCount;i++) {
			int maxEnemyHealth=enemy.getHealth();
			playerStats();
			enemyStats();
			while(player.getHealth()>0 && enemy.getHealth()>0) {
				System.out.println("<F>ight or <R>un");
				String selectedAction = scan.nextLine();
				selectedAction=selectedAction.toUpperCase();
				if(selectedAction.equals("F")) {
					System.out.println("You have attacked");
					enemy.setHealth(enemy.getHealth()- player.getTotalDamage());
					afterHit();
					if(enemy.getHealth()>0) {
						System.out.println();
						player.setHealth(player.getHealth()-(enemy.getDamage()-player.getInv().getArmor()));
						afterHit();
					}
				}
				else {
					break;
				}
			}
			if(enemy.getHealth() <= 0 && player.getHealth() > 0) {
				System.out.println("All enemies defeated!");
				player.setMoney(player.getMoney()+ enemy.getAward());
				System.out.println("Current balance: "+ player.getMoney());
				enemy.setHealth(maxEnemyHealth);
			}
			else {
				return false;
			}
		}
		return true;
	}
	public void enemyStats() {
		// TODO Auto-generated method stub
		System.out.println("---Enemy Stats---");
		System.out.println("Enemy "+enemy.getName()+"Stats");
		System.out.println("Health: "+ enemy.getHealth());
		System.out.println("Damage: "+ enemy.getDamage());
		System.out.println("Award: "+ enemy.getAward());
	}
	public void playerStats() {
		// TODO Auto-generated method stub
		System.out.println("---Player Stats---");
		System.out.println("Health: "+ player.getHealth());
		System.out.println("Damage: "+ player.getDamage());
		if(player.getInv().getDamage()>0) {
			System.out.println("Weapon: "+ player.getInv().getWeaponName());
		}
		if(player.getInv().getArmor()>0) {
			System.out.println("Armor: "+ player.getInv().getArmorName());
		}
		
	}
	public void afterHit() {
		System.out.println("Player Health:"+ player.getHealth());
		System.out.println(enemy.getName()+ " Health "+enemy.getHealth());
	}
}
