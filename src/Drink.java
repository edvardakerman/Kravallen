class Drink extends Item{
	Drink(String name, String desc){
		super(name, desc);
	}
	
	@Override
	public void use() {
		// TODO Auto-generated method stub
		System.out.println("Klunk Klunk Klunk! Gott med " + this.getName() + "!!");
	}

}
