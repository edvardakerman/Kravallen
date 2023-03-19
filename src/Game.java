import java.util.*;

public class Game {
	private Scanner keyboard;
	private ArrayList<Location> locations;
	private Player player;

	public Game() {
		keyboard = new Scanner(System.in);
		locations = new ArrayList<>();

		// Create Rooms
		Location ryd = new Location("Ryd", "Välkommen hem till din korre, tyvärr är detta dit hem.");
		Store systemet = new Store("Systembolaget",
				"Välkommen till Systemet, Här handlar vi på oss viktiga förnödenheter inför kvällen.", "8.00", "19.00");
		Store donken = new Store("Donken", "Välkommen till Donken, Här fyllekäkar vi efter episka kvällar på Kårallen.",
				"8.00", "5.00");
		Party karallen = new Party("Kårallen", "Välkommen till Kårallen, här har vi magiska kvällar!");
		Party colonia = new Party("Colonia",
				"Välkommen till Colonia, här förarar vi som galningar inför kvällar på Kårallen!");

		karallen.setMusic("Lov1");
		karallen.setMusic("Mares");
		karallen.setMusic("Dadalife");

		colonia.setMusic("Lov1");
		colonia.setMusic("Fröken snusk");
		colonia.setMusic("Avicii");
		colonia.setMusic("DeVetDu");

		// Create Paths (North, East, South, West)
		ryd.setPaths(null, donken, null, null);
		donken.setPaths(null, systemet, colonia, ryd);
		systemet.setPaths(null, null, null, donken);
		colonia.setPaths(donken, null, karallen, null);
		karallen.setPaths(colonia, null, null, ryd);

		// Create Items
		Wearable ovve = new Wearable("Ovve", "Snyggt");
		Drink kir = new Drink("Kir", "Mmm gott med kir");
		Drink beer = new Drink("Bärs", "Bira Bira Bira, Bärs Bärs Bärs!!!");
		Food cheeseBurger = new Food("Cheeseburgare",
				"Världens bästa fyllekäk, har bottat många kommande bakfyllor!!!");
		Food kebab = new Food("Kebab", "Världens bästa fyllekäk, mumma!!!");

		// Assign Items to rooms
		ryd.setItem(ovve);
		systemet.setItem(kir);
		donken.setItem(cheeseBurger);
		colonia.setItem(beer);
		karallen.setItem(kebab);

		// Assign required Items to visit places
		colonia.setRequiredItem(kir);
		karallen.setRequiredItem(ovve);

		// add to array
		locations.add(ryd);
	}

	public void run() {
		String name;

		System.out.println("Välkommen till Linkan\nVad är ditt namn?");
		name = keyboard.nextLine();
		player = new Player(name, locations.get(0));
		System.out.println(name + ", ");
		player.getPosition().describeYourself();
		System.out.println(
				"Men det är torsdag och det betyder Kravall på Kårallen ikväll:) \nDå kan vi glömma våra omtentor och dränka vår ångest genom en magisk kväll!"
						+ "\nInnan Kårallen ska du även föra i Colonia med dina klasskompisar:))))) \nInför kvällen behöver du dricka, förslagsvis Kir"
						+ "Kl är 18.40 och du måste skynda dig till systemet innan stägning!!! \nMen innan du begär dig iväg behöver du klä dig i dit favoritplagg...\n"
						+ "Ovven!! \nDin korre är stökig och du behöver därför leta runt... Prova komandot 'leta'");
		player.getPosition().directionDesc(player.getPosition());

		while (true) {
			String command;

			System.out.println("Vad vill du göra?");
			command = keyboard.nextLine();
			player.doCommand(command);
		}
	}

}
