package utdHack;
public class costData {
	 public String state;
	    public double costLiving, food, transport, housing, utilities, misc, health;
	   
	    costData(String state, double cost, double food, double transport, double housing, double utilities, double misc, double health){
	        this.state = state;
	        costLiving = cost;
	        this.food = food;
	        this.transport = transport;
	        this.housing = housing;
	        this.utilities = utilities;
	        this.misc = misc;
	        this.health = health;
	    }
	    
}
