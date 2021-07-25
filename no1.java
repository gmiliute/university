/* ****************************************************
AUTHOR Gabija Miliute
01/15/2021 Exercise No1
The program below contains
    - Screen Input, Keyboard Input
    - Method calls, and methods that take arguments
    - Variables, assignments and expressions
    - loops
    - decision statements 

This procedural program 
******************************************************** */
import java.util.Scanner; // Imports the some packages for specific commands
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;

public class no1
{
    public static void main (String args[]) //main function body
    {
        
        pilesOfCountersDrawer(); //inputTop, inputBottom
        System.exit(0);
    
    } // END main

public static int inputTop()  
{
    int topNumber = 0;
    boolean flag = false;
  
    Scanner topNumberScan = new Scanner(System.in);
    System.out.println("Enter an odd top number: ");

    topNumber = Integer.parseInt(topNumberScan.nextLine());
    while(flag == false)
    {
        if(topNumber < 0) //validation for a positive input
        {  
            System.out.println("It can't be a negative number, try again: ");
            topNumber = Integer.parseInt(topNumberScan.nextLine());
            flag = false;
        } 
        else if(topNumber % 2 == 0)
        {
            System.out.println("It can't be an even number, try again: ");
            topNumber = Integer.parseInt(topNumberScan.nextLine());
            flag = false;
        } 
        else 
        {
            flag = true;
        } 
     }     
    return topNumber;
} // END inputTop

public static int inputBottom()  
{
    int bottomNumber = 0;
    boolean flag = false;
    Scanner bottomNumberScan = new Scanner(System.in);
       System.out.println("Enter an odd bottom number: ");

    bottomNumber = Integer.parseInt(bottomNumberScan.nextLine());
    while(flag == false)
    {
        if(bottomNumber < 0) //validation for a positive input
        {  
            System.out.println("It can't be a negative number, try again: ");
            bottomNumber = Integer.parseInt(bottomNumberScan.nextLine());
            flag = false;
        } 
        else if(bottomNumber % 2 == 0)
        {
            System.out.println("It can't be an even number, try again: ");
            bottomNumber = Integer.parseInt(bottomNumberScan.nextLine());
            flag = false;
        } 
        else 
        {
            flag = true;
        } 
    }
    return bottomNumber;
} // END inputBottom
//3 5 8
public static void pilesOfCountersDrawer()
{
    final String character = "=";
    int top = inputTop();
    int bottom = inputBottom();
    for (int i = top; i <= bottom; i++)
    {
        System.out.println(character);
    }       

    return;
} // END pilesOfCountersDrawer

/*
//printing the given symbol
public static void printPattern(int dimension, String special)
 {
    for(int line = 1; line <= dimension; line++)
    {
        printLine(dimension, special, line);
    }
 } 

public static void printLine(int lenght, String specialChar, int specialPosition)
{
    final String normalChar = "X";

        for(int i = 1; i <= lenght; i++)
        {
            if (i == specialPosition) // stripe character at a multiple of stripe number
                print(specialChar);
            else
                print(normalChar);
        }
        println("");
}

public static void println(String message)
{
    System.out.println(message);
    return;
}

public static void print(String message)
{
    System.out.print(message);
    return;
}

 // Input a string
public static int inputTop(String message)
{
    Scanner inputScan = new Scanner(System.in);
    println(message);
    return (inputScan.nextInt()); 
}

 // Input an int
public static int inputBottom(String message)
{
    return Integer.parseInt(input(message));
} 
*/

} // END no1
/*
//*******************************************************************************************************
// this method will ask the user for his real age
// it also does not allow to enter negative values
public static int startBottles()  
{
    int bottles = 0;
  
    Scanner bottleScan = new Scanner(System.in);
    System.out.println("How many bottles should I start with?");
    bottles = Integer.parseInt(bottleScan.nextLine());
        if(bottles < 0) {  
            System.out.println("It can't be a negative number, try again: ");
            bottles = Integer.parseInt(bottleScan.nextLine());
        } 
        else {}
          
    return bottles;
} // END startBottles

//*******************************************************************************************************
// this method will ask the user for his real age
// it also does not allow to enter negative values
public static int bottlesGo()  
{
    int bottlesDrop = 0;
  
    Scanner bottleDropScan = new Scanner(System.in);
    System.out.println("At what step should 2 bottles go?");
    bottlesDrop = Integer.parseInt(bottleDropScan.nextLine());
        if(bottlesDrop < 0) {  
            System.out.println("It can't be a negative number, try again: ");
            bottlesDrop = Integer.parseInt(bottleDropScan.nextLine());
        } 
        else {}
          
    return bottlesDrop;
} // END bottlesGo
public static void song()
{

    int startingBottles = startBottles();
    int bottlesDrops = bottlesGo();
    int n = 2, m = 1;

    for (int i = startingBottles; i > 0; i--)
    {
        if(i != bottlesDrops && i > 1)
        {
            System.out.println(i + " blue bottles sitting on the wall.");
            System.out.println(i + " blue bottles sitting on the wall."); 
            System.out.println("and if " + m + " blue bottle should accidentally fall.");
            System.out.println("There are " + (i - 1) + " blue bottles sitting on the wall. \n"); 

        }
        else if (i == bottlesDrops)
        {
            System.out.println(i + " blue bottle sitting on the wall.");
            System.out.println(i + " blue bottle sitting on the wall.");
            System.out.println("and if " + n + " blue bottles should accidentally fall.");

            if ((i - 2) != 1)
            {
                System.out.println("There are " + (i - 2) + " blue bottles sitting on the wall. \n"); 
            }
            else
            {
                System.out.println("There are " + (i - 2) + " blue bottle sitting on the wall. \n");
            }

            i--;
        }

        else
        {
            System.out.println(i + " blue bottle sitting on the wall.");
            System.out.println(i + " blue bottle sitting on the wall."); 
            System.out.println("and if " + m + " blue bottle should accidentally fall.");
            System.out.println("There are " + (i - 1) + " blue bottles sitting on the wall. \n"); 
            break;
        }  

    }

    System.out.println("The END");
        
    return;
} // END song

} // END class no1

*/