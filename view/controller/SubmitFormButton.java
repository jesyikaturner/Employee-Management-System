package view.controller;

import java.io.*;
import java.util.*;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EmployeeManagement;
import view.CreateEmployeeForm;

public class SubmitFormButton extends JButton implements ActionListener
{
    private CreateEmployeeForm input;
    private EmployeeManagement em;
    private String[] data;
    
    public SubmitFormButton(EmployeeManagement em, CreateEmployeeForm input)
    {
        this.input = input;
        this.em = em;
        data = new String[5];
        setText("Submit");
        addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        data = input.GetData();
        
        for(String s : data)
        {
            if(s.length() == 0)
            {
                System.out.println("Something went wrong with the textfields");
                return;
            }
        }
        
        if(data[4].length() > 1)
        {
            System.out.println("The length of the rank is fucked.");
            return;
        }
        
        char rank = data[4].charAt(0);
        
        if(!em.addNewEmployee(data[0],data[1],data[2],data[3],rank)){
            System.out.println("Employee couldn't be created");
            return;
        }
        System.out.println("Employee created and added to database");
        em.saveEmployeeArray();
    }
    
}