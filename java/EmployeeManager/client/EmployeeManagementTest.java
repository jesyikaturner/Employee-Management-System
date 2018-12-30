package client;

import model.EmployeeManagement;
import view.AppFrame;

public class EmployeeManagementTest
{
    public static void main(String[] args) {
        final EmployeeManagement em = new EmployeeManagement();
        
        AppFrame mainFrame = new AppFrame();
        
        mainFrame.Setup(em);
    }
}