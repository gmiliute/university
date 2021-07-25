/* ******************************************************************************************************
AUTHOR Gabija Miliute

03/2021 Miniproject: A business software dashboard simulation

The program below contains
    - Screen Input, Keyboard Input
    - Method calls, and methods that take arguments
    - Variables, assignments and expressions
    - loops
    - decision statements
    - accessors and mutators


This OOP application aims to display common key performance indicators such as
conversion rate, gross profit margin, customer acquisition price, average order price and other metrics related to it
******************************************************************************************************* */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char stop = 'n', quit = 'n';
        String input, finalInput;
        int entry = 0, n = 2; // dashboard works with 3 entries

        final int ENTRIES = 3;
        String _entryNameT;
        int _revenueT;
        int _costsT;
        int _websiteT;
        int _marketingT;
        int _customerT;

        Scanner _entriesScan = new Scanner(System.in);

        printGreeting();

        for (int k = 0; k < n; k++) {
            while (stop != 'y') {
                System.out.println("Please choose an entry: \n1. Weekly \n2. Monthly \n3. Create new");
                entry = _entriesScan.nextInt();  //choose menu number

                switch (entry)  // puts all the entries to the i position of the arrays declared above,
                // later it is used to distinguish between different menu entries and create KPI
                {
                    case 1:

                        System.out.println("What was the revenue for a weekly period?");
                        _revenueT = _entriesScan.nextInt();

                        System.out.println("What were the manufacturing costs for this weekly period?");
                        _costsT = _entriesScan.nextInt();

                        System.out.println("What were the marketing costs for this weekly period?");
                        _marketingT = _entriesScan.nextInt();

                        System.out.println("What were the website visits for this weekly period?");
                        _websiteT = _entriesScan.nextInt();

                        System.out.println("How many customers bought something in this weekly period?");
                        _customerT = _entriesScan.nextInt();

                        _entryNameT = "Weekly period";

                        Sales weekly = new Sales(_revenueT, _costsT);
                        System.out.println(weekly.getCosts());

                        Marketing weeklyEntries = new Marketing(_websiteT, _marketingT, _customerT);
                        System.out.println(weeklyEntries);

                        break;

                    case 2:

                        System.out.println("What was the revenue for a monthly period?");
                        _revenueT = _entriesScan.nextInt();

                        System.out.println("What were the manufacturing costs for this monthly period?");
                        _costsT = _entriesScan.nextInt();

                        System.out.println("What were the marketing costs for this monthly period?");
                        _marketingT = _entriesScan.nextInt();

                        System.out.println("What were the website visits for this monthly period?");
                        _websiteT = _entriesScan.nextInt();

                        System.out.println("How many customers bought something in this monthly period?");
                        _customerT = _entriesScan.nextInt();

                        _entryNameT = "Monthly period";

                        Sales monthly = new Sales(_revenueT, _costsT);
                        System.out.println(monthly);

                        Marketing monthlyEntries = new Marketing(_websiteT, _marketingT, _customerT);
                        System.out.println(monthlyEntries);

                        break;

                    case 3:

                        System.out.println("How is your defined period called?");
                        _entryNameT = _entriesScan.next();

                        System.out.println("What was the revenue for " + _entryNameT + " period?");
                        _revenueT = _entriesScan.nextInt();

                        System.out.println("What were the manufacturing costs for " + _entryNameT + " period?");
                        _costsT = _entriesScan.nextInt();

                        System.out.println("What were the marketing costs for " + _entryNameT + " period?");
                        _marketingT = _entriesScan.nextInt();

                        System.out.println("What were the website visits for " + _entryNameT + " period?");
                        _websiteT = _entriesScan.nextInt();

                        System.out.println("How many customers bought something in " + _entryNameT + " period?");
                        _customerT = _entriesScan.nextInt();

                        Sales defined = new Sales(_revenueT, _costsT);
                        System.out.println(defined);

                        Marketing definedEntries = new Marketing(_websiteT, _marketingT, _customerT);
                        System.out.println(definedEntries);

                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + entry);
                }

                System.out.println("quit (y)?");
                input = _entriesScan.next().toLowerCase();
                stop = input.charAt(0);   // stops the menu

                System.out.println("\n\n\t\tFull list of Key Performance Metrics: \n");

                for (int i = 0; i < ENTRIES; i++) {
                    if (i == 0 && _entryNameT == null) {
                        Sales _weekly = setSales(0, 0);
                        printSales(_weekly);

                    } else if (i == 1 && _entryNameT == null) {
                        Sales _monthly = setSales(0, 0);
                        printSales(_monthly);
                    } else if (i == 2 && _entryNameT == null) {
                        Sales _defined = setSales(0, 0);
                        printSales(_defined);
                    } else {
                        System.out.println(_entryNameT + " period entries are: " + _revenueT + ", " +  _costsT + ", " +
                                _websiteT + ", " +  _marketingT + ", " +  _customerT);
                        Sales salesRevKPI = new Revenue(_revenueT, _costsT); //dynamic binding
                        double var =   ((Revenue) salesRevKPI).returnOfInvestment(_revenueT, _costsT);
                        System.out.println(var);

                        Sales salesCostKPI = new Costs(_costsT, _revenueT);//dynamic binding
                        var =  ((Costs) salesCostKPI).grossProfit(_revenueT, _costsT);
                        System.out.println(var);

                        Marketing marketingCustomerKPI = new Customers(_websiteT, _marketingT, _customerT);
                         var =  ((Customers) marketingCustomerKPI).averageOrderPrice(_revenueT, _customerT);
                        System.out.println(var);

                        Marketing marketingPerformanceKPI = new Performance(_websiteT, _marketingT, _customerT);
                         var = ((Performance) marketingPerformanceKPI).customerAcquisitionPrice(_costsT, _customerT);
                        System.out.println(var);

                        //at this point this space can be used for saving details to the text file
                        //myWriter.write(_entryName[i]...
                        //myWriter.write("Some more details..
                    }
                }
            }
        }
        printGoodbye();
    }

    public static Sales setSales(int _revenue, int _costs)
    {
        Sales sales = new Sales(_revenue, _costs);
        sales.setRevenue(_revenue);
        sales.setCosts(_costs);

        return sales;
    }

    public static void printSales(Sales sales)
    {
        System.out.println(sales.getRevenue() + ", " + sales.getCosts());
    }

    public Marketing setMarketing(int _websiteVisits, int _marketingCosts, int _customers)
    {
        Marketing marketing = new Marketing(_websiteVisits, _marketingCosts, _customers);
        marketing.setWebsiteVisits(_websiteVisits);
        marketing.setMarketingCosts(_marketingCosts);
        marketing.setCustomers(_customers);

        return marketing;
    }

    public static void printMarketing(Marketing marketing)
    {
        System.out.println(marketing.getWebsiteVisits() + ", " + marketing.getMarketingCosts() + ", " + marketing.getCustomers());
    }

    public static void printGreeting()
    {
        System.out.println("\n\n\n************************************************************");
        System.out.println("********Welcome to the Key Performance Indicator Dashboard!********");
        System.out.println("************************************************************");
        System.out.println("\n************************ OPTIONS *****************************\n");
        System.out.println("1. Choose predefined entry or name your own \n2. Enter the related entries to get the KPI list");
        //System.out.println("Sort the entries by input or save it to an external txt file");
    }

    public static void printGoodbye()
    {
        System.out.println("\n\n\n*******************************************************");
        System.out.println("*************************GOODBYE...******************");
        System.out.println("***************************************************");
    }
}


