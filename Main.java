package utdHack;

import java.awt.Font;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Main {
	
	public static ArrayList<String> states = new ArrayList<String>();
	public static costData[] list = new costData[50];
	
	public static void parser() throws FileNotFoundException 
	{
		Scanner reader = new Scanner(new File("COF_States.txt"));
        int index = 0;
        //reader.useDelimiter("\t");
        while(reader.hasNextLine()) {
        	
        	String field = reader.nextLine();
        	String[] array = field.split("\t");
        	String state = array[0];
        	Double d = Double.parseDouble(array[1]);
        	Double d1 = Double.parseDouble(array[2]);
        	Double d2 = Double.parseDouble(array[3]);
        	Double d3 = Double.parseDouble(array[4]);
        	Double d4 = Double.parseDouble(array[5]);
        	Double d5 = Double.parseDouble(array[6]);
        	Double d6 = Double.parseDouble(array[7]);
        	
        	list[index] = new costData(state,d,d1,d2,d3,d4,d5,d6);
        	index++;
        }
            
		
	}
	
	public static void fillStates() throws FileNotFoundException {
		parser();
    	for(int i = 0; i < list.length; i++) {
    		states.add(i, list[i].state);
    	}
    }
	
	public static void main(String args[]) throws Exception
    {	
    	fillStates();
        JComboBox stateList = new JComboBox(states.toArray());
       // stateList.addActionListener(this);
        JLabel l99 = new JLabel("Financial Calculator");
        l99.setFont(new Font("Calibri",Font.BOLD,20));
        JLabel l0 = new JLabel("State you live in");
        JLabel l1 = new JLabel("Monthly Food Cost");
        JLabel l2 = new JLabel("Monthly Transportation Cost");
        JLabel l3 = new JLabel("Monthly Housing Cost");
        JLabel l4 = new JLabel("Monthly Utilities Cost");
        JLabel l5 = new JLabel("Monthly Other Cost");
        JLabel l6 = new JLabel("Monthly Health Care cost");
        

        JFrame a = new JFrame("State Farm");

        JTextField b1 = new JTextField();
        JTextField b2 = new JTextField();
        JTextField b3 = new JTextField();
        JTextField b4 = new JTextField();
        JTextField b5 = new JTextField();
        JTextField b6 = new JTextField();
        JButton buttons = new JButton("Enter");

        l99.setBounds(25,20,300,50);
        stateList.setBounds(225,70,200,25);
        l0.setBounds(25,70,175,25);
        b1.setBounds(225,100,200,25);
        l1.setBounds(25,100,175,25);
        b2.setBounds(225,130,200,25);
        l2.setBounds(25,130,175,25);
        b3.setBounds(225,160,200,25);
        l3.setBounds(25,160,175,25);
        b4.setBounds(225,190,200,25);
        l4.setBounds(25,190,175,25);
        b5.setBounds(225,220,200,25);
        l5.setBounds(25,220,175,25);
        b6.setBounds(225,250,200,25);
        l6.setBounds(25,250,175,25);
       
        
        buttons.setBounds(350, 280, 75, 30);
        buttons.addActionListener(new buttonHandler(b1,b2,b3,b4,b5,b6,stateList.getSelectedItem()));
        a.add(l99);
        a.add(l0);
        a.add(stateList);
        a.add(l1);
        a.add(b1);
        a.add(l2);
        a.add(b2);
        a.add(l3);
        a.add(b3);
        a.add(l4);
        a.add(b4);
        a.add(l5);
        a.add(b5);
        a.add(l6);
        a.add(b6);
        a.add(buttons);
        a.setSize(575,400);
        
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setLayout(null);
        a.setVisible(true);
}


}
