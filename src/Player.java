import java.util.ArrayList;

public class Player {
    private String Name;
    private Location Position;
    private ArrayList<Item> items = new ArrayList<Item>();
    
    Player(String name, Location start){
        this.Name = name;
        this.Position = start;
    }

    public String getName(){
        return this.Name;
    }

    public void doCommand(String cmd){
    	String arr[] = cmd.split(" ", 2);
    	
    	if (arr.length == 2) {
            switch (arr[0]) {
            case "gå":
                moveTo(arr[1]);
                break;
            case "ta":
                takeItem(arr[1]);
                break;
            default: 
                System.out.println("Ogilitigt kommando, skriv 'hjälp' för mer info");
                break;
            }           
    	} else {
            switch (arr[0]) {
            case "leta":
                look();
                break;
            case "hjälp":
            	help();
            	break;
            case "saker":
                inventory();
                break;
            case "klä":
            	Wearable.putOn(items);
                break;
            case "dansa":
                Party.dance(this.Position);
                break;
            case "drick":
                Drink.drink(this.items);
                break;
            case "ät":
                Food.eat(this.items);
                break;
            default: 
                System.out.println("Ogilitigt kommando, skriv 'hjälp' för mer info");
                break;
            }
    	}
    }

    public Location getLocation(){
        return this.Position;
    }
    
    void help(){
    	System.out.println("Giltiga Kommandon:");
    	System.out.println("1. gå      - followed by a direction, east/west/north/south");
    	System.out.println("2. ta      - followed by a spell, wingardium leviosa");
    	System.out.println("3. använd  - followed by a wearable item, Cloak of Invisibility");
    	System.out.println("4. drick   - followed by a item, Elderwand");
    	System.out.println("5. dansa   - Shows what you are currently carring with you");
    	System.out.println("6. ät	   - Shows whats on your current location");
    	System.out.println("7. leta	   - Shows whats on your current location");
    	System.out.println("8. saker   - Shows whats on your current location");
    }
    
    void takeItem(String Name){
    
    	for (Item item : this.Position.getItems()) {
    		if (Name.equals(item.getName())) {
    			this.items.add(item);
    			System.out.println(item.getName() + " laddes till bland dina saker.");
    		}
		}
    	this.Position.removeItem(this.items.get(this.items.size() - 1));
    }
    
    void inventory(){
    	System.out.println("Dina Saker");
    	for (Item item : this.items) {
	    	System.out.println(item.getName() + ", " + item.getDesc());
		}
    }    
    
    void look(){
    	System.out.println("letar..");
    	for (Item item : this.Position.getItems()) {
	    	System.out.println(item.getName());
		}
    }
    
    public Boolean playerHasAcces(Location newPos) {
		if(newPos instanceof Party) {						
			if (((Party) newPos).getRequiredItem() != null) {			
				if(((Party) newPos).playerHasItem(this.items)) {
					return true;
				} else {
					return false;
				}		    	
			} else {
				return true;
			}
		} else {
			return true;
		}
    }
    
    void moveTo(String direction){
    		
    	if (this.Position.getPath(direction) != null) {   		
    		if (playerHasAcces(this.Position.getPath(direction))) {
        		this.Position = this.Position.getPath(direction);
        	    System.out.println("Du befinner dig just nu vid " + this.Position.getName() + ", " + this.Position.describeYourself());
    		} else {
    			System.out.println("För att få komma till " + this.Position.getPath(direction).getName() + " behöver du " + ((Party) this.Position.getPath(direction)).getRequiredItem().getName());
    			System.out.println("Du befinner dig just nu vid " + this.Position.getName() + ", " + this.Position.describeYourself());
    		}
			Party.getMusic(this.Position);
    	} else {
        	System.out.println("Ogiltig riktining");
    	}
	}
    
}
