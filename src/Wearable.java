public class Wearable extends Item {

	Wearable(String name, String desc) {
		super(name, desc);
	}
	
	public void use(String command, Player player)
	{	
		
		switch (command) {
		case "använd":
			wear(player);
			break;
		default:
			break;
		}
		
	}

	public void wear(Player player) {
		System.out.println("Du är nu klädd i " + this.getName() + ", " + this.getDesc());
		player.setWearing(this);
		if (player.getWearing() != null) {
			player.setDrunk(0.5);
		}
		player.howDrunk();
	}

}
