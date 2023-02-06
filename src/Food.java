class Food extends Item {
		Food(String name, String desc){
			super(name, desc);
		}
		
		@Override
		public void use(Player player) {
			player.setDrunk(-(player.getDrunk()/2));
			System.out.println("Nom, Nom, Nom! Gott med " + this.getName() + "!!");
			System.out.println("Din promille ligger nu på " + player.getDrunk());
		}
}
