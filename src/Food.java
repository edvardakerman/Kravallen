class Food extends Item {
	Food(String name, String desc) {
		super(name, desc);
	}

	public void eat(Player player) {
		System.out.println("Nom, Nom, Nom! Gott med " + this.getName() + "!!");
		System.out.println(this.getDesc());
		player.removeItem(this);
		player.setDrunk(-0.5);
		player.howDrunk();
	}
}
