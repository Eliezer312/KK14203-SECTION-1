package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class EmployeeLogin extends JPanel {
    private JPasswordField employeepswd;
    private JTextField username;
    private JLabel employeeLabel;
    private JLabel passwordLabel;
    private JButton login;

    public EmployeeLogin() {
        //construct components
        employeepswd = new JPasswordField (5);
        username = new JTextField (10);
        employeeLabel = new JLabel ("Employee Username");
        passwordLabel = new JLabel ("Password");
        login = new JButton ("Login");

        //adjust size and set layout
        setPreferredSize (new Dimension (667, 366));
        setLayout (null);

        //add components
        add (employeepswd);
        add (username);
        add (employeeLabel);
        add (passwordLabel);
        add (login);

        //set component bounds (only needed by Absolute Positioning)
        employeepswd.setBounds (265, 185, 165, 35);
        username.setBounds (265, 125, 165, 30);
        employeeLabel.setBounds (130, 125, 135, 35);
        passwordLabel.setBounds (130, 185, 100, 35);
        login.setBounds (230, 245, 120, 40);
        
        login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!username.getText().equals("") && !employeepswd.getText().equals("")) {
				System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "Username and password can't be blank!");
				}
			}
		});
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Employee Login");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new EmployeeLogin());
        frame.pack();
        frame.setVisible (true);
    }
}