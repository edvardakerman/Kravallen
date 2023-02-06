abstract class Item {
    private String name;
    private String description;
    
    Item(String Name, String Description){
    	this.name = Name;
    	this.description = Description;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDesc(){
        return this.description;
    }
    
    // doCommand ??
    
}
