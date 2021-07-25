/* ******************************************************************************************************
AUTHOR Gabija Miliute
12/02/2020 Short Exercise 7
The program below contains
    - accessors and mutators
    - if statement 
    - records
This program gives information about the swimmers team eligability in the relay event
******************************************************************************************************* */
import java.util.Scanner; // Imports the some packages for specific commands
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;

public class relayEvent
{
    public static void main (String args[]) // extremely simplified main function
    {
        swimmersInformation();
        System.exit(0);
    } // END main
    // define setters and getters here
// main method for getting the details about the team, giving the details to the accessor method fields, which set the value in the field and gets for the printing
    public static void swimmersInformation() //obtain the input from the user
    {
        String countryName;
        int swimmer1, swimmer2, swimmer3, swimmer4, sum, maxPoints; 
        Scanner _countryScan = new Scanner(System.in);
        Scanner _swimmerScan = new Scanner(System.in);

        System.out.println("What is the classification (maximum points) of this relay event?");
        maxPoints = _swimmerScan.nextInt();

        System.out.println("What country is the team representing?");
        countryName = _countryScan.nextLine();

        System.out.println("What is the disability category of Swimmer1?");
        swimmer1 = _swimmerScan.nextInt();

        System.out.println("What is the disability category of Swimmer2?");
        swimmer2 = _swimmerScan.nextInt();

        System.out.println("What is the disability category of Swimmer3?");
        swimmer3 = _swimmerScan.nextInt();

        System.out.println("What is the disability category of Swimmer4?");
        swimmer4 = _swimmerScan.nextInt();

            ParaRelayTeam team = new ParaRelayTeam();
            team = setCountry(team, countryName);
            team = setS1(team, swimmer1);
            team = setS2(team, swimmer2);
            team = setS3(team, swimmer3);
            team = setS4(team, swimmer4);

            sum = swimmer1 + swimmer2 + swimmer3 + swimmer4; 
        //System.out.println(getCountry(team) + " " + getS1(team) + " " + getS2(team) + " " + getS3(team) + " " + getS4(team));
        if(sum <= maxPoints)
        {
            System.out.println("That " + countryName + " team has " + sum + " points so is legal");
        } 
        else
        {
            System.out.println("That " + countryName + " team has " + sum + " points so it is not legal");
        }
        return;
    }//END swimmersInformation

  public static class ParaRelayTeam 
  {
    private String country;
    private int s1;
    private int s2;
    private int s3;
    private int s4; //s4 points, s4 - swimmer four in the team
  }
//setters and getters or accessors and mutators
  public static String getCountry(ParaRelayTeam team)
  {
    return team.country;
  }
  public static ParaRelayTeam setCountry(ParaRelayTeam team, String newCountry)
  {
    team.country = newCountry;
    return team;
  }
//******************************
  public static int getS1(ParaRelayTeam team)
  {
    return team.s1;
  }
  public static ParaRelayTeam setS1(ParaRelayTeam team, int s1Points)
  {
    team.s1 = s1Points;
    return team;
  }
//**************************
  public static int getS2(ParaRelayTeam team)
  {
    return team.s2;
  }
  public static ParaRelayTeam setS2(ParaRelayTeam team, int s2Points)
  {
    team.s2 = s2Points;
    return team;
  }
//************************
  public static int getS3(ParaRelayTeam team)
  {
    return team.s3;
  }
  public static ParaRelayTeam setS3(ParaRelayTeam team, int s3Points)
  {
    team.s3 = s3Points;
    return team;
  }
//*************************************
  public static int getS4(ParaRelayTeam team)
  {
    return team.s4;
  }
  public static ParaRelayTeam setS4(ParaRelayTeam team, int s4Points)
  {
    team.s4 = s4Points;
    return team;
  }
// generalised method 
/*
public static ParaRelayTeam setTeam(String newCountry, int s1Points, int s2Points, int s3Points, int s4Points) // parameters referenced - initialise method
  {
    ParaRelayTeam team = new ParaRelayTeam(); //new team created
    team.country = newCountry;  //accessor methods
    team.s1 = s1Points;
    team.s2 = s2Points;
    team.s3 = s3Points;
    team.s4 = s4Points;
   
    return team;
  }
*/
} // END class relayEvent