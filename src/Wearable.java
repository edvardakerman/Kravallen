class Wearable extends Item {
	
	Wearable(String name, String desc){
		super(name, desc);
	}

	public void wear(Player player) {
		System.out.println("Du är nu klädd i " + this.getName());
		player.setWearing(this);
	}
	
}
