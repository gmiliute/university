/* ******************************************************************************************************
AUTHOR Gabija Miliute
11/02/2020 Short Exercise 6
The program below contains
    - while loop
    - try - catch exceptions
This program gives information about the passengers and buses they travelled on
******************************************************************************************************* */
import java.util.Scanner; // Imports the some packages for scanning

public class Buses
{
    public static void main (String args[]) { // extremely simplified main function
        busesInformation();
        System.exit(0);
    } // END main

    public static void busesInformation() //this method works until special value is entered
    {
        int sum = 0, count = 0; 
        Scanner passengerScan = new Scanner(System.in);
        while(true)
        {
            System.out.println("How many passengers were on the bus?");
            try {

                    int passengers = Integer.parseInt(passengerScan.nextLine());
                    sum += passengers;
                    count += 1; 
                
            }
            catch(NumberFormatException x) {
                break;  
            }   
        } 

        System.out.println("There were a total of " + sum + " passengers on " + count + " buses.");
        return;
    }//END busesInformation
} // END class Buses