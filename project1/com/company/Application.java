package com.company;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Application {
    void ApplyNewLeave_02() {
        System.out.println("Staff Leave Application Form \n");
        System.out.println("Fill in the form below");
        System.out.println();
        System.out.println("Types of Leave");
        System.out.println("01- annual leave");
        System.out.println("02- medical leave");
        System.out.println("03- emergency leave");
        System.out.println();
        try {
            // Save original out stream.
            PrintStream employee_id = System.out;
            PrintStream fullName = System.out;
            PrintStream types_of_leave = System.out;
            PrintStream date_start_leave = System.out;
            PrintStream date_end_leave = System.out;
            PrintStream leave_reason = System.out;
            PrintStream status_approval = System.out;

            // Create a new file output stream.
            PrintStream fileOut = new PrintStream("Req0002.txt");

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

            types_of_leave.println("Enter types of leave (e.g 01) : \n");
            String line3 = scanner.nextLine();
            System.out.println("Types of Leave : " + line3);

            date_start_leave.println("Date start leave (e.g 2/2/2020) : \n");
            String line4 = scanner.nextLine();
            System.out.println("Date Start Leave : " + line4);

            date_end_leave.println(" Date end leave (e.g 2/2/2020) : \n");
            String line5 = scanner.nextLine();
            System.out.println("Date End Leave : " + line5);

            leave_reason.println(" Reason for leave : \n");
            String line6 = scanner.nextLine();
            System.out.println("Reason : " + line6);

            status_approval.println("Leave Status Approval: ......pending......");
            System.out.println("Leave Status Approval: ............");
            System.out.println();

            System.setOut(employee_id);
            System.setOut(fullName);
            System.setOut(types_of_leave);
            System.setOut(date_start_leave);
            System.setOut(date_end_leave);
            System.setOut(leave_reason);
            System.setOut(status_approval);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println("Leave Application Request is successfully registered. Kindly wait in a week for status approval from administrator");
    }

}
