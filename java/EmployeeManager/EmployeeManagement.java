import java.io.*;
import java.util.*;

public class EmployeeManagement
{
    private Scanner s = new Scanner(System.in);
    private ArrayList<Employee> employees;
    
    public EmployeeManagement(){
        employees = new ArrayList<Employee>();
        // load employees if file exists
    }
    
    // Test
    public void generateEmployees()
    {
        employees.add(new Employee("001","Mr","Robot","Programmer",'A'));
        employees.add(new Employee("002","Mrs","Plum","CEO",'E'));
        employees.add(new Employee("003","Ms","Opal","Developer",'B'));
        employees.add(new Employee("004","Dr","Hyde","Mad Scientist",'D'));
        employees.add(new Employee("005","Mrs","Potts","The Best Damn Pot",'E'));
    }
    
    public void handleMenu()
    {
        String input;
        char option = ' ';
        
        do 
        {
            System.out.printf("\n\n** Employee Management System Menu **\n\n"
                                  +"\tA. Add New Employee\n"
                                  +"\tB. Display Employee Summary\n"
                                  +"\tC. Update Employee Title\n"
                                  +"\tD. Update Employee Pay Scale Level / Role\n"
                                  +"\tX. Exit\n");
            System.out.printf("\nEnter your selection: ");
            input = s.nextLine();
            
            if(input.length() == 1)
            {
                option = input.charAt(0);
                option = Character.toUpperCase(option);
                
                switch(option)
                {
                    case 'A':
                        addNewEmployee();
                        break;
                    case 'B':
                        displayEmployee();
                        break;
                    case 'C':
                        updateEmployeeTitle();
                        break;
                    case 'D':
                        updateRankAndRole();
                        break;
                    case 'X':
                        System.out.printf("User exited the program\n\n");
                        break;
                    default:
                        System.out.printf("Error! %c isn't valid\n\n",option);
                        
                }
            }else
            {
                System.out.println("Error! You did not select a valid option!"
                                       +"Please try again.\n\n");
            }

        }while(option != 'X');
        
        // saves employees
        saveEmployeeArray();
    }
    
    private void addNewEmployee()
    {
        //TODO
    }
    private void displayEmployee()
    {
        for(Employee employee : employees)
        {
            System.out.printf(employee.printDetails());
        }
    }
    
    // search through employees for matching id
    private Employee searchEmployees(String id)
    {
        for(Employee employee : employees)
        {
            if(employee.getID().equals(id)){
                return employee;
            }
        }
        return null;
    }
    
    private void updateEmployeeTitle()
    {
        //TODO
    }
    
    private void updateRankAndRole()
    {
        //TODO
    }
    
    private void saveEmployeeArray()
    {
        ArrayList<String> details = new ArrayList<String>();
        for(Employee employee : employees)
        {
            details.add(employee.toString());
        }
        
        saveArrayToFile("employee",".dat",details);
    }
    
    private void saveArrayToFile(String name, String suffix, ArrayList array)
    {
        try
        {
            Writer fileWriter = new FileWriter(name+suffix);
            for(Object obj : array){
                fileWriter.write(obj+"\n");
            }
            
            fileWriter.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}