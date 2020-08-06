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

//ApplicationForm panel
class ApplicationForm extends JPanel implements ActionListener{
    JLabel fullnamelabel;
    JLabel idlabel;
    JLabel typeofleavelabel;
    JLabel datestartlabel;
    JLabel dateendlabel;
    JRadioButton typeleave1;
    JRadioButton typeleave2;
    JRadioButton typeleave3;
    JTextField fullname;
    JTextField id;
    JTextField datestart;
    JLabel egdatestartlabel;
    JTextField dateend;
    JLabel egdateendlabel;
    JButton submit;
    
    String filePath = "Employee Leave Application Form.txt"; //in the same directory
    String leaveSelection = "";

    public ApplicationForm() {
        //construct components
        fullnamelabel = new JLabel ("Employee Fullname :");
        idlabel = new JLabel ("Employee ID :");
        typeofleavelabel = new JLabel ("Type of Leave :");
        datestartlabel = new JLabel ("Date Start Leave :");
        dateendlabel = new JLabel ("Date End Leave :");
        fullname = new JTextField (50);
        id = new JTextField (10);
        datestart = new JTextField (10);
        egdatestartlabel = new JLabel ("eg: 12/04/2020");
        dateend = new JTextField (10);
        egdateendlabel = new JLabel ("eg: 12/04/2020");
        submit = new JButton ("SUBMIT");

        //adjust size and set layout
        setPreferredSize (new Dimension (667, 366));
        setLayout (null);

        //add components
        add (fullnamelabel);
        add (idlabel);
        add (typeofleavelabel);
        add (datestartlabel);
        add (dateendlabel);
        add (fullname);
        add (id);
        add (datestart);
        add (egdatestartlabel);
        add (dateend);
        add (egdateendlabel);
        add (submit);

        //set component bounds (only needed by Absolute Positioning)
        fullnamelabel.setBounds (20, 50, 300, 30);
        idlabel.setBounds (20, 90, 100, 25);
        typeofleavelabel.setBounds (20, 130, 100, 25);
        datestartlabel.setBounds (20, 170, 110, 25);
        dateendlabel.setBounds (20, 210, 100, 25);
        fullname.setBounds (150, 50, 200, 25);
        id.setBounds (150, 90, 110, 25);
        datestart.setBounds (150, 170, 100, 25);
        egdatestartlabel.setBounds (270, 170, 100, 25);
        dateend.setBounds (150, 210, 100, 25);
        egdateendlabel.setBounds (270, 210, 100, 25);
        submit.setBounds (280, 280, 80, 40);
        
        //radio buttons and action listener
        typeleave1 = new JRadioButton ("Annual Leave");
        typeleave1.setBounds (150, 130, 120, 25);
        typeleave1.addActionListener(this);
        add (typeleave1);
        typeleave2 = new JRadioButton ("Medical Leave");
        typeleave2.setBounds (270, 130, 120, 25);
        typeleave2.addActionListener(this);
        add (typeleave2);
        typeleave3 = new JRadioButton ("Emergency Leave");
        typeleave3.setBounds (390, 130, 140, 25);
        typeleave3.addActionListener(this);
        add (typeleave3);
        
        ButtonGroup bg = new ButtonGroup();
         bg.add(typeleave1);
         bg.add(typeleave2);
         bg.add(typeleave3);
        
      //handle button submit action listener
      //view the input to output label
      //and write to file
      submit.addActionListener(new ActionListener(){           
         public void actionPerformed(ActionEvent e){  
            //call method
            writeInput();
            //show dialog message if input is succesfully saved
            JOptionPane.showMessageDialog(null, "You have successfully submit your leave application!");
            }  
      });   
    }
    
   //handle radio button selection
   public void actionPerformed(ActionEvent ae) {
      leaveSelection = ae.getActionCommand();    	   
   }
    
    //write to file
    public void writeInput(){
      File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
      
      String input = "Fullname: " + fullname.getText() + "\n" + "Employee ID: " + id.getText() + "\n" + "Type of Leave: " + leaveSelection + "\n" + "Date Start: " + datestart.getText() + "\n" + "Date End: " + dateend.getText() + "\n" + "Status: pending";
      
      //exception implementation
			try {
			// to append to file, you need to initialize FileWriter using below constructor
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(input);
		} catch (IOException e) {	
         JOptionPane.showMessageDialog(null, "Submission is unsuccessful!");
         } finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
         JOptionPane.showMessageDialog(null, "Submission is unsuccessful!");
			}
		}			
		}

    public static void main (String[] args) {
        JFrame frame = new JFrame ("Employee Leave Application Form");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new ApplicationForm());
        frame.pack();
        frame.setVisible (true);
    }
}