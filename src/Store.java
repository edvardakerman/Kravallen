class Store extends Location {
	Store(String name, String description){
		super(name, description);
	}
	
	@Override
    public void setItem(Item item){
    	this.items.add(item);
    	this.items.add(item);
    	this.items.add(item);
    }
	
	@Override
    void look(){
    	System.out.println(this.getName() + " säljer:");
    	for (int i = 0; i < this.items.size(); i++) {
			System.out.println((i+1) + ". " + this.items.get(i).getName());
		}
    }
}
