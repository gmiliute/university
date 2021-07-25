/* ******************************************************************************************************
AUTHOR Gabija Miliute
11/25/2020 EXIT TEST
The program below contains
    - multiple loops
    - if statement 
    - arrays
    - multiple methods 
This program gives information about the allergies
******************************************************************************************************* */
import java.util.Scanner; // Imports some packages for specific commands
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;

public class ex
{
    public static void main (String args[]) // extremely simplified main function
    {
        allergyInformation();
        System.exit(0);
    } // END main

public static void allergyInformation() // runs loop at least 10 times to obtain information from the user
{
    final int ALLERGIES = 10; //for all allergy types there
    String [] _allergyName = new String [ALLERGIES];
    int [] _meds = new int [ALLERGIES];
    int [] _rating = new int [ALLERGIES];
    int sum = 0, choice = 0;

    Scanner _allergyScan = new Scanner(System.in);
    Scanner _medsScan = new Scanner(System.in);
    Scanner _ratingScan = new Scanner(System.in);
    Scanner scan = new Scanner(System.in);

    for(int i = 0; i < ALLERGIES; i++)
    {
        System.out.println("Please choose an allergy number: \n1. cats \n2. dust \n3. nuts \n\n"); //short menu appears
        choice = scan.nextInt();   

        switch(choice) // an user choose his allergy type
        {
            case 1:

                System.out.println("How many medications for cat allergy you took?");
                _meds[i] = _medsScan.nextInt();

                System.out.println("How you would rate your day?");
                _rating[i] = _ratingScan.nextInt();

                _allergyName[i] = "cats";

                Allergy _newCats = createAllergy(_allergyName[i], _meds[i], _rating[i]); //cat allergy entry is created
                    break;

            case 2:
                System.out.println("How many medications for dust allergy you took?");
                _meds[i] = _medsScan.nextInt();

                System.out.println("How you would rate your day?");
                _rating[i] = _ratingScan.nextInt();

                _allergyName[i] = "dust";

                Allergy _newDust = createAllergy(_allergyName[i], _meds[i], _rating[i]); //dust allergy entry is created
                //printAllergy(_dust);
                    break;

            case 3:
                System.out.println("How many medications for dust allergy you took?");
                _meds[i] = _medsScan.nextInt();

                System.out.println("How you would rate your day?");
                _rating[i] = _ratingScan.nextInt();

                _allergyName[i] = "nuts";

                Allergy _newNuts = createAllergy(_allergyName[i], _meds[i], _rating[i]); //nuts allergy entry is created
                //printAllergy(_newNuts);
                    break;

            default:
            System.out.println("It's not one of the options!");
        }

         sum = IntStream.of(_meds).sum();

         if(sum > 60)
         {
             break;
        }
        else 
        {
             continue;
        }

    }
 System.out.println(Arrays.toString(_allergyName)); //strems take care of printing, a beautiful print was not implemented
 System.out.println(Arrays.toString(_meds));
 System.out.println(Arrays.toString(_rating));
}

public static class Allergy //for storing alergies details
{
    String cause;
    int meds;
    int rating;
}

public static Allergy createAllergy(String allergyName, int medsTaken, int dayRating) // parameters referenced - initialise method
{
    Allergy allergy = new Allergy(); // new alergy created
    allergy.cause = allergyName;
    allergy.meds = medsTaken; // given information from parameters are being referenced to each record value
    allergy.rating = dayRating;

    return allergy;
}
/*
public static void printAllergy(Allergy allergy)  // adt operation for printing details
{
    System.out.println( allergy.meds + " " +  allergy.cause + " " +  allergy.rating);
    return;
}
*/
} // END class ex