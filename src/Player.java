import java.util.ArrayList;

public class Player {
	private String Name;
	private Location Position;
	private ArrayList<Item> items = new ArrayList<Item>();
	private Wearable wearing = null;
	private double drunklevel = 0.0;

	Player(String name, Location start) {
		this.Name = name;
		this.Position = start;
	}
	
	public double getDrunk() {
		return this.drunklevel;
	}
	
	public void setDrunk(double newdrunk) {
		if ((this.drunklevel + newdrunk) >= 0) {
			this.drunklevel += newdrunk;
		}
	}
	
	public void howDrunk() {
		System.out.println("Din promille ligger på: " + this.getDrunk());
	}


	public String getName() {
		return this.Name;
	}

	public Location getPosition() {
		return this.Position;
	}

	public ArrayList<Item> getItems() {
		return this.items;
	}

	public void setWearing(Wearable clothing) {
		this.wearing = clothing;
	}

	public Wearable getWearing() {
		return this.wearing;
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public void addItem(Item item) {
		this.items.add(item);
	};

	void inventory() {
		System.out.println("Dina Saker:");
		for (int i = 0; i < this.items.size(); i++) {
			System.out.println((i + 1) + ". " + this.items.get(i).getName() + ", " + this.items.get(i).getDesc());
		}
	}

	public void setPosition(Location loc) {
		this.Position = loc;
	}

	public void doCommand(String command) {

		String arr[] = command.split(" ", 2);

		switch (arr[0]) {

		case "help":
			System.out.println("Giltiga Kommandon:");
			System.out.println("1. gå      - följs av en riktning, gå öst/väst/norr/syd");
			System.out.println("2. ta      - följs av föremål, ta Ovve");
			System.out.println("3. använd  - För att ta på sig kläder, använd Ovve");
			System.out.println("4. ät	   - För att ta äta mat, ät Kebab");
			System.out.println("5. drick   - För att ta dricka, drick Kir");
			System.out.println("6. dansa   - För att dansa om möjligt");
			System.out.println("7. leta	   - För att leta efter föremål");
			System.out.println("8. saker   - För att visa dina föremål");
			break;
		case "saker":
			inventory();
			break;

		default:

			Item temp = null;
			if (!items.isEmpty() && arr.length == 2) {
				for (Item item : items) {
					if (item != null) {
						temp = item;
					}
				}
				temp.doCommand(command, this);
			}

			Position.doCommand(command, this);
			break;

		}

	}

}
