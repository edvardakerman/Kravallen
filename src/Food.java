class Food extends Item {
		Food(String name, String desc){
			super(name, desc);
		}
		
		public void eat(Player player) {
			System.out.println("Nom, Nom, Nom! Gott med " + this.getName() + "!!");
			player.removeItem(this);
		}
}
