import java.util.Scanner;

public class Player {

	private int damage,health,money,realHealth;
	private String name,character;
	private Inventory inv;
	Scanner scan=new Scanner(System.in);
	public Player(String name) {
		
		this.name = name;
		this.inv=new Inventory();
	}
	
	public int getRealHealth() {
		return realHealth;
	}

	public void setRealHealth(int realHealth) {
		this.realHealth = realHealth;
	}

	public void selectCha() {
		switch(chaMenu()) {
		// Select Samurai
		case 1:
			initPlayer("Samurai",5,21,15);
			break;
		// Select Knigth
		case 2:
			initPlayer("Knigth",6,24,12);
			break;
		// Select Yeniceri
		case 3:
			initPlayer("Yeniceri",8,30,5);
			break;
		// Select Orc
		case 4:
			initPlayer("Orc",3,24,25);
			break;
		default:
			setName("Samurai");
			setDamage(5);
			setHealth(21);
			setMoney(15);
			break;
		}
		System.out.println("Your Character successfully created");
		System.out.println("Character :"+getName());
		System.out.println("Damage :"+getDamage());
		System.out.println("Health :"+getHealth());
		System.out.println("Money :"+getMoney());
	}
	
	
	public int chaMenu() {
		
		System.out.println("Please Select a Character :");
		System.out.println("1-) Samurai \t Damage :5  Health :21 , Money :15");
		System.out.println("2-) Knigth \t Damage :6  Health :24 , Money :12");
		System.out.println("3-) Yeniceri \t Damage :8  Health :30 , Money :5");
		System.out.println("4-) Orc \t Damage :3  Health :24 , Money :22");
		System.out.println("Select the character :");
		int chaID=scan.nextInt();
		while(chaID<1 || chaID>4) {
			System.out.print("Please enter your character between 1-4");
			chaID=scan.nextInt();
		}
		return chaID;
	}

	public void initPlayer(String cName,int dmg,int health,int money) {
		setName(cName);
		setDamage(dmg);
		setHealth(health);
		setMoney(money);
		setRealHealth(health);
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
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public Inventory getInv() {
		return inv;
	}
	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	
	
}
