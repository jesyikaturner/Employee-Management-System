package model;

public class Employee
{
    private String id, title, name, role;
    private char rank;
    
    public Employee(String id, String title, String name, String role, char rank)
    {
        this.id = id;
        this.title = title;
        this.name = name;
        this.role = role;
        this.rank = Character.toUpperCase(rank);
    }
    
    public String GetID()
    {
        return id;
    }
    
    public char GetRank()  
    {
        return rank;
    }
    
    public void SetTile(String title)
    {
        this.title = title;
    }
    
    public void SetRole(String role)
    {
        this.role = role;
    }
    
    public boolean UpdateRank(char rank)
    {
        String acceptedRanks = "ABCDE";
        for (int i = 0; i < acceptedRanks.length(); i++)
        {
            if(acceptedRanks.charAt(i) == Character.toUpperCase(rank))
            {
                this.rank = Character.toUpperCase(rank);
                return true;
            }
        }
        
        System.out.println("Invalid Character. Please try again.");
        return false;
    }
    
    public double GetSalary()
    {
        double salary = 0;
        switch(rank)
        {
            case 'A':
                salary = 40000;
                break;
            case 'B':
                salary = 45000;
                break;
            case 'C':
                salary = 55000;
                break;
            case 'D':
                salary = 65000;
                break;
            case 'E':
                salary = 75000;
            default:
                return salary;
        }
        return salary;
    }
    
    public String PrintDetails()
    {
        return String.format("ID: %s, Name: %s %s, Role: %s, Pay: %.2f\n"
                                 ,id,title,name,role,GetSalary());
    }
    
    public String ToString(){
        return String.format("%s+%s+%s+%s+%c",id,title,name,role,rank);
    }
}