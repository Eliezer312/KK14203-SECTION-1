/* ELIEZER MAINGKIN
BI19110061
LAB7 */
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

//Header panel
class HeaderPanel extends JPanel{
   private JLabel header;
   public HeaderPanel(){
      	header = new JLabel("Course Evaluation Form");
      	add(header);
   }
}

//Form Panel
class FormPanel extends JPanel implements ActionListener, ItemListener{
   //list all UI components for the panel
   JLabel namelabel;
   JTextField name;
   JLabel matriclabel;
   JTextField matric;
   JLabel codelabel;
   JComboBox<String> code;
   JLabel ratinglabel;
   JLabel outcomelabel;
   JButton submit;
   JButton clear;
   JCheckBox outcome1;
   JCheckBox outcome2;
   JLabel outputlabel; 
   JScrollPane jsp;
   Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
   
   //global variable  
   String output="";
   String codeSelection="";
   String ratingSelection="";
   String outcomeSelection="";
   String filePath="evaluationform.txt"; //in the same directory
      
   public FormPanel(){   
      setLayout(new FlowLayout(FlowLayout.LEFT));     
      
      namelabel = new JLabel("Name");
      namelabel.setPreferredSize(new Dimension(150, 20));
      namelabel.setBorder(border);
      
      add(namelabel);
      name = new JTextField(20);
      add(name);
      
      //input name accept char only
      name.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
         char c=e.getKeyChar(); 
            if(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE) || (c==KeyEvent.VK_SPACE)) {
                e = e;
            }
           else{
                e.consume();
            }
        }
});
     
      matriclabel = new JLabel("Matric No.");
      matriclabel.setPreferredSize(new Dimension(150, 20));
      matriclabel.setBorder(border);
      add(matriclabel);
      matric = new JTextField(15);
      add(matric);   
      
      String[] courses={"[Select]", "KK14203 OOP", "KT14203 CAO", "KT14403 Discrete Structures"};
      
      codelabel = new JLabel("Course Code");
      codelabel.setPreferredSize(new Dimension(150, 20));
      codelabel.setBorder(border);
      add(codelabel);
      code = new JComboBox<String>(courses);
      add(code); 
      
      //JComboBox action listener
      code.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            //get selected item
            codeSelection = (String) code.getSelectedItem();
         }
      });  
      
      ratinglabel = new JLabel("Rating");
      ratinglabel.setPreferredSize(new Dimension(150, 20));
      ratinglabel.setBorder(border);
      add(ratinglabel);
      
      //Radio buttons and action listener
      JRadioButton rating1 = new JRadioButton("1");
      rating1.addActionListener(this);
      JRadioButton rating2 = new JRadioButton("2");
      rating2.addActionListener(this);
      JRadioButton rating3 = new JRadioButton("3");
      rating3.addActionListener(this);
      JRadioButton rating4 = new JRadioButton("4");
      rating4.addActionListener(this);
      JRadioButton rating5 = new JRadioButton("5");
      rating5.addActionListener(this);
      add(rating1);
      add(rating2);
      add(rating3);
      add(rating4);
      add(rating5);
      
      //define button group
      ButtonGroup bg = new ButtonGroup();
      bg.add(rating1);
      bg.add(rating2);
      bg.add(rating3);
      bg.add(rating4);
      bg.add(rating5);
      
      outcomelabel = new JLabel("Outcome");
      outcomelabel.setPreferredSize(new Dimension(150, 20));
      outcomelabel.setBorder(border);
      add(outcomelabel);
      
      //checkbox and  item listener
      outcome1 = new JCheckBox("Basic knowledge");
      outcome1.addItemListener(this);
      add(outcome1);
      outcome2 = new JCheckBox("Advanced knowledge");
      outcome2.addItemListener(this);
      add(outcome2);
      
      submit = new JButton("Submit");
      add(submit);
      clear = new JButton("Clear");
      add(clear);
      
      //handle button submit action listener
      //view the input to output label
      //and write to file
      submit.addActionListener(new ActionListener(){           
         public void actionPerformed(ActionEvent e){  
            //call method
            if(printOutput()){
               writeInput();  
               
               //show dialog message if input is succesfully saved
               JOptionPane.showMessageDialog(null, "You have successfully submit the course evaluation form for " + codeSelection + " !");
            }   
         }  
      });
      
      //handle button clear action listener
      clear.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
            outputlabel.setText("Output");  
            name.setText("");
            matric.setText(""); 
            code.setSelectedIndex(0);
            bg.clearSelection();
            outcome1.setSelected(false);
            outcome2.setSelected(false);
         }  
      });
      
      outputlabel = new JLabel("Output");
      outputlabel.setBorder(border);
      outputlabel.setVerticalAlignment(JLabel.TOP);
      
      //add output label to scrollpane
      jsp = new JScrollPane(outputlabel);
      jsp.setPreferredSize(new Dimension(410,120));
      add(jsp);     
   }

   //handle radio button selection
   public void actionPerformed(ActionEvent ae) {
      ratingSelection = ae.getActionCommand();    	   
   }
   
   //handle item listener for checkbox
   public void itemStateChanged(ItemEvent ie) {
      JCheckBox check = (JCheckBox)ie.getSource();
      outcomeSelection += check.getText() + " ";   
   }
   
   //method to print output to outputlabel
   public boolean printOutput(){
      output = "<html>";
      output += "Thank you for your evaluation<br><br>"; 
      output += "Name: " + name.getText() + "<br>";
      output += "Matric: " + matric.getText() + "<br>";
      
      if(codeSelection.equals("[Select]") || code.getSelectedItem().equals("")  || name.getText().equals("") || matric.getText().equals("") || ratingSelection.equals("") || outcomeSelection.equals("")){
         JOptionPane.showMessageDialog(null, "You haven't filled everything.");
         return false;
      }
      
      output += "Course: " + codeSelection + "<br>";
      output += "Rating: " + ratingSelection + "<br>";
      output += "Outcome: " + outcomeSelection + "<br>";
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
      
      String input = name.getText() + ", " + matric.getText() + ", " + codeSelection + ", " + ratingSelection + ", " + outcomeSelection;
      
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
   FormPanel fp;
   //receive FormPanel class to this constructor
   public MenuActionListener(FormPanel p){
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

class MenuActionListener2 implements ActionListener {
   FormPanel fp;
   //receive FormPanel class to this constructor
   public MenuActionListener2(FormPanel p){
      fp = p;
}
    
   public void actionPerformed(ActionEvent e) {   
      
      //show confirm dialog to exit application
      int response = JOptionPane.showConfirmDialog(null,"Do you want to Exit? ", 
     "Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

     if (response == JOptionPane.YES_OPTION)
     {
        System.exit(0);
     } 
  }
}

//run the application using this main
public class CourseEvaluationApp {  
   public static void main(String[] 	args) {  
      JFrame f = new JFrame("Course Evaluation App");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      //load panels
      HeaderPanel h = new 	HeaderPanel();
      FormPanel fp = new FormPanel();
      
      JMenuBar mb = new JMenuBar(); 
      // create a menu 
      JMenu x = new JMenu("Menu"); 
      
      // create menuitems 
      JMenuItem m1 = new JMenuItem("Load Data"); 
      // attach listener and send FormPanel class
      m1.addActionListener(new MenuActionListener(fp));
      
      JMenuItem m2 = new JMenuItem("Exit");
      m2.addActionListener(new MenuActionListener2(fp));
 
      // add menu items to menu 
      x.add(m1); 
      x.add(m2);
     
      // add menu to menu bar 
      mb.add(x); 
      // add menubar to frame 
      f.setJMenuBar(mb);  
               
      //add panels to frame       
      f.add(h,BorderLayout.NORTH);
      f.add(fp, BorderLayout.CENTER);
      f.setSize(460,400);
      f.setVisible(true);
   }  
}