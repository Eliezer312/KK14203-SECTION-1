package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AdminLogin extends JPanel {
    private JPasswordField adminpswd;
    private JTextField username;
    private JLabel adminLabel;
    private JLabel passwordLabel;
    private JButton login;

    public AdminLogin() {
        //construct components
        adminpswd = new JPasswordField (5);
        username = new JTextField (10);
        adminLabel = new JLabel ("Admin Username");
        passwordLabel = new JLabel ("Password");
        login = new JButton ("Login");

        //adjust size and set layout
        setPreferredSize (new Dimension (667, 366));
        setLayout (null);

        //add components
        add (adminpswd);
        add (username);
        add (adminLabel);
        add (passwordLabel);
        add (login);

        //set component bounds (only needed by Absolute Positioning)
        adminpswd.setBounds (265, 185, 165, 35);
        username.setBounds (265, 125, 165, 30);
        adminLabel.setBounds (130, 125, 110, 30);
        passwordLabel.setBounds (130, 185, 100, 35);
        login.setBounds (230, 245, 120, 40);
        
		  login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!username.getText().equals("") && !adminpswd.getText().equals("")) {
				System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "Username and password can't be blank!");
				}
			}
		});
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Admin Login");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new AdminLogin());
        frame.pack();
        frame.setVisible (true);
    } 
}