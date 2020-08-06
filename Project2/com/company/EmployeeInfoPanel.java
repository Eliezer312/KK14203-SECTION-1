package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//required for file IO
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
//required for exception
import java.io.IOException;

public class EmployeeInfoPanel extends JPanel {
    JLabel employeeinfolabel;
    JLabel fullnamelabel;
    JLabel idlabel;
    JLabel nriclabel;
    JLabel agelabel;
    JLabel doblabel;
    JLabel phonelabel;
    JLabel emailLabel;
    JLabel addresslabel;
    JTextField fullname;
    JTextField id;
    JTextField nric;
    JLabel egnriclabel;
    JTextField age;
    JTextField dob;
    JLabel egdoblabel;
    JTextField phonenumb;
    JTextField email;
    JTextField address;
    JButton submit;
    
    String filePath="Employee Personal Info.txt"; //in the same directory


    public EmployeeInfoPanel() {
        //construct components
        employeeinfolabel = new JLabel ("Employee Personal Information");
        fullnamelabel = new JLabel ("Employee Fullname :");
        idlabel = new JLabel ("Employee ID              :");
        nriclabel = new JLabel ("NRIC/Passport No.  :");
        agelabel = new JLabel ("Age                             :");
        doblabel = new JLabel ("Date of Birth             :");
        phonelabel = new JLabel ("Phone Number         :");
        emailLabel = new JLabel ("Email Address          :");
        addresslabel = new JLabel ("Home Address         :");
        fullname = new JTextField (50);
        id = new JTextField (10);
        nric = new JTextField (12);
        egnriclabel = new JLabel ("eg:990104124433");
        age = new JTextField (5);
        dob = new JTextField (5);
        egdoblabel = new JLabel ("eg: 4 January 1999");
        phonenumb = new JTextField (12);
        email = new JTextField (50);
        address = new JTextField (150);
        submit = new JButton ("SUBMIT");

        //adjust size and set layout
        setPreferredSize (new Dimension (667, 499));
        setLayout (null);

        //add components
        add (employeeinfolabel);
        add (fullnamelabel);
        add (idlabel);
        add (nriclabel);
        add (agelabel);
        add (doblabel);
        add (phonelabel);
        add (emailLabel);
        add (addresslabel);
        add (fullname);
        add (id);
        add (nric);
        add (egnriclabel);
        add (age);
        add (dob);
        add (egdoblabel);
        add (phonenumb);
        add (email);
        add (address);
        add (submit);
        
        //set component bounds (only needed by Absolute Positioning)
        employeeinfolabel.setBounds (230, 15, 215, 40);
        fullnamelabel.setBounds (55, 65, 130, 35);
        idlabel.setBounds (55, 100, 125, 35);
        nriclabel.setBounds (55, 145, 120, 40);
        agelabel.setBounds (55, 185, 115, 35);
        doblabel.setBounds (55, 230, 125, 35);
        phonelabel.setBounds (55, 270, 135, 40);
        emailLabel.setBounds (55, 320, 125, 45);
        addresslabel.setBounds (55, 380, 130, 40);
        fullname.setBounds (190, 60, 370, 35);
        id.setBounds (190, 100, 140, 35);
        nric.setBounds (190, 145, 200, 35);
        egnriclabel.setBounds (400, 145, 115, 30);
        age.setBounds (190, 185, 70, 35);
        dob.setBounds (190, 230, 115, 35);
        egdoblabel.setBounds (320, 230, 130, 35);
        phonenumb.setBounds (190, 275, 160, 35);
        email.setBounds (190, 325, 235, 35);
        address.setBounds (190, 385, 345, 45);
        submit.setBounds (300, 440, 80, 40);
        
      //handle button submit action listener
      //view the input to output label
      //and write to file
      submit.addActionListener(new ActionListener(){           
         public void actionPerformed(ActionEvent e){  
            //call method
            writeInput();
            //show dialog message if input is succesfully saved
            JOptionPane.showMessageDialog(null, "You have successfully update your personal information!");
            }  
      }); 
    }
    
   //write to file
    public void writeInput(){
      File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
      
      String input = fullname.getText() + ", " + id.getText() + ", " + nric.getText() + ", " + age.getText() + ", " + dob.getText() + ", " + phonenumb.getText() + ", " + email.getText() + ", " + address.getText();
      
      //exception implementation
			try {
			// to append to file, you need to initialize FileWriter using below constructor
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(input);
		} catch (IOException e) {	
         JOptionPane.showMessageDialog(null, "  ");		
         } finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
         JOptionPane.showMessageDialog(null, "  ");
			}
		}			
		}
   
    public static void main (String[] args) {
        JFrame frame = new JFrame ("Employee Personal Information");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new EmployeeInfoPanel());
        frame.pack();
        frame.setVisible (true);
        
        //menu bar
         JMenuBar mb = new JMenuBar(); 
         // create a menu 
         JMenu x = new JMenu("Menu"); 
      
         // create menuitems 
         JMenuItem m1 = new JMenuItem("Exit");  
         m1.addActionListener((event) -> System.exit(0));
         x.add(m1); 
         mb.add(x); 
         frame.setJMenuBar(mb);
    }
}
