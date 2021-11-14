package utdHack;
import java.io.*;
import java.util.*;

public class driver {

	public static void main(String args[]) throws Exception
    {
		driver no = new driver();
		Scanner input = new Scanner(System.in);
		costData[] col = new costData[50];
		String state;
		double util, med, food, others, housing;
		col = no.parser();
		
		System.out.println("Financial Score Calculator");
		System.out.print("What state do you live in? ");
		state = input.next();
		
		 System.out.print("On average how much do you spend on utilities per month? ");
		 util = input.nextDouble();
		 System.out.print("On average how much do you spend on medical bills per month ");
		 med = input.nextDouble();
		 System.out.print("On average how much do you spend on groceries per month? ");
		 food = input.nextDouble();
		 System.out.print("On average how much do you spend on housing per month? ");
		 housing = input.nextDouble();
		 System.out.print("On average how much do you spend on others per month? ");
		 others = input.nextDouble();
		 //System.out.print("what is " + state + "'s income tax for your tax bracket?");
		 //incometax = input.nextDouble();
		 
		 
		//_________________________________________________________for loop
		 int counter = 0;
		 for(int i = 0; i < 50; i++)
		 {
		 	if (col[i].state.equals(state))
		 		{
		 			counter = i;
		 			break;
		 		}
		 }
		 //________________________________________________________
		 double total = util + med + food + housing + others;
		 
		 
		 
		 System.out.println("Your average cost of living is $" + total + " compared to the average cost of living in " + state + " is $" + col[counter].costLiving);
		 
		 
		 /* 
		  arbitrary score from program
		  utilAvg = 100 * (math.abs(util - state average));
		  
		  final score = (income + food + med + util)/4
		  print finalscore;
		  print reccommendations	
		  */
    }

public costData[] parser() throws FileNotFoundException 
{
    Scanner reader = new Scanner(new File("COF_States1.txt"));
    costData[] list = new costData[50];
    int index = 0;
    reader.useDelimiter("\t");
    while (reader.hasNext()){
        list[index++] = new costData(reader.next(),reader.nextDouble(),reader.nextDouble(),reader.nextDouble(),reader.nextDouble(),reader.nextDouble(),reader.nextDouble());
        reader.nextLine();
    }
    	return list; 
	}

}