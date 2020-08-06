package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.Toolkit;

public class EmployeeMenu extends JPanel{
    JLabel loginLabel;
    JButton employeeInfo;
    JButton applyForm;
    JButton formStatus;

    public EmployeeMenu() {
        //construct components
        loginLabel = new JLabel ("Logged in as Employee");
        employeeInfo = new JButton ("Update Personal Information");
        applyForm = new JButton ("Apply New Leave Application");
        formStatus = new JButton ("Check Leave Application Status");

        //adjust size and set layout
        setPreferredSize (new Dimension (667, 366));
        setLayout (null);

        //add components
        add (loginLabel);
        add (employeeInfo);
        add (applyForm);
        add (formStatus);

        //set component bounds (only needed by Absolute Positioning)
        loginLabel.setBounds (0, 346, 155, 25);
        employeeInfo.setBounds (200, 85, 225, 45);
        applyForm.setBounds (200, 155, 225, 45);
        formStatus.setBounds (200,225, 225, 45);
        
		  employeeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   System.exit(0);
			}
		  });
        
        applyForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   System.exit(0);
			}
		  });
        
        formStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   System.exit(0);
			}
		  }); 
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame ("Employee Main Menu");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new EmployeeMenu());
        frame.pack();
        frame.setVisible (true);
    }
}
