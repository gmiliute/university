/* ******************************************************************************************************
AUTHOR Gabija Miliute
12/08/2020 Miniproject: Gamified Olympics Medal Table Game
The program below contains
    - Screen Input, Keyboard Input
    - Method calls, and methods that take arguments
    - Variables, assignments and expressions
    - loops
    - decision statements 
    - method that takes array arguments
    - sorting algorithm
    - accessors and mutators
    - ADT 
    - file input and output

This procedural program aims to be a gamified version of Olympic medal table where the user is allowed to enter the 
medals count and the total is printed
******************************************************************************************************* */
import java.util.Scanner; // Imports the some packages for specific commands
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;

public class lvl
{
	public static void main (String args[]) // extremely simplified main function
  {
    char stop = 'n', quit = 'n';
    String input, finalInput;
    int choice = 0, n = 4;

    final int COUNTRIES = 5; //leaving 0th value out, for less confusion 
    String [] _countryName = new String [COUNTRIES];
    int [] _gold = new int [COUNTRIES]; //array for storing 5 values about names
    int [] _silver = new int [COUNTRIES];
    int [] _bronze = new int [COUNTRIES];

    Scanner _countryScan = new Scanner(System.in);
    Scanner _goldScan = new Scanner(System.in);
    Scanner _silverScan = new Scanner(System.in);
    Scanner _bronzeScan = new Scanner(System.in);
    Scanner scan = new Scanner(System.in);
    Scanner finalScan = new Scanner(System.in);

    printGreeting();

        try 
        {
          File myObj = new File("olympics.txt");
            if (myObj.createNewFile()) 
            {
                System.out.println("File is being created: " + myObj.getName());
            } 
            else 
            {
              System.out.println("File already exists.");
        
              FileReader reader = new FileReader("olympics.txt");
              int character;

              while ((character = reader.read()) != -1) 
              {
                System.out.print((char) character);
              }
              reader.close();
            }
        } 
        catch (IOException e) 
        {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }

// main game loop works with 4 country entries 3 of them is predefined while the last entry allows to create your own country
    for(int j = 0; j < n; j++)
    {
        while(stop != 'y') //entering y/Y stops the game table loop
        {
          System.out.println("\n\n\n\nPlease choose a country number: \n1. Lithuania \n2. United Kingdom \n3. Latvia \n4. Create new country\n\n"); 
          choice = scan.nextInt();

          switch(choice)
          { 
            case 1:

                System.out.println("How many gold medals has Lithuania won?");
                _gold[1] = _goldScan.nextInt();


                System.out.println("How many silver medals has Lithuania won?");
                _silver[1] = _silverScan.nextInt();

                System.out.println("How many bronze medals has Lithuania won?");
                _bronze[1] = _bronzeScan.nextInt();

                _countryName[1] = "Lithuania";

                Country country1 = new Country();
                country1 = setNewCountry(country1, _countryName[1]);
                country1 = setGold(country1, _gold[1]);
                country1 = setSilver(country1, _silver[1]);
                country1 = setBronze(country1, _bronze[1]);

                System.out.println(getNewCountry(country1) + " " + getGold(country1) + " " + getSilver(country1) + " " + getBronze(country1));

                  break;

               case 2:
                 System.out.println("How many gold medals has United Kingdom won?");
                 _gold[2] = _goldScan.nextInt();

                 System.out.println("How many silver medals has United Kingdom won?");
                 _silver[2] = _silverScan.nextInt();

                 System.out.println("How many bronze medals has United Kingdom won?");
                 _bronze[2] = _bronzeScan.nextInt();

                 _countryName[2] = "United Kingdom";

                Country country2 = new Country();
                country2 = setNewCountry(country2, _countryName[2]);
                country2 = setGold(country2, _gold[2]);
                country2 = setSilver(country2, _silver[2]);
                country2 = setBronze(country2, _bronze[2]);

                System.out.println(getNewCountry(country2) + " " + getGold(country2) + " " + getSilver(country2) + " " + getBronze(country2));

                  break;

               case 3:
                 System.out.println("How many gold medals has Latvia won?");
                 _gold[3] = _goldScan.nextInt();

                 System.out.println("How many silver medals has Latvia won?");
                 _silver[3] = _silverScan.nextInt();

                 System.out.println("How many bronze medals has Latvia won?");
                 _bronze[3] = _bronzeScan.nextInt();

                 _countryName[3] = "Latvia";

                 Country country3 = new Country();
                  country3 = setNewCountry(country3, _countryName[3]);
                  country3 = setGold(country3, _gold[3]);
                  country3 = setSilver(country3, _silver[3]);
                  country3 = setBronze(country3, _bronze[3]);

                System.out.println(getNewCountry(country3) + " " + getGold(country3) + " " + getSilver(country3) + " " + getBronze(country3));

                  break;

               case 4:

                 System.out.println("How is the country called?");
                 _countryName[4] = _countryScan.nextLine();

                 System.out.println("How many gold medals has " + _countryName[4] + " won?");
                 _gold[4] = _goldScan.nextInt();

                 System.out.println("How many silver medals has " + _countryName[4] + " won?");
                 _silver[4] = _silverScan.nextInt();

                 System.out.println("How many bronze medals has " + _countryName[4] + " won?");
                 _bronze[4] = _bronzeScan.nextInt();

                 Country country4 = new Country();
                  country4 = setNewCountry(country4, _countryName[4]);
                  country4 = setGold(country4, _gold[4]);
                  country4 = setSilver(country4, _silver[4]);
                  country4 = setBronze(country4, _bronze[4]);

                System.out.println(getNewCountry(country4) + " " + getGold(country4) + " " + getSilver(country4) + " " + getBronze(country4));

                  break;

                default:
                  System.out.println("default");
          }

          System.out.println("press any key to continue");
          input = scan.next().toLowerCase();
          stop = input.charAt(0);

          try 
          {
            FileWriter myWriter = new FileWriter("olympics.txt");

            System.out.println("\n\n\t\tFull list of countries and medals: \n");
            for(int i = 1; i < COUNTRIES; i++)
            {
              if(i == 1 && _countryName[i] == null)
              {
                Country _lithuania = setCountry("Lithuania", 0, 0, 0);
                printCountry(_lithuania);

              }
              else if(i == 2 && _countryName[i] == null)
              {
                Country _unitedKindom = setCountry("United Kingdom", 0, 0, 0);
                printCountry(_unitedKindom);
              }
              else if(i == 3 && _countryName[i] == null)
              {
                Country _latvia = setCountry("Latvia", 0, 0, 0);
                printCountry(_latvia);
              }
              else if(i == 4 && _countryName[i] == null)
              {
                Country _narniaCountry = setCountry("other countries", 0, 0, 0);
                printCountry(_narniaCountry);
              }
              else 
              {
               System.out.println(_countryName[i] + " has won: " + _gold[i] + ", " + _silver[i] + ", " + _bronze[i]);
               System.out.println("The " + _countryName[i] + " has won " + (_gold[i] + _silver[i] + _bronze[i]) + " medals in total");
               myWriter.write(_countryName[i] + " has won: " + _gold[i] + ", " + _silver[i] + ", " + _bronze[i]);
               myWriter.write("\nThe " + _countryName[i] + " has won " + (_gold[i] + _silver[i] + _bronze[i]) + " medals in total\n");
             }
           }
           System.out.println("\n\n\n");

           myWriter.write(" ");
           myWriter.close();
           System.out.println("Successfully wrote to the file.\n");
          }
          catch (IOException e) 
          {
          System.out.println("Something bad is going on");
          e.printStackTrace();
          }

        System.out.println("Do you want to save the data, quit and get sorting results by gold? Quit (y)?");
        finalInput = finalScan.nextLine().toLowerCase();
        quit = finalInput.charAt(0);

        if(quit == 'y')
        {
          selectionSortAlgorithm(_gold);
          System.out.println(Arrays.toString(_gold)); 
          printGoodbye();
      
          break;
        }
        else
        {
          continue;
        }
      }          
    }
  }

