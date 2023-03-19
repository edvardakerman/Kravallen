public abstract class Item {
	private String name;
	private String description;

	public Item(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public String getDesc() {
		return this.description;
	}

	public abstract void use(String command, Player player);

	public void doCommand(String command, Player player) {
		String arr[] = command.split(" ", 2);

		for (Item item : player.getItems()) {
			if (arr[1].equals(item.getName())) {
				item.use(arr[0], player);
				break;
			}
		}

	}

}
