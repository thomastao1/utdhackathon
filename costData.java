package utdHack;
import java.util.*;
import java.io.*;
public class costData {
	 public String state;
	    public double costLiving, food, transport, housing, util, misc, health;
	    costData(String astate, double acost, double afood, double atransport, double ahousing, double autil, double amisc, double ahealth){
	        state = astate;
	        costLiving = acost;
	        food = afood;
	        transport = atransport;
	        housing = ahousing;
	        misc = amisc;
	        util = autil;
	        health = ahealth;
	    }
}
