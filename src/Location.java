import java.util.*;

// TODO: There shall be at least two subclasses to Location (you may
// use OutdoorsArea and Room from the example if you like). These
// subclasses should add new functionality.

// There are two subclasses to Location called Party and Store, they both add new functionality.
public class Location {
	private String name;
	private String description;
	private ArrayList<Item> items = new ArrayList<Item>();
	private Boolean visited = false;
	private Location[] paths = new Location[4];
	private Item requiredItem;

	public Location(String name, String desc) {
		this.description = desc;
		this.name = name;
	}

	public void setPaths(Location north, Location east, Location south, Location west) {
		paths[0] = north;
		paths[1] = east;
		paths[2] = south;
		paths[3] = west;
	}

	public String getName() {
		return this.name;
	}

	public void setLocToVisited() {
		this.visited = true;
	}

	public Boolean getVisited() {
		return this.visited;
	}

	void look() {
		System.out.println("letar..");
		for (Item item : this.items) {
			System.out.println(item.getName());
		}
	}

	public void setItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public ArrayList<Item> getItems() {
		return this.items;
	}

	public void describeYourself() {
		int index = this.description.indexOf(",");

		System.out.println("Du befinner dig just nu vid " + getName() + ", ");

		if (this.visited) {
			System.out.println(this.description.substring(0, index));
		} else {
			System.out.println(this.description);
		}
	}

	public void setRequiredItem(Item req) {
		this.requiredItem = req;
	}

	public Item getRequiredItem() {
		return this.requiredItem;
	}

	public Boolean playerHasAccess(ArrayList<Item> playerItems) {
		if (this.requiredItem != null) {
			if (playerItems.contains(this.requiredItem)) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public void takeItem(String name, Player player) {

		for (Item item : this.getItems()) {
			if (name.equals(item.getName())) {
				player.addItem(item);
				System.out.println(item.getName() + " laddes till bland dina saker.");
				removeItem(item);
				break;
			}
		}
	}

	void directionDesc(Location loc) {

		String directions[] = new String[] { "norr", "öst", "syd", "väst" };

		System.out.println("Från " + loc.getName() + " kan du gå åt följande riktningar:");
		for (int i = 0; i < loc.paths.length; i++) {
			if (loc.getPath(directions[i]) != null) {
				System.out.println("Till " + directions[i] + " finns " + loc.paths[i].getName());
			}
		}
	}

	void moveTo(String direction, Player player) {

		if (player.getPosition().getPath(direction) != null) {
			if (player.getPosition().getPath(direction).playerHasAccess(player.getItems())) {
				player.setPosition(player.getPosition().getPath(direction));
			} else {
				System.out.println("För att få komma till " + player.getPosition().getPath(direction).getName()
						+ " behöver du " + player.getPosition().getPath(direction).getRequiredItem().getName());
			}
			player.getPosition().describeYourself();
		} else {
			System.out.println("Ogiltig riktining");
		}
		directionDesc(player.getPosition());
	}

	public void doDance(Player player) {
		if (player.getPosition() instanceof Party) {
			Party p = (Party) player.getPosition();
			p.dance();
		} else {
			System.out.println("Du kan inte dansa utan music :((");
		}
	}

	public void doCommand(String command, Player player) {

		String arr[] = command.split(" ", 2);

		switch (arr[0]) {
		case "leta":
			this.look();
			break;
		case "dansa":
			this.doDance(player);
			break;
		case "ta":
			if (arr.length == 2) {
				takeItem(arr[1], player);
			}
			break;
		case "gå":
			if (arr.length == 2) {
				moveTo(arr[1], player);
			}
			break;
		default:
			break;
		}

	}

	public Location[] getPaths() {
		return this.paths;
	}

	public Location getPath(String direction) {
		this.visited = true;
		switch (direction) {
		case "norr":
			return this.paths[0];
		case "öst":
			return this.paths[1];
		case "syd":
			return this.paths[2];
		case "väst":
			return this.paths[3];
		default:
			return null;
		}
	}

}
