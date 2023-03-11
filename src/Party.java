class Party extends Location {	
	
	Party(String name, String description){
		super(name, description);
	}
	
	public static void dance(Location pos) {
		if(pos instanceof Party) {
			System.out.println("CHACHACHA");
		} else {
			System.out.println("Du kan inte dansa här:(((((");
		}
	}
	
	public String getMusic() {
			String Music[] = new String[] { "Mares", "Avicii", "Lov1", "Bolaget" };
			return (Music[(int) Math.floor(Math.random()*Music.length)]);
	}
}
