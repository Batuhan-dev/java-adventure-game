import java.util.Scanner;

public abstract class battleLocation extends Location{
	protected Alliens alliens;
	protected String award;
	Scanner input=new Scanner(System.in);
	battleLocation(Player player,String name,Alliens alliens,String award){
		super(player);
		this.alliens=alliens;
		this.name=name;
		this.award=award;
	}
	public boolean getLocation() {
		int alliensCount=alliens.alliensCount();
		System.out.println("\n\n You are in the "+this.getName()+" now.");
		System.out.println("\n Be carefull ! "+alliensCount+" "+alliens.getName()+" living here...");
		System.out.println("You want be battle press key <b>\n or want to escape there press <e>");
		String selectCase=input.nextLine();
		selectCase=selectCase.toLowerCase();
		if(selectCase.equals("b")) {
			if(combat(alliensCount)) {
				System.out.println("\nYou destroyed all the aliens.Congrats !!");
				if(this.award.equals("Food") && player.getInv().isFood()==false) {
					System.out.println("You have a FOOD !");
					player.getInv().setFood(true);
				}
				else if(this.award.equals("Water") && player.getInv().isWater()==false) {
					System.out.println("You have a WATER !");
					player.getInv().setWater(true);
				}
				else if(this.award.equals("Firewood") && player.getInv().isFirewood()==false) {
					System.out.println("You have a FIREWOOD !");
					player.getInv().setFirewood(true);
				}
				return true;
			}
			else {
				System.out.println("\nYou are destroyed by aliens.Failed...");
				return false;
			}
		}
		
		
		return true;
	}
	public boolean combat(int alliensCount) {
		for(int i=0;i<alliensCount;i++) {
			playerStats();
			alienStats();
			int defaultHeal=alliens.getHealth();
			while(player.getHealth()>0 && alliens.getHealth()>0) {
				
				System.out.println("<H>it or <L>eave :");
				String selCase=input.nextLine();
				selCase=selCase.toUpperCase();
				
				if(selCase.equals("H")){
					System.out.println("Your hit !");
					alliens.setHealth(alliens.getHealth()-player.getDamage());
					System.out.println("Player healthy :"+player.getHealth());
					System.out.println("Aliens healthy :"+alliens.getHealth());
					System.out.println();
					if(alliens.getHealth()>0) {
						System.out.println("Aliens hit you !");
						if(alliens.getDamage()-player.getInv().getArmor()>=0) {
							player.setHealth(player.getHealth()-(alliens.getDamage()-player.getInv().getArmor()));
						}
						else {
							player.setHealth(player.getHealth()-0);
						}
						System.out.println("Player healthy :"+player.getHealth());
						System.out.println("Aliens healthy :"+alliens.getHealth());
						System.out.println();
					}
			
				}
				else {
					break;
				}
				
			}
			if(alliens.getHealth()<=0 && player.getHealth()>0) {
				System.out.println("VICTORY !");
				player.setMoney(player.getMoney()+alliens.getAward());
				System.out.println("You have "+player.getMoney()+" money");
				alliens.setHealth(defaultHeal);
			}
			else {
				return false;
			}
		}
		return true;
	}
	private void alienStats() {
		System.out.println();
		System.out.println(alliens.getName()+" Stats\n--------------------------------");
		System.out.println("Health :"+alliens.getHealth());
		System.out.println("Damage :"+alliens.getDamage());
		System.out.println("Award :"+alliens.getAward());
		
		
	}
	private void playerStats() {
		System.out.println("\n\n");
		System.out.println("Player Stats\n--------------------------------");
		System.out.println("Health :"+player.getHealth());
		System.out.println("Damage :"+player.getDamage());
		System.out.println("Money :"+player.getMoney());
		if(player.getInv().getDamage()>0) {
			System.out.println("Weapons :"+player.getInv().getwName());
		}
		if(player.getInv().getArmor()>0) {
			System.out.println("Armor :"+player.getInv().getaName());
		}
		
		
		
	}
}
