package model;

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
    
    public Boolean addNewEmployee(String id, String title, String name, String role, char rank)
    {
        Employee e = searchEmployees(id);
        if(e != null)
            return false;
        
        employees.add(new Employee(id,title,name,role,rank));
        return true;
    }
    
    private void displayEmployee()
    {
        for(Employee employee : employees)
        {
            System.out.printf(employee.PrintDetails());
        }
    }
    
    // search through employees for matching id
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
    
    private Boolean updateEmployeeTitle(String id, String title)
    {
        Employee e = searchEmployees(id);
        if(e == null)
            return false;
        
        e.SetTile(title);
        return true;
    }
    
    private void updateRankAndRole()
    {
        //TODO
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