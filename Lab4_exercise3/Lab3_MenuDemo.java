/* ELIEZER BINTI MAINGKIN
BI19110061
LAB4 EXERCISE 3 */
import java.util.Scanner;

class Menu {
   private String item;
   private double price;

   Menu(String i, double p) {
      item = i;
      price = p;
      }

   double calcPrice() {
      return price;
   }
}

public class Lab3_MenuDemo {
   public static void main(String[]args){
   
      String item_name;
      int qty;
      double total=0.0;
     
      try (Scanner scan = new Scanner(System.in)) {      
         System.out.println("                 MENU :");
         System.out.println("----------------------------------------");
         System.out.println("[1] Nasi Lemak         [RM2.00]");
         System.out.println("[2] Roti               [RM1.00]");
         System.out.println("[3] Teh Tarik          [RM1.50]");
         System.out.println("[4] Kopi O             [RM1.00]");
         System.out.println("----------------------------------------");
         System.out.println("Place order [1-4] or type 'q' to exit");

         do {
         System.out.print("Add order: ");
         item_name = scan.next();
         String[] menu_name = {"Nasi Lemak", "Roti", "Teh Tarik", "Kopi O"};
         double[] menu_price = {2.0, 1.0, 1.5, 1.0};
         Menu[] menus = new Menu[4];
 
            for(int i=0; i< 4; i++) {
               menus[i] = new Menu(menu_name[i], menu_price[i]);
            }
            
            switch(item_name.charAt(0)) {
                 
               case '1':
               System.out.println("Nasi Lemak");
               System.out.print("Quantity : ");
               qty = scan.nextInt();
               total += (menus[0].calcPrice() * qty);
               System.out.println("\tPrice: RM" + menus[0].calcPrice() * qty + "\n");
               break;
               
               case '2':
               System.out.println("Roti" );
               System.out.print("Quantity : ");
               qty = scan.nextInt();
               total += (menus[1].calcPrice() * qty);
               System.out.println("\tPrice: RM" + menus[1].calcPrice() * qty + "\n");
               break;
               
               case '3':
               System.out.println("Teh Tarik");
               System.out.print("Quantity : ");
               qty = scan.nextInt();
               total += (menus[2].calcPrice() * qty);
               System.out.println("\tPrice: RM" + menus[2].calcPrice() * qty + "\n");
               break;
               
               case '4':
               System.out.println("Kopi O");
               System.out.print("Quantity : ");
               qty = scan.nextInt();
               total += (menus[3].calcPrice() * qty);
               System.out.println("\tPrice: RM" + menus[3].calcPrice() * qty + "\n");
               break;
            
               default:
               break;
            }
         }
         
         while (item_name.charAt(0)!='q'); 
         System.out.println("Thank you for your order.");
         System.out.printf("Total due: RM %.2f", total);
      }
   }
}
