package view;

import java.awt.GridLayout;
import javax.swing.JPanel;

import view.elements.MenuButton;

public class MenuPanel extends JPanel
{
    public MenuPanel(AppFrame app)
    {
        setLayout(new GridLayout(0,1));
        add(new MenuButton(app, "Add New Employee", "create"));
        add(new MenuButton(app, "Display Employee Summary", "display"));
        add(new MenuButton(app, "Update Employee Details", "details"));
    }
    
}