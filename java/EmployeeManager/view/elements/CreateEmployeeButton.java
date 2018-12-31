package view.elements;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AppFrame; 

public class CreateEmployeeButton extends JButton implements ActionListener
{
    private AppFrame app;
    
    public CreateEmployeeButton(AppFrame app)
    {
        this.app = app;
        addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        app.ChangeView("create");
    }
}