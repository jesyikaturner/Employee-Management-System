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
        setLayout(new BorderLayout());
        add(new CreateEmployeeForm(em),BorderLayout.CENTER);
        
        Refresh();
    }
    
    public void ChangeView(String viewID)
    {
        switch(viewID)
        {
            case "menu":
                add(new MenuPanel(),BorderLayout.CENTER);
                break;
            case "create":
                add(new CreateEmployeeForm(em),BorderLayout.CENTER);
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