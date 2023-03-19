public class Drink extends Item {
	public Drink(String name, String desc) {
		super(name, desc);
	}

	public void use(String command, Player player) {

		switch (command) {
		case "drick":
			drink(player);
			break;
		default:
			break;
		}

	}

	public void drink(Player player) {
		System.out.println("Du dricker " + this.getName() + "!!");
		System.out.println(this.getDesc() + "!!");
		player.removeItem(this);
		player.setDrunk(0.5);
		player.howDrunk();
	}

}
