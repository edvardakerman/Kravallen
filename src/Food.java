class Food extends Item {
		Food(String name, String desc){
			super(name, desc);
		}
		
		@Override
		public void use() {
			// TODO Auto-generated method stub
			System.out.println("Nom, Nom, Nom! Gott med " + this.getName() + "!!");
		}
}
