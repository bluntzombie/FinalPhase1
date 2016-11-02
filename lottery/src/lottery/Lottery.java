package lottery;

import javax.swing.JOptionPane;

/**
 * @author: Christopher Kambayi, Emma English, Mahamed Basha, Leandro Silva
 * Date: 11/10/2016
 * Lottery.java
 * Version: 1
 */

public class Lottery 
{
    //declaring and creating the variables
    private int [] lotto = new int[5];
    private int [] numbers;
    private int lineOne, lineTwo, lineThree;
    
    //the overloaded constructor
    public Lottery(int[] lotto) 
    {
        this.lotto = lotto;
        lineOne = 0;
        lineTwo = 0;
        lineThree = 0;
    }

    //generates random numbers into an array with five columns
    public void generate()
    {
        //a variable to temporarily store the random number
        int temp;
        
        //a loop that runs the length of the lotto
        for(int i = 0; i < lotto.length; i++)
        {
            //sets the temporary int to a random number between 1 - 40
            temp = 1 + (int)(Math.random() * 40);
            
            //if the random number is contained within the lotto, run again
            while(temp == lotto[0] || temp == lotto[1] || temp == lotto[2] || temp == lotto[3] || temp == lotto[4])
            {
                //sets temp to another random number between 1 - 40
                temp = 1 + (int)(Math.random() * 40);
            }
            
            //sets the lottery position to the temporary number
            lotto[i] = temp;
        }
    }
    
    //compares generated numbers against numbers the user entered
    public void verify(int [][] numbers)
    {
       //sets a counter variable
       int counter = 0;
       
       //the loop runs five times
       for(counter = 0; counter < 5; counter++)
       {
           //runs through the three rows of numbers in the lottery
            for(int i = 0; i < 3; i++)
            { 
               //runs through the five columns of numbers in the lottery
               for(int x = 0; x < 5; x++)
               {
                   //if the number contained in the lotto is the users guess
                   if(lotto[counter] == numbers[i][x])
                   {
                       //if it's row one, increase the right guesses for row one
                       if(i==0)
                       lineOne = lineOne + 1;

                        //if it's row two, increase the right guesses for row two
                        if(i==1)
                        lineTwo = lineTwo + 1;

                            //if it's row three, increase the right guesses for row three
                            if(i==2)
                            lineThree = lineThree + 1;  
                   }            
                }        
            } 
       }
    }
    
    //the print method for the user
    public void printResults()
    {   
        JOptionPane.showMessageDialog(null, "Lotto Numbers are: " + lotto[0]+ " " + lotto[1]+ " " + lotto[2]+ " " + lotto[3]+ " " + lotto[4] + ".");
        JOptionPane.showMessageDialog(null, "You got " + lineOne + " right on line 1.");
        JOptionPane.showMessageDialog(null, "You got " + lineTwo + " right on line 2.");
        JOptionPane.showMessageDialog(null, "You got " + lineThree + " right on line 3.");
        
    }
}