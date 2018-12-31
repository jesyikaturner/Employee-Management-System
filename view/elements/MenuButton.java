package view.elements;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AppFrame; 

public class MenuButton extends JButton implements ActionListener
{
    private AppFrame app;
    private String location;
    
    public MenuButton(AppFrame app, String text, String location)
    {
        this.app = app;
        this.location = location;
        setText(text);
        
        addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        app.ChangeView(location);
    }
    
}