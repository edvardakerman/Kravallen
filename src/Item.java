abstract class Item {
	private String name;
	private String description;

	Item(String Name, String Description) {
		this.name = Name;
		this.description = Description;
	}

	public void doCommand(String command, Player player) {

		String arr[] = command.split(" ", 2);
		switch (arr[0]) {
		case "använd":
			if (checkItems(arr[1], player) instanceof Wearable) {
				wear(player);
			}
			;
			break;
		case "ät":
			if (checkItems(arr[1], player) instanceof Food) {
				eat(player);
			}
			break;
		case "drick":
			if (checkItems(arr[1], player) instanceof Drink) {
				drink(player);
			}
			break;
		default:
			break;
		}
	}

	public Item checkItems(String name, Player player) {
		Item temp = null;

		for (Item item : player.getItems()) {
			if (name.equals(item.getName())) {
				temp = item;
				break;
			}
		}

		return temp;

	}

	public String getName() {
		return this.name;
	}

	public String getDesc() {
		return this.description;
	}

	public void wear(Player player) {
		// something
	};

	public void eat(Player player) {
		// something
	};

	public void drink(Player player) {
		// something
	};

}
