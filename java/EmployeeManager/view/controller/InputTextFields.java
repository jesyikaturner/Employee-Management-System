package view.controller;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.EmployeeManagement;

public class InputTextFields extends JPanel implements ActionListener 
{
    private EmployeeManagement em;
    private JTextField inputID, inputTitle, inputName, inputRole, inputRank;
    
    public InputTextFields(EmployeeManagement em)
    {
        this.em = em;
        
        setLayout(new FlowLayout());
        inputID = new JTextField("",12);
        inputTitle = new JTextField("",12);
        inputName = new JTextField("",12);
        inputRole = new JTextField("",12);
        inputRank = new JTextField("",12);
        add(inputID);
        add(inputTitle);
        add(inputName);
        add(inputRole);
        add(inputRank);
        /*SetLabel(this, "Enter Employee ID: ", inputID);
        SetLabel(this, "Enter Employee Title: ", inputTitle);
        SetLabel(this, "Enter Employee Name: ", inputName);
        SetLabel(this, "Enter Employee Role: ", inputRole);
        SetLabel(this, "Enter Employee Rank (A/B/C/D/E): ", inputRank);*/
        
        JButton submitButton = new JButton("Submit");
        submitButton.setSize(50, 20);
        submitButton.addActionListener(this);
        add(submitButton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(!CheckLength(inputID)||!CheckLength(inputTitle)||!CheckLength(inputName)
                   ||!CheckLength(inputRole)||!CheckLength(inputRank))
            {
                System.out.println("Something went wrong with the textfields");
                return;
            }
        }catch(NullPointerException i) {
            System.out.println("One of the textfields is either empty or something fucked up.");
            return;
        }
        
        if(inputRank.getText().length() > 1)
        {
            System.out.println("The length of the rank is fucked.");
            return;
        }
        
        char rank = inputRank.getText().charAt(0);
        
        em.addNewEmployee(inputID.getText(),inputTitle.getText(),inputName.getText(),inputRole.getText(),rank);
        em.saveEmployeeArray();
    }
    
    private void SetLabel(JPanel panel, String labelText, JTextField textField)
    {
        textField = new JTextField("",9); 
        JLabel text = new JLabel(labelText);
        text.setLabelFor(textField);
        panel.add(textField);
    }
    
    private Boolean CheckLength(JTextField input)
    {
        if(input.getText().length() != 0)
            return true;
        return false;
    }
    
}