class Drink extends Item{
	Drink(String name, String desc){
		super(name, desc);
	}
	
	@Override
	public void use(Player player) {
		player.setDrunk(0.5);
		System.out.println("Klunk Klunk Klunk! Gott med " + this.getName() + "!!");
		System.out.println("Din promille ligger nu på " + player.getDrunk());
	}

}
