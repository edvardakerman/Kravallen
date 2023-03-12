class Drink extends Item {
	Drink(String name, String desc) {
		super(name, desc);
	}

	public void drink(Player player) {
		System.out.println("Du dricker " + this.getName() + "!!");
		System.out.println(this.getDesc() + "!!");
		player.removeItem(this);
	}

}
