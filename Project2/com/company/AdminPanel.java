package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionListener;


public class AdminPanel extends JPanel {
    JLabel loginLabel;
    JButton adminInfo;
    JButton checkForm;

    public AdminPanel() {
        //construct components
        loginLabel = new JLabel ("Logged in as Admin");
        adminInfo = new JButton ("Admin Personal Information");
        checkForm = new JButton ("Check Staff Leave Application");

        //adjust size and set layout
        setPreferredSize (new Dimension (667, 366));
        setLayout (null);

        //add components
        add (loginLabel);
        add (adminInfo);
        add (checkForm);

        //set component bounds (only needed by Absolute Positioning)
        loginLabel.setBounds (0, 346, 115, 25);
        adminInfo.setBounds (200, 115, 225, 45);
        checkForm.setBounds (200, 185, 225, 45);
        
		  adminInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   System.exit(0);
			}
		  });
      
        checkForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            System.exit(0);
			}
		  });

    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Admin Main Menu");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new AdminPanel());
        frame.pack();
        frame.setVisible (true);
    }
}
