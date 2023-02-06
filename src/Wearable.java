class Wearable extends Item {
	
	Wearable(String name, String desc){
		super(name, desc);
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		System.out.println("Du är nu klädd i " + this.getName());
	}
	
}
