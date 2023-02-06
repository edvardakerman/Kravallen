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
            case "använd":
                useItem(arr[1]);
                break;
            default: 
                System.out.println("Ogilitigt kommando, skriv 'hjälp' för mer info");
                break;
            }           
    	} else {
            switch (arr[0]) {
            case "leta":
                this.Position.look();
                break;
            case "hjälp":
            	help();
            	break;
            case "saker":
                inventory();
                break;
            case "dansa":
                Party.dance(this.Position);
                break;
            default: 
                System.out.println("Ogilitigt kommando, skriv 'hjälp' för mer info");
                break;
            }
    	}
    }
    
    void help(){
    	System.out.println("Giltiga Kommandon:");
    	System.out.println("1. gå      - followed by a direction, east/west/north/south");
    	System.out.println("2. ta      - followed by a spell, wingardium leviosa");
    	System.out.println("3. använd  - followed by a wearable item, Cloak of Invisibility");
    	System.out.println("4. dansa   - Shows what you are currently carring with you");
    	System.out.println("5. leta	   - Shows whats on your current location");
    	System.out.println("6. saker   - Shows whats on your current location");
    }
    
    void useItem(String name) {
    	for (Item item : this.items) {
    		if (name.equals(item.getName())) {
    			item.use();
    		}
		}
    }
    
    void takeItem(String Name){
    
    	for (Item item : this.Position.getItems()) {
    		if (Name.equals(item.getName())) {
    			this.items.add(item);
    			System.out.println(item.getName() + " laddes till bland dina saker.");
    			break;
    		}
		}
    	this.Position.removeItem(this.items.get(this.items.size() - 1));
    }
    
    void inventory(){
    	System.out.println("Dina Saker:");
    	for (int i = 0; i < this.items.size(); i++) {
			System.out.println((i+1) + ". " + this.items.get(i).getName() + ", " + this.items.get(i).getDesc());
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
        	    this.Position.setLocToVisited();
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
