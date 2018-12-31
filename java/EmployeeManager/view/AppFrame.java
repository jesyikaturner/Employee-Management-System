package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.EmployeeManagement;
import view.CreateEmployeeForm;
import view.MenuPanel;

public class AppFrame extends JFrame
{
    private EmployeeManagement em;
    
    private MenuPanel menu;
    private CreateEmployeeForm employeeForm;
    
    public AppFrame()
    {
        super("Employee Management");
        setBounds(100, 100, 640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void Setup(EmployeeManagement em)
    {
        this.em = em;
        menu = new MenuPanel(this);
        employeeForm = new CreateEmployeeForm(this,em);
        
        setLayout(new BorderLayout());
        ChangeView("menu");
        
        //Refresh();
    }
    
    public void ChangeView(String viewID)
    {
        switch(viewID)
        {
            case "menu":
                remove(employeeForm);
                add(menu,BorderLayout.CENTER);
                Refresh();
                break;
            case "create":
                remove(menu);
                add(employeeForm,BorderLayout.CENTER);
                Refresh();
                break;
                
            default:
                System.out.println("Error! You did not select a valid option!"
                                       +"Please try again.\n\n");
                break;
        }
    }
    
    private void Refresh()
    {
        revalidate();
        repaint();
    }
}