import java.util.ArrayList;

class Party extends Location {	
	private Item requiredItem;
	
	Party(String name, String description){
		super(name, description);
	}
	
	public static void dance(Location pos) {
		if(pos instanceof Party) {
			System.out.println("CHACHACHA");
		} else {
			System.out.println("Du kan inte dansa här:(((((");
		}
	}
	
	public void setRequiredItem(Item req) {
		this.requiredItem = req;
	}
	
	public Item getRequiredItem() {
		return this.requiredItem;
	}
	
	public Boolean playerHasItem(ArrayList<Item> items) {
    	for (Item item : items) {
    		if (item == requiredItem) {
    			return true;
    		}
		}
    	return false;
	}
	
	public static void getMusic(Location pos) {
		if (pos instanceof Party) {
			String Music[] = new String[] { "Mares", "Avicii", "Lov1", "Bolaget" };
			System.out.println(Music[(int) Math.floor(Math.random()*Music.length)] + " spelas högt!!!");
		}

	}
}
