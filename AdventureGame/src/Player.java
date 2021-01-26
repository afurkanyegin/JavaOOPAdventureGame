import java.util.Scanner;

public class Player {
	private int damage,health,money;
	private String name,cName;
	Inventory inv;
	Scanner scan = new Scanner(System.in);
	
	
	public Player(String name) {
		this.name = name;
	}
	
	public void selectCharacter() {
		switch (characterMenu()) {
		case 1: {
			setcName("Samurai");
			setDamage(5);
			setHealth(21);
			setMoney(15);
			break;
		}
		case 2: {
			setcName("Archer");
			setDamage(7);
			setHealth(18);
			setMoney(20);
			break;
		}
		case 3: {
			setcName("Knight");
			setDamage(8);
			setHealth(24);
			setMoney(5);
			break;
		}
		default:
			setcName("Samurai");
			setDamage(5);
			setHealth(21);
			setMoney(15);
			break;
		}
		System.out.println("Character Name: "+ getcName() + " | Damage:" +getDamage() +" | Health:"+getHealth() +" | Money:"+ getMoney());
	}
	
	public int characterMenu() {
		// TODO Auto-generated method stub
		
		System.out.println("1- Samurai | Attack : 5 | Health : 21 | Money : 15");
		System.out.println("2- Archer | Attack : 7 | Health : 18 | Money : 20");
		System.out.println("3- Knight | Attack : 8 | Health : 24 | Money : 5");
		System.out.println("Choose a character:");
		int characterID = scan.nextInt();
		
		while(characterID<1 || characterID>3) {
			System.out.print("Please enter valid option:");
			characterID = scan.nextInt();
		}
		return characterID;
	}

	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Inventory getInv() {
		return inv;
	}
	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	
	
	
}
