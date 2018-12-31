package model;

import java.io.*;
import java.util.*;

public class EmployeeManagement
{
    private ArrayList<Employee> employees;
    
    public EmployeeManagement(){
        employees = new ArrayList<Employee>();
        
        // load employees if file exists
        // TODO
    }
    
    /*
     * First searches to see if an employee with the ID already exists, fails if ID is already found.
     * Creates a new Employee object and adds it to the employee arraylist.
     */ 
    public Boolean addNewEmployee(String id, String title, String name, String role, char rank)
    {
        Employee e = searchEmployees(id);
        if(e != null)
            return false;
        
        employees.add(new Employee(id,title,name,role,rank));
        return true;
    }
    
    /*
     * Prints all employee details that are in the employee arraylist.
     */ 
    private void displayEmployee()
    {
        for(Employee employee : employees)
        {
            System.out.printf(employee.PrintDetails());
        }
    }
    
    /*
     * Searches through the employee arraylist for an employee with the
     * matching id, if found returns that employee otherwise returns null
     */
    private Employee searchEmployees(String id)
    {
        for(Employee employee : employees)
        {
            if(employee.GetID().equals(id)){
                return employee;
            }
        }
        return null;
    }
    
    private Boolean UpdateEmployeeDetails(String id, String[] details)
    {
        if(details.length != 4)
            return false;
        
        Employee e = searchEmployees(id);
        if(e == null)
            return false;
        
        e.SetDetails(details[0],details[1],details[2],details[3].charAt(0));
        return true;
    }
    
    public void saveEmployeeArray()
    {
        ArrayList<String> details = new ArrayList<String>();
        for(Employee employee : employees)
        {
            details.add(employee.ToString());
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