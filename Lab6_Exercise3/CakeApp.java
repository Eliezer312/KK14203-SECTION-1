/* ELIEZER BINTI MAINGKIN
BI19110061
LAB6 EXERCISE3 */
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
//required for decimal number
import java.text.DecimalFormat;

//Cake Panel
class CakePanel extends JPanel implements ActionListener, ItemListener{
   DecimalFormat df = new DecimalFormat("0.00");
   //list all UI components for the panel
   JLabel line1;
   JLabel menu;
   JLabel line2;
   JLabel cakemenu;
   JLabel line3;
   JLabel toppings;
   JLabel size;  
   JLabel line4;
   JLabel total;
   JLabel outputlabel;
   JLabel quantitylabel;
   JRadioButton size1;
   JRadioButton size2;
   JRadioButton size3;
   JButton submit;
   JScrollPane jsp;
   JCheckBox topping1;
   JCheckBox topping2;
   JCheckBox topping3;
   JTextField quantity;
   Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

   //global variable  
   String output="";
   String toppingSelection="";
   String sizeSelection="";
   String filePath="order.txt"; //in the same directory
   int ttlprice;
   int multi;
   int q, a;
   
   public CakePanel(){        
      
      line1 = new JLabel ("-----------------------------------------------------------------------------------------------");
      menu = new JLabel ("Cake Menu");
      line2 = new JLabel ("-----------------------------------------------------------------------------------------------");
      cakemenu = new JLabel ("Cake      :   Blackforest");
      toppings = new JLabel ("Topping :");
      size = new JLabel ("Size        :");
      line3 = new JLabel ("-----------------------------------------------------------------------------------------------");
      quantitylabel = new JLabel("Quantity: ");
      line4 = new JLabel ("-----------------------------------------------------------------------------------------------");
      total = new JLabel ("Total Price :");
      
      //adjust size and set layout
      setPreferredSize (new Dimension (560, 530));
      setLayout (null);

      //add components
      add (line1);
      add (menu);
      add (line2);
      add (cakemenu);
      add (line3);
      add (toppings);
      add (size);
      add (quantitylabel);
      add (line4);
      add (total);
        
      //set component bounds (only needed by Absolute Positioning)
      line1.setBounds (70, 15, 400, 25);
      menu.setBounds (220, 35, 100, 25);
      line2.setBounds (70, 55, 400, 25);
      cakemenu.setBounds (20, 80, 140, 25);
      line3.setBounds (20, 200, 400, 25);
      toppings.setBounds (20, 110, 100, 25);
      size.setBounds (20, 140, 100, 25);
      quantitylabel.setBounds(20,180,100,25);
      line4.setBounds (20, 250, 400, 25);
      total.setBounds (20, 225, 200, 25);
      
      //textfield
      quantity = new JTextField(20);
      quantity.setBounds(75,180,100,25); 
      add (quantity);
      
      //Radio buttons and action listener  
      topping1 = new JCheckBox("Chocolate");
      topping1.setBounds (75, 110, 100, 25);
      topping1.addItemListener(this);
      add (topping1);
      
      topping2 = new JCheckBox("Cherries");
      topping2.setBounds (175, 110, 90, 25);
      topping2.addItemListener(this);
      add (topping2);
      
      topping3 = new JCheckBox("Whipped Cream");
      topping3.setBounds (265, 110, 140, 25);
      topping3.addItemListener(this);
      add (topping3);

      size1 = new JRadioButton("Small (RM45.00)");
      size1.setBounds (75, 140, 120, 25);
      size1.addActionListener(this);
      add (size1);
      
      size2 = new JRadioButton("Medium (RM65.00)");
      size2.setBounds (200, 140, 140, 25);
      size2.addActionListener(this);
      add (size2);
      
      size3 = new JRadioButton("Big (RM80.00)");
      size3.setBounds (340, 140, 130, 25);
      size3.addActionListener(this);
      add (size3);
      
      ButtonGroup bg = new ButtonGroup();
      bg.add(size1);
      bg.add(size2);
      bg.add(size3);
                  
      submit = new JButton ("Submit");
      submit.setBounds (250, 270, 100, 25);
      add (submit);

      
      //handle button submit action listener
      //view the input to output label
      //and write to file
      submit.addActionListener(new ActionListener(){  
          public void actionPerformed(ActionEvent e){  
             //call method              
             if(printOutput())
                writeInput(); 
                quantitylabel.setText("Quantity: ");
                total.setText("Total Price : RM"+df.format(multi));   
          }  
       });
            
      outputlabel = new JLabel("Receipt");
      outputlabel.setBounds (20, 300, 400, 25);
      outputlabel.setBorder(border);
      outputlabel.setVerticalAlignment(JLabel.TOP);
      
      //add output label to scrollpane
      jsp = new JScrollPane(outputlabel);
      jsp.setBounds (20, 300, 400, 200);
      add(jsp);   
}
  //handle radio button selection
   public void actionPerformed(ActionEvent ae) {
      sizeSelection = ae.getActionCommand();    	   
   }
   
   //handle item listener for checkbox
   public void itemStateChanged(ItemEvent ie) {
      JCheckBox check = (JCheckBox)ie.getSource();
      toppingSelection += check.getText() + " ";   
   }

     //method to print output to outputlabel
    public boolean printOutput(){
      output = "<html>";
      output += "Thank you for your order<br><br>";   
      output += "Cake: Blackforest<br>";
      output += "Topping: " + toppingSelection + "<br>";
      q = Integer.parseInt(quantity.getText());
      if(topping1.isSelected()){
      ttlprice += 10;
      }if(topping2.isSelected()){
      ttlprice += 10;
      }if(topping3.isSelected()){
      ttlprice += 10;
      }
      
      if(size1.isSelected()){
         multi = ttlprice + (45 * q);
      }else if(size2.isSelected()){
         multi = ttlprice + (65 * q);
      }else if(size3.isSelected()){
         multi = ttlprice + (80 * q);
      }
      
      output += "Size: " + sizeSelection + "<br>";
      output += "Quantity: "+ q + "<br>";
      output += "Total: RM" + df.format(multi) + "<br>";
      output += "RM10 charged for each topping" + "<br>";
      output += "</html>";          
      outputlabel.setText(output);
      jsp.getViewport().revalidate();
      return true;
    }
    
    //write to file
    public void writeInput(){
      File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
       
      String input =  sizeSelection + ", " + toppingSelection + ","  +  quantity.getText() +", RM" + df.format(multi);
       
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
   CakePanel fp;
   //receive FormPanel class to this constructor
   public MenuActionListener(CakePanel p){
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
public class CakeApp {  
   public static void main(String[] 	args) {  
      JFrame f = new JFrame("Cake Order System");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      f.getContentPane().add (new CakePanel());
      CakePanel fp = new CakePanel();
      
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