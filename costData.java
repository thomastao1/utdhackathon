package utdHack;
import java.util.*;
import java.io.*;
public class costData {
	 public String state;
	    public double costLiving, food, transport, housing, misc, health;
	    costData(String astate, double acost, double afood, double atransport, double ahousing, double amisc, double ahealth){
	        state = astate;
	        costLiving = acost;
	        food = afood;
	        transport = atransport;
	        housing = ahousing;
	        misc = amisc;
	    }
}
