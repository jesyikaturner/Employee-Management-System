package view;

import java.util.*;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.EmployeeManagement;
import view.controller.SubmitFormButton;
import view.elements.MenuButton;

public class CreateEmployeeForm extends JPanel
{
    private final int size = 5;
    
    private EmployeeManagement em;
    private JTextField[] inputs;
    private String[] data;
    
    public CreateEmployeeForm(AppFrame app, EmployeeManagement em)
    {
        this.em = em;
        data = new String[size];
        inputs = new JTextField[size];
        for(int i = 0; i < size; i++)
        {
            JTextField text = new JTextField("",12);
            inputs[i] = text;
        }

        setLayout(new GridLayout(0,2));
        
        add(new JLabel("Enter Employee ID: "));
        add(inputs[0]);
        add(new JLabel("Enter Employee Title: "));
        add(inputs[1]);
        add(new JLabel("Enter Employee Name:  "));
        add(inputs[2]);
        add(new JLabel("Enter Employee Role: "));
        add(inputs[3]);
        add(new JLabel("Enter Employee Rank (A/B/C/D/E): "));
        add(inputs[4]); 
        
        SubmitFormButton submitButton = new SubmitFormButton(em, this);
        add(submitButton);
        add(new MenuButton(app, "Back", "menu"));
    }
    
    public String[] GetData()
    {
        for(int i = 0; i < size; i++)
        {
            data[i] = inputs[i].getText();
        }
        return data;
    }
}