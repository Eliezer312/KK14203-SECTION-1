package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//required for border
import javax.swing.BorderFactory;
import javax.swing.border.Border;
//required for file IO
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
//required for exception
import java.io.IOException;

class ConfirmationPanel extends JPanel{
   //list all UI components for the panel
   JLabel outputlabel;
   JButton confirm;
   JComboBox<String> cb;
   JScrollPane jsp;
   Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

   //global variable  
   String cbSelection="";
   String output="";
   String filePath="Employee Leave Application Form.txt"; //in the same directory
   
   public ConfirmationPanel(){        
      String[] cbItems = {"APPROVE", "DISAPPROVE"};
      
      //adjust size and set layout
      setPreferredSize (new Dimension (560, 530));
      setLayout (null);
      
      cb = new JComboBox<String>(cbItems);
      cb.setBounds (185, 345, 100, 25);  
      add(cb); 
      
      //JComboBox action listener
      cb.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            //get selected item
            cbSelection = (String) cb.getSelectedItem();
         }
      }); 
               
      confirm = new JButton ("Confirm");
      confirm.setBounds (330, 345, 100, 25);
      add (confirm);

      
      //handle button submit action listener
      //view the input to output label
      //and write to file
      confirm.addActionListener(new ActionListener(){  
          public void actionPerformed(ActionEvent e){  
             writeInput();
            JOptionPane.showMessageDialog(null, "You have responded to your employee leave application.");
                 }  
       });
            
      outputlabel = new JLabel("Click View Data in Menu to Load Employee Leave Application Form");
      outputlabel.setBounds (20, 20, 500, 25);
      outputlabel.setBorder(border);
      outputlabel.setVerticalAlignment(JLabel.TOP);
      
      //add output label to scrollpane
      jsp = new JScrollPane(outputlabel);
      jsp.setBounds (20, 20, 500, 300);
      add(jsp);   
}
    
    //write to file
    public void writeInput(){
      File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
       
      String input = "Updated Status: " + cbSelection;
       
       //exception implementation
		try {
			// to append to file, you need to initialize FileWriter using below constructor
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(input);
		} catch (IOException e) {			
         outputlabel.setText(e.toString());
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				outputlabel.setText(e.toString());
			}
		}
    }
}

class MenuActionListener implements ActionListener {
   ConfirmationPanel fp;
   //receive FormPanel class to this constructor
   public MenuActionListener(ConfirmationPanel p){
      fp = p;
   }
    public void actionPerformed(ActionEvent e) {
       BufferedReader reader;
 	   try {
 			reader = new BufferedReader(new FileReader(fp.filePath));
 			String line = reader.readLine();
          String output="<html>";
 			while (line != null) {
 				output += line + "<br>";
 				// read next line
 				line = reader.readLine();
 			}
          output += "<br>";
          fp.outputlabel.setText(output);
 			reader.close();
 		} catch (IOException io) {
 			fp.outputlabel.setText(io.toString());
 		}
 
   }
 }

//run the application using this main
public class ConfirmationForm {  
   public static void main(String[] 	args) {  
      JFrame f = new JFrame("Employee Leave Application Review");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      f.getContentPane().add (new ConfirmationPanel());
      ConfirmationPanel fp = new ConfirmationPanel();
      
      JMenuBar mb = new JMenuBar(); 
      // create a menu 
      JMenu x = new JMenu("Menu"); 
      
      // create menuitems 
      JMenuItem m1 = new JMenuItem("View Data"); 
      // attach listener and send FormPanel class
      m1.addActionListener(new MenuActionListener(fp));
      
      JMenuItem m2 = new JMenuItem("Exit");  
      m2.addActionListener((event) -> System.exit(0));
      // add menu items to menu 
      x.add(m1); 
      x.add(m2);
     
      // add menu to menu bar 
      mb.add(x); 
      // add menubar to frame 
      f.setJMenuBar(mb);  
               
      //add panels to frame      
      f.add(fp);
      f.pack();
      f.setVisible(true);
   }  
}