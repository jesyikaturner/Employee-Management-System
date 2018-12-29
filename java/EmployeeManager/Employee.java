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
    
    public String getID()
    {
        return id;
    }
    
    public char getRank()  
    {
        return rank;
    }
    
    public void setTile(String title)
    {
        this.title = title;
    }
    
    public void setRole(String role)
    {
        this.role = role;
    }
    
    public boolean updateRank(char rank)
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
    
    public double getSalary()
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
    
    public String printDetails()
    {
        return String.format("ID: %s, Name: %s %s, Role: %s, Pay: %.2f\n"
                                 ,id,title,name,role,getSalary());
    }
    
    public String toString(){
        return String.format("%s+%s+%s+%s+%c",id,title,name,role,rank);
    }
}