  public static class Country 
  {
    private String newCountry;
    private int gold;
    private int silver;
    private int bronze;
  }

  public static void selectionSortAlgorithm(int[] array) 
  { 
    for (int i = 0; i < array.length; i++) 
    {
        int max = array[i];
        int maxIndex = i;
        for (int j = i + 1; j < array.length; j++) 
        {
            if (array[j] > max) 
            {
                max = array[j];
                maxIndex = j;
            }
        }
        // swaps values
        int temp = array[i];
        array[i] = max;
        array[maxIndex] = temp;
    }
}

//*****************************************************
//  Define your abstract data type of the country with these operations:
//  + create your country - it can be anything from Narnia to Tomorrowland! (or use 3 predefined examples)
//  + Print the details of the country and give the total amount of the medals your country have won
//*****************************************************

//create your country and how many medals it has won
//GETTERS AND SETTERS
public static String getNewCountry(Country country)
{
  return country.newCountry;
}
public static Country setNewCountry(Country country, String newName)
{
  country.newCountry = newName;
  return country;
}
//******************************
public static int getGold(Country country)
{
  return country.gold;
}
public static Country setGold(Country country, int goldMedals)
{
  country.gold = goldMedals;
  return country;
}
//**************************
public static int getSilver(Country country)
{
  return country.silver;
}
public static Country setSilver(Country country, int silverMedals)
{
  country.silver = silverMedals;
  return country;
}
//************************
public static int getBronze(Country country)
{
  return country.bronze;
}
public static Country setBronze(Country country, int bronzeMedals)
{
  country.bronze = bronzeMedals;
  return country;
}

//to quickly create our ADT details 
  public static Country setCountry(String newName, int goldMedals, int silverMedals, int bronzeMedals) // parameters referenced - initialise method
  {
    Country country = new Country(); //new country created, we get it's medal count too
    country.newCountry = newName;
    country.gold = goldMedals; // given information from parameters are being referenced to each record value
    country.silver = silverMedals;
    country.bronze = bronzeMedals; //accessor methods

    return country;
  }

//Printing the details about the country
  public static void printCountry(Country country) 
  {
    System.out.println(country.newCountry + " has won: " + country.gold + ", " + country.silver + ", " + country.bronze);
    System.out.println("The " + country.newCountry + " has won " + (country.gold + country.silver + country.bronze) + " medals in total");
    return;
  }

  public static void printGreeting()
  {
    System.out.println("\n\n\n************************************************************");
    System.out.println("********Welcome to the Miliute's olympic games club!********");
    System.out.println("************************************************************");
    System.out.println("\n************************ RULES *****************************\n");
    System.out.println("1. Choose country number from the menu \n2. Enter how many gold/silver/bronze the country athletics won");
    System.out.println("\n\t\tLet's start the games club!\n ");
  }

  public static void printGoodbye()
  {
    System.out.println("\n\n\n************************************************************");
    System.out.println("*************************GOODBYE...*************************");
    System.out.println("************************************************************");
  }
} // END class lvl
