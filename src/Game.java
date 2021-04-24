import java.util.Scanner;

public class Game {

	Player player;
	Location location;
	Scanner input=new Scanner(System.in);
	
	public void logIn() {
		System.out.println("Welcome to Adventure Game");
		
		System.out.print("Enter your name before starting the game :");
		String playerName=input.nextLine();
		
		player=new Player(playerName);
		player.selectCha();
		start();
	}
	public void start() {
		while(true) {
			System.out.println();
			System.out.println("-----------------------------------------------");
			System.out.println();
			System.out.println("Select Location");
			System.out.println("1-) Safe House --> No enemies + You will gain health");
			System.out.println("2-) Cave --> Careful ! Zombies spawn in cave place");
			System.out.println("3-) Wood --> Careful ! Bear spawn in Wood place");
			System.out.println("4-) River --> Careful ! Vampires spawn in River place");
			System.out.println("5-) Shop --> You can buy the Armor and Weapons");
			System.out.println("Select Location :");
			int selectLoc=input.nextInt();
			while(selectLoc<=0 || selectLoc>5) {
				System.out.println("Please select a valid location :");
				selectLoc=input.nextInt();
			}
			switch(selectLoc) {
			case 1:
				location=new safeHouse(player);
				break;
			case 2:
				location=new Cave(player);
				break;
			case 3:
				location=new Wood(player);
				break;
			case 4:
				location=new River(player);
				break;
			case 5:
				location=new Shop(player);
				break;
			default:
				location=new safeHouse(player);
			}
			if(!location.getLocation()) {
				System.out.println("Game Over");
				break;
			}
			
		}
		
	}
}
