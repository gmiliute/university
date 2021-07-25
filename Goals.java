/* ******************************************************************************************************
AUTHOR Gabija Miliute
11/02/2020 Short Exercise 5
The program below contains
    - counter-controlled loops
    - if statement 
    - arrays
This program gives information about the Top Women's Goal scorers
******************************************************************************************************* */
import java.util.Scanner; // Imports the some packages for specific commands
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;

public class Goals
{
    public static void main (String args[]) // extremely simplified main function
    {
        scorersInformation();
        System.exit(0);
    } // END main

    public static void scorersInformation() // runs loop 4 times to obtain the input from the user
    {
        final int SCORERS = 4;
        String [] name = new String [SCORERS]; //array for storing 4 values about scorers names
        int [] score = new int [SCORERS];
        String [] country = new String [SCORERS];

        Scanner nameScan = new Scanner(System.in);
        Scanner scoreScan = new Scanner(System.in);
        Scanner countryScan = new Scanner(System.in);

        for(int i = 0; i < SCORERS; i++)
        {
            System.out.println("Name footballer " + (i+1) + "?");
            name[i] = nameScan.nextLine();

            System.out.println("How many goals did they score?");
            score[i] = Integer.parseInt(scoreScan.nextLine());

            System.out.println("What country did they play for?");
            country[i] = countryScan.nextLine();
        }

        int number = largest(score);

        for(int i = number; i < SCORERS; i++) //runs a loop exactly once to obtain the name of the highest scorer
        {
           System.out.println("The highest scoring player is: " + name[i]);
           break;  
        }

        int sum = IntStream.of(score).sum(); //uses stream to sum up array values which were converted to int
        System.out.println("These players scored " + sum + " goals between them. \n");

        System.out.println("The details of the players are:");
       for(int i = 0; i < SCORERS; i++)
       {
        System.out.println(name[i] + ", " + country[i] + ", " + score[i]);
    }
    return;
}//END scorersInformation

public static int largest(int score[]) //obtains the largest value's index
{
    final int SCORERS = 4;
    int maxScore = score[0];
    int index = 0;
    for(int i = 1; i < SCORERS; i++)
    {
        if(score[i] > maxScore)
        {
            index = i;
            maxScore = score[i];
        }
    }

    return index;
}//END largest


//*******************************************************************************************************
/*public static String[] scorersName(int SIZE) 
{
    String [] name = new String [SIZE];
    Scanner nameScan = new Scanner(System.in);
    System.out.println("Name footballer " + (i+1) + "?");
    name[i] = nameScan.nextLine();
    
    return name[i];
 }

 public static int[] scorersGoals(int SIZE) 
{
    Int [] score = new Int [SIZE];
    Scanner scoreScan = new Scanner(System.in);
    System.out.println("How many goals did they score?");
    score[i] = scoreScan.nextInt();
    
    return score[i];
 }

 public static String[] scorersCountry(int SIZE) 
{
    String [] country = new String [SIZE];
    Scanner countryScan = new Scanner(System.in);
    System.out.println("What country did they play for?");
    country[i] = countryScan.nextLine();
    
    return country[i];
 }
*/
/*
    String [] name = new String[SCORERS];
    int [] score = new int[SCORERS];
    String [] country = new String[SCORERS];
*/
/*
public static class Woman // Record storage about the underground station details
{
    String name;
    int score;
    String country;
}

public static Woman createDetails (String _name, int _score, String _country)
{
    Woman w = new Woman();
    w.name = _name;
    w.score = _score;
    w.country = _country;

    return w;
}


public static void scorersInformation() // asks about the station number we want to know and plays loop that many times
{
    //final int SCORERS = 4;
    //Woman [] women = new Woman [SCORERS];
    Scanner in = new Scanner(System.in);
    Woman [] women = new Woman [SCORERS];
    //Scanner place = new Scanner(System.in);

    for (int i = 0; i < SCORERS; i++)
    {
        //women[i] = w;
        women[i] = in.nextLine();

        System.out.println("Name footballer " + (i+1) + "?");
        String givenName = in.nextLine();

        System.out.println("How many goals did they score?");
        int givenScore = in.nextInt();

        System.out.println("What country did they play for?");
        String givenCountry = in.nextLine();
        

        /*
        System.out.println("Name footballer " + (i+1) + "?");
        String givenName = newObj.nextLine();

        System.out.println("How many goals did they score?");
        int givenScore = newObj.nextInt();

        System.out.println("What country did they play for?");
        String givenCountry = place.nextLine();
        */
/*
        Woman w = createDetails(givenName, givenScore, givenCountry);
        

    }  

return;   

} // END stationInformation
*/
} // END class Goals