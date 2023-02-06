import java.util.*;

public class Location {
    private String Name;
    private String Description;
    protected ArrayList<Item> items = new ArrayList<Item>();
    private Boolean visited = false;
    private Location[] paths = new Location[4];

    Location(String name, String desc){
        this.Description = desc;
        this.Name = name;
    }
    
	public void setPaths(Location north, Location east, Location south, Location west) {		
		paths[0] = north;
		paths[1] = east;
		paths[2] = south;
		paths[3] = west;
	}

    public String getName(){
        return this.Name;
    }
    
    public void setLocToVisited() {
    	this.visited = true;
    }
    
    public Boolean getVisited() {
    	return this.visited;
    }
    
    void look(){
    	System.out.println("letar..");
    	for (Item item : this.items) {
	    	System.out.println(item.getName());
		}
    }
    
    public void setItem(Item item){
    	this.items.add(item);
    }
    
    public void removeItem(Item item){
    	this.items.remove(item);
    }
    
    public ArrayList<Item> getItems(){
        return this.items;
    }

    public String describeYourself(){
    	int index = this.Description.indexOf(",");
    	if (this.visited) {
    		return this.Description.substring(0, index);
    	} else {
    		return this.Description;
    	}
        
    }
    
        
    public Location[] getPaths() {
    	return this.paths;
    }

    public Location getPath(String direction){
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
