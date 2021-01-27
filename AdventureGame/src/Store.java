
public class Store extends SafeLocations{

	public Store(Player player) {
		super(player, "Store");
		// TODO Auto-generated constructor stub
	}
	public boolean notDead() {
		System.out.println("Budget: "+ player.getMoney());
		System.out.println("1- Weapons");
		System.out.println("2- Armors");
		System.out.println("3- Exit");
		int selectedItem = scan.nextInt();
		int selectedItemID;
		switch (selectedItem) {
		case 1: {
			selectedItemID=weaponMenu();
			addWeapon(selectedItemID);
			break;
		}
		case 2: {
			selectedItemID=armorMenu();
			addArmor(selectedItemID);
			break;
		}
		case 3: {
			break;
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + selectedItem);
		}
		
	
		return true;
	}
	public int armorMenu() {
		System.out.println("1- Light | Defence : 1 | Cost : 15 ");
		System.out.println("2- Medium | Defence : 3 | Cost : 25 ");
		System.out.println("3- Heavy | Defence : 5 | Cost : 40 ");
		System.out.println("4- Exit");
		System.out.println("Select armor :");
		int selectedArmorID= scan.nextInt();
		while(selectedArmorID<1 || selectedArmorID>4) {
			System.out.println("Please select valid option ! : ");
			selectedArmorID= scan.nextInt();
		}
		return selectedArmorID;
	}
	public void addArmor(int armorID) {
		int defence = 0,price=0;
		String armorName=null;
		switch (armorID) {
		case 1: {
			defence=1;
			armorName="Light Armor";
			price = 15;
			break;
		}
		case 2: {
			defence=3;
			armorName="Medium Armor";
			price = 25;
			break;
		}
		case 3: {
			defence=5;
			armorName="Heavy Armor";
			price = 40;
			break;
		}
		case 4 :{
			System.out.println("Exiting...");
			break;
		}
		default:
			System.out.println("Invalid activity!");
			break;
		}
		if(price >0) {
			if(player.getMoney()>price) {
				player.getInv().setArmor(defence);
				player.getInv().setArmorName(armorName);
				player.setMoney(player.getMoney()-price);
				
				System.out.println("Purchase is completed. Your Defence is now: "+ player.getInv().getArmor());
				
			}
			else {
				System.out.println("Insufficient balance !");
			}
			
		}
		
		
		
	}

	public int weaponMenu() {
		System.out.println("1- Pistol | Damage : 2 | Cost : 25 ");
		System.out.println("2- Sword | Damage : 3 | Cost : 35 ");
		System.out.println("3- Rifle | Damage : 7 | Cost : 45 ");
		System.out.println("4- Exit");
		System.out.println("Select weapon :");
		int selectedWeaponID= scan.nextInt();
		while(selectedWeaponID<1 || selectedWeaponID>4) {
			System.out.println("Please select valid option ! : ");
			selectedWeaponID= scan.nextInt();
		}
		return selectedWeaponID;
	}
	public void addWeapon(int weaponID) {
		int damage = 0,price=0;
		String weaponName=null;
		switch (weaponID) {
		case 1: {
			damage=2;
			weaponName="Pistol";
			price = 25;
			break;
		}
		case 2: {
			damage=3;
			weaponName="Sword";
			price = 35;
			break;
		}
		case 3: {
			damage=7;
			weaponName="Rifle";
			price = 45;
			break;
		}
		case 4 :{
			System.out.println("Exiting...");
			break;
		}
		default:
			System.out.println("Invalid activity!");
			break;
		}
		if(price >0) {
			if(player.getMoney()>price) {
				player.getInv().setDamage(damage);
				player.getInv().setWeaponName(weaponName);
				player.setMoney(player.getMoney()-price);
				
				System.out.println("Purchase is completed. Previous Damage: "+ player.getDamage()+ " New Damage: "+ player.getTotalDamage());
				
			}
			else {
				System.out.println("Insufficient balance !");
			}
			
		}
		
		
		
	}

}
