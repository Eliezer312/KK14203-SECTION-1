package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainPanel extends JPanel {
    JButton admin;
    JButton employee;
    JLabel title;

    public MainPanel() {
        //construct components
        admin = new JButton ("Admin");
        employee = new JButton ("Employee");
        title = new JLabel ("Welcome to HC00 Employee Leave Management System");

        //adjust size and set layout
        setPreferredSize (new Dimension (667, 366));
        setLayout (null);

        //add components
        add (admin);
        add (employee);
        add (title);

        //set component bounds (only needed by Absolute Positioning)
        admin.setBounds (140, 210, 125, 45);
        employee.setBounds (385, 210, 115, 45);
        title.setBounds (155, 105, 370, 100);
        
        admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   System.exit(0);
			}
		  }); 
        
        employee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   System.exit(0);
			}
		  }); 

    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Employee Leave Management System");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new MainPanel());
        frame.pack();
        frame.setVisible (true);
    }
}
