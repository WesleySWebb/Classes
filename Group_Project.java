package group_project;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Wesley
 */
public class Group_Project {
    
    public static int menu()
    {
        Scanner aScanner = new Scanner(System.in);
        System.out.println("Welcome. Please consider the following options");
        System.out.println( "1. Add Salaried Employee" + "\n" +
                            "2. Add Hourly Employee" + "\n" +
                            "3. Add Commissioned Employee" + "\n" +
                            "4. Print toString for all Employees" + "\n" +
                            "5. Find Employee" + "\n" +
                            "6. Delete Employee" + "\n" +
                            "7. QUIT" );
        System.out.print("Please choose an option: ");
        return aScanner.nextInt();
    }
    
    public static void createSalariedEmployee(ArrayList list)
    {
        Scanner aScanner = new Scanner(System.in);
        System.out.print("What is the name of the new employee? ");
        String name = aScanner.next();
        System.out.print("What is " + name + "'s employee ID? ");
        int empID = aScanner.nextInt();
        System.out.print("What is " + name + "'s base salary? ");
        double salary = aScanner.nextDouble();
        SalariedEmployee employee = new SalariedEmployee(name, empID, salary);
        list.add(employee);
    }    
    
    public static void createHourlyEmployee(ArrayList list)
    {
        Scanner aScanner = new Scanner(System.in);
        System.out.print("What is the name of the new employee? ");
        String name = aScanner.next();
        System.out.print("What is " + name + "'s employee ID? ");
        int empID = aScanner.nextInt();
        System.out.print("What is " + name + "'s hourly pay? ");
        double hourlyRate = aScanner.nextDouble();
        System.out.print("how many hours did "+ name + " work this week? ");
        double hoursWorked = aScanner.nextDouble();
        HourlyEmployee employee = new HourlyEmployee(name, empID, hourlyRate, hoursWorked);
        list.add(employee);
    }  
    
    public static void createCommissionedEmployee(ArrayList list)
    {
        Scanner aScanner = new Scanner(System.in);
        System.out.print("What is the name of the new employee? ");
        String name = aScanner.next();
        System.out.print("What is " + name + "'s employee ID? ");
        int empID = aScanner.nextInt();
        System.out.print("What is " + name + "'s base pay? ");
        double basePay = aScanner.nextDouble();
        System.out.print("How much is the value that "+ name + " sold this week? " );
        double weeklySales = aScanner.nextDouble();
        System.out.print("What is "+ name + "'s commission rate? ");
        double commissionRate = aScanner.nextDouble();
        CommissionedEmployee employee = new CommissionedEmployee(name, empID, basePay, weeklySales, commissionRate);
        list.add(employee);
    }  
    
    public static void printAllEmployeeInfo(ArrayList list)
    {
        for(int x = 0; x<list.size();x++)
        {
            System.out.println(list.get(x).toString());
        }
    }
    
    public static void findEmployee(ArrayList list)
    {
        Scanner aScanner = new Scanner(System.in);
        System.out.print("Who are you looking for? ");
        String name = aScanner.next();
        boolean isFound = false;
        for(int x = 0;x < list.size();x++)
        {
            if(list.get(x) instanceof SalariedEmployee)
            {
                SalariedEmployee employee = (SalariedEmployee)list.get(x);
                if(employee.getName().equals(name))
                {
                    isFound = true;
                    System.out.print(list.get(x).toString());
                }
            }
            else if(list.get(x) instanceof HourlyEmployee)
            {
                HourlyEmployee employee = (HourlyEmployee)list.get(x);
                if(employee.getName().equals(name))
                {
                    isFound = true;
                    System.out.print(list.get(x).toString());
                }
            }
            else if(list.get(x) instanceof CommissionedEmployee)
            {
                CommissionedEmployee employee = (CommissionedEmployee)list.get(x);
                if(employee.getName().equals(name))
                {
                    isFound = true;
                    System.out.print(list.get(x).toString());
                }
            }
        }
        if(!isFound)
            System.out.println("Employee not found.");
    }
    
    public static void deleteEmployee(ArrayList list)
    {
        ArrayList<Integer> possibilities = new ArrayList<Integer>(); // In case of multiple Employees of the same name
        Scanner aScanner = new Scanner(System.in);
        System.out.print("Who do you wish to delete from the system? ");
        String name = aScanner.next();
        boolean isFound = false;
        for(int x = 0;x < list.size();x++)
        {
            if(list.get(x) instanceof SalariedEmployee)
            {
                SalariedEmployee employee = (SalariedEmployee)list.get(x);
                if(employee.getName().equals(name))
                {
                    isFound = true;
                    list.remove(x);
                    System.out.print("Employee removed");
                }
            }
            else if(list.get(x) instanceof HourlyEmployee)
            {
                HourlyEmployee employee = (HourlyEmployee)list.get(x);
                if(employee.getName().equals(name))
                {
                    isFound = true;
                    list.remove(x);
                    System.out.print("Employee removed");
                }
            }
            else if(list.get(x) instanceof CommissionedEmployee)
            {
                CommissionedEmployee employee = (CommissionedEmployee)list.get(x);
                if(employee.getName().equals(name))
                {
                    isFound = true;
                    list.remove(x);
                    System.out.print("Employee removed");
                }
            }
        }
        if(!isFound)
        {
            System.out.println("Employee not found.");
        }
    }
    public static void main(String[] args) 
    {
        ArrayList<Employee> list = new ArrayList<Employee>();
        int choice;
        do
        {
            System.out.println("");
            choice = menu();
            System.out.println("");
            if(choice == 1)
            {
                createSalariedEmployee(list);
            }
            else if(choice == 2)
            {
                createHourlyEmployee(list);
            }
            else if(choice == 3)
            {
                createCommissionedEmployee(list);
            }
            else if(choice == 4)
            {
                printAllEmployeeInfo(list);
            }
            else if(choice == 5)
            {
                findEmployee(list);
            }
            else if(choice == 6)
            {
                deleteEmployee(list);
            }
        }while(choice != 7);
        System.out.print("Thank you.");
    }
    
}
