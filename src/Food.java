public class Food extends Item {
	public Food(String name, String desc) {
		super(name, desc);
	}

	public void use(String command, Player player) {

		switch (command) {
		case "ät":
			eat(player);
			break;
		default:
			break;
		}

	}

	public void eat(Player player) {
		System.out.println("Nom, Nom, Nom! Gott med " + this.getName() + "!!");
		System.out.println(this.getDesc());
		player.removeItem(this);
		player.setDrunk(-0.5);
		player.howDrunk();
	}
}
