package examples;

import java.util.*;

public class MakeChange {
    public static void main(String[] args) {
        
        double price;
        double payment;
        boolean error = false;
        
        Scanner scanner = new Scanner(System.in);
        do {
        System.out.println("How much was the item?");
        price = scanner.nextDouble();
        
        System.out.println("How much did the customer pay?");
        payment = scanner.nextDouble();
        
        if (payment < price){
            error = true;
            System.out.println("Payment must be greater than the price!");
        }
        else
            error = false;
                   
        } while (error);
        
        double change = payment - price;       
        
        printChange(howMuch(change));
        
    }
    
    public static int[] howMuch(double change)
    {
         double denom[]= {20, 10, 5, 1, .25, .10, .05, .01};
         int changeDenom[] = new int[8];
         for (int i = 0; i < denom.length; i++)
         {
         if (change/denom[i] >= 0) {
             changeDenom[i] = (int)((change/denom[i]));
             change = change%denom[i];
         }
         else {
             changeDenom[i] = 0;
         }
         
         }
        return changeDenom;
    }
    
    public static void printChange(int[] changeDenom)
    {
        System.out.print("The customer should be given ");
        String printDenom[] = {" twenties", " tens", " fives", " ones",
                " quarters", " dimes", " nickles", " pennies"};
        
        
        for (int i = 0; i < changeDenom.length; i++)
        if (changeDenom[i] > 0) {
            System.out.print(changeDenom[i] + printDenom[i] + ", ");
        }
        
        if (changeDenom[0] == 0 && changeDenom[1] == 0 
                && changeDenom[2] == 0 && changeDenom[3] == 0 
                && changeDenom[4] == 0 && changeDenom[5] == 0
                && changeDenom[6] == 0 && changeDenom[7] == 0) {
            System.out.println("nothing, since they paid the exact amount!");
           
    }
        else
            System.out.println("and that's it.");
    }
}