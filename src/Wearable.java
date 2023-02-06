import java.util.ArrayList;

class Wearable extends Item {
	
	Wearable(String name, String desc){
		super(name, desc);
	}
	
	public static void putOn(ArrayList<Item> items){
    	for (Item item : items) {
    		if (item instanceof Wearable) {
    			System.out.println("Du är nu klädd i " + item.getName());
    		}
		}
	}
	
}
