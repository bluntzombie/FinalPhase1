package lottery;

/**
 * @author: Christopher Kambayi, Emma English, Mahamed Basha, Leandro Silva
 * Date: 11/10/2016
 * Lottery.java
 * Version: 1
 */

import javax.swing.JOptionPane;

public class LotteryApp 
{
    public static void main(String [] args)
    {
        //Declaring variables
        int [] lotto = new int [5];
        
        //Creating objects
        Lottery myLotto = new Lottery(lotto);
        
        //Array for user's guesses
        int [][] lucky = new int [3][5];
        
        //welcome the user to the application
        JOptionPane.showMessageDialog(null, "Welcome to the Lottery!");
        
        JOptionPane.showMessageDialog(null, "You have to enter three lines of five numbers between 1 - 40.");
        
        //while loop to input guesses into 2D array
        for(int i = 0; i < 3; i++)
        {
              for(int j = 0; j < 5; j++)
            {
                lucky[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null, "Line " + (i+1) + ", Number " + (j+1)));
            }
        }
        
        //generate the random numbers
        myLotto.generate();
        
        //compare the random numbers with entered numbers
        myLotto.verify(lucky);
        
        //print the generated numbers
        myLotto.printResults(); 
        
    }
}