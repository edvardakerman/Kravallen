public class Store extends Location {
	private String open;
	private String close;

	public Store(String name, String description, String open, String close) {
		super(name, description);
		this.open = open;
		this.close = close;
	}

	@Override
	public void removeItem(Item item) {
		// Skriver över removeItem så att vi inte tar bort några föremå
	}

	@Override
	void look() {
		System.out.println(this.getName() + " säljer:");
		for (int i = 0; i < this.getItems().size(); i++) {
			System.out.println((i + 1) + ". " + this.getItems().get(i).getName());
		}
	}

	@Override
	public void describeYourself() {
		super.describeYourself();
		System.out.println("Öppetider: " + open + " - " + close);
	}
}
