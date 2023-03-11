class Drink extends Item{
	Drink(String name, String desc){
		super(name, desc);
	}
	
	public void drink(Player player) {
		System.out.println("Klunk Klunk Klunk! Gott med " + this.getName() + "!!");
		player.removeItem(this);
	}

}
