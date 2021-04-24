import java.util.Random;

public class Alliens {
	private String name;
	private int damage,award,health,maxSpawn;
	public Alliens(String name, int damage, int award, int health, int maxSpawn) {
		this.name = name;
		this.damage = damage;
		this.award = award;
		this.health = health;
		this.maxSpawn = maxSpawn;
	}
	
	
	public int alliensCount() {
		Random rand=new Random();
		
		return rand.nextInt(this.maxSpawn)+1;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getAward() {
		return award;
	}
	public void setAward(int award) {
		this.award = award;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMaxSpawn() {
		return maxSpawn;
	}
	public void setMaxSpawn(int maxSpawn) {
		this.maxSpawn = maxSpawn;
	}
	
	
	
		
}
