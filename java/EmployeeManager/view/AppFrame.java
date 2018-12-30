package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.EmployeeManagement;
import view.controller.InputTextFields;

public class AppFrame extends JFrame
{
    public AppFrame()
    {
        super("Employee Management");
        setBounds(100, 100, 640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void Setup(EmployeeManagement em)
    {
          setLayout(new BorderLayout());
          add(new InputTextFields(em));
        
        Refresh();
    }
    
    private void Refresh()
    {
        revalidate();
        repaint();
    }
}