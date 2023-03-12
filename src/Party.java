class Party extends Location {

	Party(String name, String description) {
		super(name, description);
	}

	public void dance() {
		System.out.println("CHACHACHA");
	}

	public String getMusic() {
		String Music[] = new String[] { "Mares", "Avicii", "Lov1", "Bolaget" };
		return (Music[(int) Math.floor(Math.random() * Music.length)]);
	}
}
