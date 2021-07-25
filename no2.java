/* ****************************************************
AUTHOR Gabija Miliute
01/15/2021 Exercise No2
The program below contains
    - Screen Input, Keyboard Input
    - Method calls, and methods that take arguments
    - Variables, assignments and expressions
    - loops
    - decision statements
    - method that takes array arguments
    - accessors and mutators
    - ADT
 
This procedural program
******************************************************** */
import java.util.Scanner; // Imports the some packages for specific commands
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;
 import java.util.ArrayList;
 
public class no2
{
    public static void main (String args[]) // extremely simplified main function
    {
        char stop = 'n', quit = 'n';
        String input, finalInput;
    //int choice = 0,
        int n = 32, allowance = 0;
 
    final int DAYS = 32; //leaving 0th value out, for less confusion
    int [] _dayNumber = new int [DAYS];
    int [] _first = new int [DAYS]; //array for storing 5 values about names
    int [] _second = new int [DAYS];
    int [] _third = new int [DAYS];
    FlowArray flowArr = new FlowArray();
   
    Scanner _flowScan = new Scanner(System.in);
    Scanner _firstScan = new Scanner(System.in);
    Scanner _secondScan = new Scanner(System.in);
    Scanner _thirdScan = new Scanner(System.in);
    Scanner scan = new Scanner(System.in);
    Scanner finalScan = new Scanner(System.in);
 
    printGreeting();
    fileSave();
    allowance = inputDoctor();
 
    for(int i = 1; i < n; i++)
    {
        System.out.println("How is the day number called? Enter 32 if you wish to skip the day, enter 0 to quit");
        _dayNumber[i] = _flowScan.nextInt();
        if (_dayNumber[i] == 32)
        {
            continue;
        }
        else if(_dayNumber[i] == 0)
        {
            break;
        }
        else
        {
            System.out.println("What what the first entry of the day" + _dayNumber[i] + "?");
            _first[i] = _firstScan.nextInt();
            if(_first[i] < allowance)
            {
                System.out.println("WARNING: go to hospital immediately!");
            }
            else{}
 
                System.out.println("What what the second entry of the day" + _dayNumber[i] + "?");
            _second[i] = _secondScan.nextInt();
            if(_second[i] < allowance)
            {
                System.out.println("WARNING: go to hospital immediately!");
            }
            else{}
 
                System.out.println("What what the third entry of the day" + _dayNumber[i] + "?");
            _third[i] = _thirdScan.nextInt();
            if(_third[i] < allowance)
            {
                System.out.println("WARNING: go to hospital immediately!");
            }
            else
            {
 
            }
 
            Flow flow4 = new Flow();
            flow4 = setday(flow4, _dayNumber[4]);
            flow4 = setfirst(flow4, _first[4]);
            flow4 = setsecond(flow4, _second[4]);
            flow4 = setthird(flow4, _third[4]);
            flowArr = addToFlowArray(flowArr, flow4);
           
 
            System.out.println(getday(flow4) + " " + getfirst(flow4) + " " + getsecond(flow4) + " " + getthird(flow4));
        }
 
        System.out.println("press any key to continue");
        input = scan.next().toLowerCase();
        stop = input.charAt(0);
          
          if(quit == 'y')
          {
              selectionSortAlgorithm(flowArr);
              System.out.println(Arrays.toString(_first));
              printGoodbye();
 
              break;
          }
          else
          {
              continue;
          }
      }          
  }
 
 
public static int inputDoctor()  
{
    int allowance = 0;
    boolean flag = false;
    Scanner _doctorAllowanceScan = new Scanner(System.in);
 
    System.out.println("What number did the doctor gave you (in range of the 0-800?");
    allowance = _doctorAllowanceScan.nextInt();
 
    while(flag == false)
    {
        if(allowance < 0) //validation for a positive input
        {  
            System.out.println("It can't be a negative number, try again: ");
            allowance = _doctorAllowanceScan.nextInt();
            flag = false;
        }
        else if(allowance > 800)
        {
            System.out.println("It can't be outside the range, try again: ");
            allowance = _doctorAllowanceScan.nextInt();
            flag = false;
        }
        else
        {
            flag = true;
        }
    }
    return allowance;
} // END inputDoctor
 
public static void fileSave()
{
    try
    {
      File myObj = new File("flow.csv");
      if (myObj.createNewFile())
      {
        System.out.println("File is being created: " + myObj.getName());
    }
    else
    {
      System.out.println("File already exists.");
 
      FileReader reader = new FileReader("flow.csv");
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
return;
}
 
public static class Flow
{
    private int day;
    private int first;
    private int second;
    private int third;
}
 public static class FlowArray
{
    private List<Flow> flows = new ArrayList<Flow>();
}
 
public static void selectionSortAlgorithm(FlowArray flowArr)
{
    for (int i = 0; i < getFlowArraySize(flowArr); i++)
    {
        Flow max =  getFlowArrayI(i,flowArr);
        int maxIndex = i;
        for (int j = i + 1; j < getFlowArraySize(flowArr); j++)
        {
            if ( getFlowArrayI(j,flowArr).day > max.day)
            {
                max = getFlowArrayI(j,flowArr);
                maxIndex = j;
            }
        }
        // swaps values
        Flow temp = getFlowArrayI(i,flowArr);
       
        setFlowArrayI(i,max, flowArr);
        setFlowArrayI(maxIndex, temp, flowArr);
       
    }
}
 
//ADT
//GETTERS AND SETTERS
public static int getday(Flow flow)
{
  return flow.day;
}
public static Flow setday(Flow flow, int newDay)
{
  flow.day = newDay;
  return flow;
}
//******************************
public static int getfirst(Flow flow)
{
  return flow.first;
}
public static Flow setfirst(Flow flow, int firstEntry)
{
  flow.first = firstEntry;
  return flow;
}
//**************************
public static int getsecond(Flow flow)
{
  return flow.second;
}
public static Flow setsecond(Flow flow, int secondEntry)
{
  flow.second = secondEntry;
  return flow;
}
//************************
public static int getthird(Flow flow)
{
  return flow.third;
}
public static Flow setthird(Flow flow, int thirdEntry)
{
  flow.third = thirdEntry;
  return flow;
}
 
public static Flow getFlowArrayI(int i, FlowArray flowArr){
  return flowArr.flows.get(i);
}
public static FlowArray setFlowArrayI(int i, Flow element, FlowArray flowArr){
  flowArr.flows.set(i, element);
  return flowArr;
}
public static int getFlowArraySize(FlowArray flowArr){
  return flowArr.flows.size();
}
 
public static FlowArray addToFlowArray(FlowArray flowArr, Flow elementFlow){
  flowArr.flows.add(elementFlow);
  return flowArr;
}
 
//to quickly create our ADT details
public static Flow setflow(int newDay, int firstEntry, int secondEntry, int thirdEntry) // parameters referenced - initialise method
{
    Flow flow = new Flow();
    flow.day = newDay;
    flow.first = firstEntry; // given information from parameters are being referenced to each record value
    flow.second = secondEntry;
    flow.third = thirdEntry; //accessor methods
 
    return flow;
}
 
//Printing the details about the flow
public static void printflow(Flow flow)
{
    System.out.println(flow.day + ", " + flow.first + ", " + flow.second + ", " + flow.third);
    return;
}
 
public static void printGreeting()
{
    System.out.println("\n\n\n************************************************************");
    System.out.println("*********************Peak flow calculator*************************");
    System.out.println("******************************************************************");
    System.out.println("\n************************INSTRUCTION*****************************\n");
    System.out.println("1. Enter the lung capacity number from the doctor (range 0-800) \n2. Enter the day number and 3 recordings of the peak flow lung capacity");
}
 
public static void printGoodbye()
{
    System.out.println("\n\n\n************************************************************");
    System.out.println("*************************Saving...********************************");
    System.out.println("******************************************************************");
}
} // END class no2
 