package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Employee {

    public void displayEmployeeMenu() {
        System.out.println("Menu \n");
        System.out.println("01  UPDATE PERSONAL INFO ");
        System.out.println("02  APPLY NEW LEAVE APPLICATION ");
        System.out.println("03  CHECK LEAVE APPLICATION STATUS ");
        System.out.println("04  EXIT");
    }

    public void UpdatePersonalInfo_01() {
        System.out.println("Employee Details Update \n");
        System.out.println("Personal Info");
        System.out.println();

        try {
            // Save original out stream.
            PrintStream employee_id = System.out;
            PrintStream fullName = System.out;
            PrintStream date_of_birth = System.out;
            PrintStream age = System.out;
            PrintStream email_address = System.out;
            PrintStream home_address = System.out;
            PrintStream contact_number = System.out;

            // Create a new file output stream.
            PrintStream fileOut = new PrintStream("Employee1.txt");

            // Redirect standard out to file.
            System.setOut(fileOut);

            // Wrapped Scanner to get user input.
            Scanner scanner = new Scanner(System.in);

            // Print data in command console.
            employee_id.println("Enter Employee ID:  \n");
            String line1 = scanner.nextLine();
            System.out.println("Employee ID : " + line1);

            fullName.println("Enter Full name: \n");
            String line2 = scanner.nextLine();
            System.out.println("Staff Name : " + line2);

            date_of_birth.println("Enter Date of Birth (e.g 2 June 2020) : \n");
            String line3 = scanner.nextLine();
            System.out.println("DOB : " + line3);

            age.println("Age (e.g 20) : \n");
            String line4 = scanner.nextLine();
            System.out.println("Age : " + line4);

            email_address.println(" Email address : \n");
            String line5 = scanner.nextLine();
            System.out.println("Email_address : " + line5);

            home_address.println(" Home address : \n");
            String line6 = scanner.nextLine();
            System.out.println("home_address : " + line6);

            contact_number.println(" Phone contact number : \n");
            String line7 = scanner.nextLine();
            System.out.println("Phone contact number : " + line7);

            System.setOut(employee_id);
            System.setOut(fullName);
            System.setOut(date_of_birth);
            System.setOut(age);
            System.setOut(email_address);
            System.setOut(home_address);
            System.setOut(contact_number);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println("Your information is successfully updated. Thank you");
    }

    public void CheckLeaveStatus_03() throws FileNotFoundException {
        System.out.println("Opening Leave Application Request Status... ");
        System.out.println();

        File myObj = new File("Req0002.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
    }
}
