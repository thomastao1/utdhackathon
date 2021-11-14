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
		double util, med, food, others, housing, transport;
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
		 System.out.print("On average how much do you spend on transport per month? ");
		 transport = input.nextDouble();
		 
		 
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
		 
		 //utilizing score
		 int tScore = score(util, col[counter].util) + score(med, col[counter].health) + score(food, col[counter].food) + score(housing, col[counter].housing) + score(others, col[counter].misc) 
		  + score(transport, col[counter].transport);
		 tScore /= 6;
		 
		 System.out.println("Your financial score is: " + tScore);
		 
		 
    }

public costData[] parser() throws FileNotFoundException 
{
    Scanner reader = new Scanner(new File("COF_States1.txt"));
    costData[] list = new costData[50];
    int index = 0;
    reader.useDelimiter("\t");
    while (reader.hasNext()){
        list[index++] = new costData(reader.next(),reader.nextDouble(),reader.nextDouble(),reader.nextDouble(),reader.nextDouble(),reader.nextDouble(),reader.nextDouble(), reader.nextDouble());
        reader.nextLine();
    }
    	return list; 
	}
public static int score(double stateNum, double base)
{
	double defic = 0.0;	//deficit
	boolean lt = false;	//bool var for if the amount spent is under the minimum cost of living
	int score = 0;	//return variable
	
	if(stateNum < base)	//address under cost of living case 
	{
		defic = (base - stateNum);
		lt = true;
	}
	else if (stateNum >= base)	//normal case - above cost of living
	{
		defic = (stateNum - base);
	}
	
	if(!lt)
	{
		score = (int) (100*(1 - (defic/base)));	//normal case - total score out of 100, take the % off from the base and multiply 100 by it - more points based off of how close you are to minimum cost of living
	}
	else
		return -1;	//return -1 for less than, deal with this in driver - reccommend different financial advice links as it is likely the client is struggling 
	return score;
	
}

}