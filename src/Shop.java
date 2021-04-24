import java.util.Scanner;

public class Shop extends normalLocation {
	Scanner input=new Scanner(System.in);
	Shop(Player player) {
		super(player, "Shop Market");
		
	}
	public  boolean getLocation() {
		System.out.println("Money :"+player.getMoney());
		System.out.println("1-)Weapons \n2-)Armor \n3-)Exit");
		System.out.println("Select :");
		int selShop=input.nextInt();
		int selItemID;
		switch(selShop) {
		case 1:
			selItemID=weaponMenu();
			buyWeapon(selItemID);
			break;
			
		case 2:
			selItemID=armorMenu();
			buyArmor(selItemID);
			break;
			
		default:
			break;
			
		}
		return true;
	}

	private void buyArmor(int selItemID) {
		int avoid=0,price=0;
		String aName="Body";
		if(selItemID<4 || selItemID>0) {
			switch(selItemID) {
				case 1:
					avoid=3;
					aName="Iron Armor";
					price=15;
					break;
				case 2:
					avoid=6;
					aName="Sýlver Armor";
					price=25;
					break;
				case 3:
					avoid=10;
					aName="Gold Armor";
					price=40;
					break;
			}
		}
		else {
			System.out.println("None true input");
		}
		if(player.getMoney()>=price) {
			player.getInv().setArmor(avoid);
			player.getInv().setaName(aName);
			player.setMoney(player.getMoney()-price);
			System.out.println(aName+" satýn aldýnýz.\nBlocked damage :"+player.getInv().getArmor());
		}
		else {
			System.out.println("Your money is insufficient");
		}
		
	}
	private int armorMenu() {
		System.out.println("1-)Iron Armor ( Money:15 |Avoid:3)");
		System.out.println("2-)Silver Armor ( Money:25 |Avoid:6)");
		System.out.println("3-)Golden Armor ( Money:40 |Avoid:10)");
		System.out.println("Select a armor :");
		int select=input.nextInt();
		
		return select;
	}
	private void buyWeapon(int selItemID) {
		int damage=0,price=0;
		String wName="Pounch";
		if(selItemID<4 || selItemID>0) {
			switch(selItemID) {
				case 1:
					damage=2;
					wName="Pistol";
					price=25;
					break;
				case 2:
					damage=3;
					wName="Sword";
					price=35;
					break;
				case 3:
					damage=7;
					wName="ShotGun";
					price=45;
					break;
			}
		}
		else {
			System.out.println("None true input");
		}
		if(player.getMoney()>=price) {
			player.getInv().setDamage(damage);
			player.getInv().setwName(wName);
			player.setMoney(player.getMoney()-price);
			player.setDamage(player.getDamage()+player.getInv().getDamage());
		}
		else {
			System.out.println("Your money is insufficient");
		}
		System.out.println("You have a "+wName);
		System.out.println("You are new Damage power : "+player.getDamage());
		System.out.println("Your remaining money : "+player.getMoney());
		
	}
	private int weaponMenu() {
		System.out.println("1-)Pistol ( Money:25 |Damage:2)");
		System.out.println("2-)Sword ( Money:35 |Damage:3)");
		System.out.println("3-)Shot Gun ( Money:45 |Damage:7)");
		System.out.println("Select a weapon :");
		int select=input.nextInt();
		
		return select;
	}
}
