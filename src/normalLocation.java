import java.util.Scanner;

public abstract class normalLocation extends Location{
	Scanner input=new Scanner(System.in);
	normalLocation(Player player,String name){
		super(player);
		this.name=name;
	}
	public boolean getLocation() {
		return true;
	}
}
