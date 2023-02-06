import java.util.ArrayList;

class Drink extends Item{
	Drink(String name, String desc){
		super(name, desc);
	}
	
	public static void drink(ArrayList<Item> items) {
	   	for (Item item : items) {
    		if (item instanceof Drink) {
    			System.out.println("Klunk Klunk Klunk! Gott med " + item.getName() + "!!");
    		}
		}
		
	}
}
