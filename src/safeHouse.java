
public class safeHouse extends normalLocation{

	safeHouse(Player player) {
		super(player, "Safe House");
		
	}
	public boolean getLocation() {
		player.setHealth(player.getRealHealth());
		System.out.println("Your healthy is full");
		System.out.println("You are in Safe House");
		return true;
	}
	
}
