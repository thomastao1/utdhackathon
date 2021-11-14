package utdHack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.*;
import javax.swing.*;


public class buttonHandler implements ActionListener {
        
	private JTextField t1, t2, t3, t4, t5, t6;
	private Object selectedItem;
        
        public buttonHandler(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5, JTextField t6, Object selectedItem) {
            this.t1 = t1;
            this.t2 = t2;
            this.t3 = t3;
            this.t4 = t4;
            this.t5 = t5;
            this.t6 = t6;
            this.selectedItem = selectedItem;
        }
        
        public static int score(double base, double stateNum)	//base - how much the user is spending. statenum - how much the average is
        {
            double defic;    //deficit
            boolean lt;   //bool var for if the amount spent is under the minimum cost of living
            int score = 0;    //return variable

            if(base-stateNum > 1000) {
            	defic = 0;
            	lt = true;
            }
            else if(stateNum < base) {	//user spending more than state average. Normal case
            	defic = (base - stateNum);
            	lt = false;
            }
            else if(Math.abs(stateNum-base) < 375) { //thresh hold for spending too little
            	defic = Math.abs((base-stateNum));
            	lt = false;
            }
            else {
            	defic = 0;
            	lt = true;
            }
            
            if(!lt) {
            	score = (int) (100*(1 - (defic/stateNum)));
            	return score;
            }
            else {
            	return -1;	//they're spending too little on basic necessities.
            }
            

            
        }
        
		public void actionPerformed(ActionEvent e) {
            //System.out.println(t1.getText()+" "+t2.getText());
            
   		 	double total = Integer.valueOf(t1.getText())+Integer.valueOf(t2.getText())+Integer.valueOf(t3.getText())+Integer.valueOf(t4.getText())
   		 	+Integer.valueOf(t5.getText())+Integer.valueOf(t6.getText());
   		 	
   		 	JFrame b = new JFrame("Results");
		 	b.setSize(800,400);
		 	b.setMinimumSize(new Dimension(600, 400));
		 	b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 	b.setVisible(true);
		 	b.setLayout(new GridBagLayout());
		 	
		 	GridBagConstraints constraint = new GridBagConstraints();
		 	constraint.gridx = 0;
		    constraint.gridy = 0;
		    constraint.anchor = GridBagConstraints.CENTER;
		 	
   		 	b.add(new JLabel("Results: "), constraint);
   		 	constraint.gridy++;
   		 	
   		 	new Main();
   		 	
   		 	String state = "";
   		 	int counter = 0;
   		 	for(int i = 0; i < Main.states.size(); i++){
   		 		if(Main.states.get(i).equals(selectedItem)) {
   		 			state += selectedItem;
   		 			counter = i;
   		 		}
   		 	}
   		
   		 	b.add(new JLabel("Your average cost of living is $"+total+" compared to the average cost of living in "+state+" is $"+Main.list[counter].costLiving), constraint);
			constraint.gridy++;
			
   		 	/*int tScore = score(util, col[counter].util) + score(med, col[counter].health) + score(food, col[counter].food) + score(housing, col[counter].housing) + score(others, col[counter].misc) 
          + score(transport, col[counter].transport);
         tScore /= 6;*/
   		 	
   		 	int foodScore = score(Double.parseDouble(t1.getText()), Main.list[counter].food);
   		 	int transportScore = score(Double.parseDouble(t2.getText()), Main.list[counter].transport);
   		 	int housingScore = score(Double.parseDouble(t3.getText()), Main.list[counter].housing);
   		 	int utilScore = score(Double.parseDouble(t4.getText()), Main.list[counter].utilities);
   		 	int miscScore = score(Double.parseDouble(t5.getText()), Main.list[counter].misc);
   		 	int healthScore = score(Double.parseDouble(t6.getText()), Main.list[counter].health);
   		 	
   		 	System.out.println(foodScore);
   		 	System.out.println(transportScore);
   		 	System.out.println(housingScore);
   		 	System.out.println(utilScore);
   		 	System.out.println(miscScore);
   		 	System.out.println(healthScore);
   		
   		 	int tScore = foodScore+transportScore+housingScore+utilScore+miscScore+healthScore;
   		
   		 	b.add(new JLabel("Here's your overall score for purchases made throughout the year: "+tScore), constraint);
			constraint.gridy++;
			if(tScore > 500) {
				b.add(new JLabel("Good job! You did great in maintaining your finances!"), constraint);
				constraint.gridy++;
			}
			else {
				if(tScore > 300) {
					b.add(new JLabel("Your financial situation is sub-standard. Try looking over these resources to better understand responsible financing."), constraint);
					constraint.gridy++;
				}
				else {
					b.add(new JLabel("Your financial situation is poor. Look over these resources to better understand responsible financing."), constraint);
					constraint.gridy++;
				}
					
					JLabel link = new JLabel("https://www.statefarm.com/simple-insights/financial/when-do-i-need-a-financial-advisor");
					b.add(link, constraint);
					link.setForeground(Color.BLUE);
					constraint.gridy++;
					JLabel link2 = new JLabel("https://www.statefarm.com/simple-insights/financial/build-an-emergency-fund");
					b.add(link2, constraint);
					link2.setForeground(Color.BLUE);
					constraint.gridy++;
					JLabel link3 = new JLabel("https://www.statefarm.com/simple-insights/financial/the-psychology-of-spending-habits-and-mistakes");
					b.add(link3, constraint);
					link3.setForeground(Color.BLUE);
					constraint.gridy++;
					JLabel link4 = new JLabel("https://www.statefarm.com/simple-insights/financial/effortless-ways-to-save-money");
					b.add(link4, constraint);
					link4.setForeground(Color.BLUE);
					constraint.gridy++;
					
			
			}
			b.add(new JLabel("This score was calculated based off the information you inputted."), constraint);
			constraint.gridy++;
			
			
			
   		 	//"Your average cost of living is $" + total + " compared to the average cost of living in " + state + " is $" + col[counter].costLiving

	 	
        }
}