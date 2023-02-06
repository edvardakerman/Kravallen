import java.util.*;

class Game {
    private Scanner keyboard; 
    private ArrayList<Location> locations;
    private Player player;

    public Game(){
	    keyboard = new Scanner(System.in);
	    locations = new ArrayList<>();
	    
	    // Create Rooms
	    Location Ryd = new Location("Ryd", "Välkommen hem till din korre i ryd, tyvärr är detta dit hem.");
	    Store Systemet = new Store("Systembolaget", "Välkommen till Systemet, Här handlar vi på oss viktiga förnödenheter inför kvällen.");
	    Store Donken = new Store("Donken", "Välkommen till Donken, Här fyllekäkar vi efter episka kvällar på Kårallen");
	    Party Karallen = new Party("Kårallen", "Välkommen till Kårallen, här har vi magiska kvällar!");
	    Party Colonia = new Party("Colonia", "Välkommen till Colonia, här förarar vi som galningar inför kvällar på Kårallen!");
	  
	    
	    // Create Paths (North, East, South, West)
	    Ryd.setPaths(null, Donken, null, null);
	    Donken.setPaths(null, Systemet, Colonia, Ryd);
	    Systemet.setPaths(null, null, null, Donken);
	    Colonia.setPaths(Donken, null, Karallen, null);
	    Karallen.setPaths(Colonia, null, null, null);

	    
	    // Create Items
	    Wearable Ovve = new Wearable("Ovve", "Snyggt");
	    Drink Kir = new Drink("Kir", "Mmm gott med kir");
	    Food CheeseBurger = new Food("Cheeseburgare", "Världens bästa fyllekäk, har bottat många kommande bakfyllor!!!");
	    	    
	    // Assign Items to rooms
	    Ryd.setItem(Ovve);
	    Systemet.setItem(Kir);
	    Donken.setItem(CheeseBurger);
	    
	    // Assign required Items to visit places
	    Colonia.setRequiredItem(Kir);
	    Karallen.setRequiredItem(Ovve);
	    
	    // add to array
	    locations.add(Ryd);
	    
	    Ryd.setLocToVisited();
    }

    public void run() {
        String name;
            
        System.out.println("Välkommen till Linkan\nVad är ditt namn?");
        name = keyboard.nextLine();
        player = new Player(name, locations.get(0));
        System.out.println(name + ", du befinner dig just nu i Ryd då detta tyvärr är ditt hem. En korre i Ryd...\n"
        		+ "Men det är torsdag och Kravall på Kårallen ikväll:) \nDet betyder att vi kan glömma våra omtentor och dränka vår ångest genom en magisk kväll!");
        System.out.println("Kl är 18.00 och du måste skynda dig till systemet innan stägning!!! \nMen innan du begär dig iväg behöver du klä dig i dit favoritplagg...\n"
        		+ "Ovven!! \nDin korre är stökig och du behöver därför leta runt... Prova komandot 'leta'");
        
        while (true) {
            String command;
            
            System.out.println("Vad vill du göra?");
            command = keyboard.nextLine();
            player.doCommand(command);
        }	    
    }

}
