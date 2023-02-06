import java.util.ArrayList;

class Food extends Item {
		Food(String name, String desc){
			super(name, desc);
		}
		
		public static void eat(ArrayList<Item> items) {
		   	for (Item item : items) {
	    		if (item instanceof Food) {
	    			System.out.println("Nom, Nom, Nom! Gott med " + item.getName() + "!!");
	    		}
			}
			
		}
}
