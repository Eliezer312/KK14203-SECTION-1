package com.company;

import java.io.*;
import java.util.Scanner;

public class Approval  {

    public static void approval() {
        try {
            File myObj = new File("Req0002.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println();

        //Admin to approve/ dissaprove request
        StringBuilder sb = new StringBuilder();
        String strLine = "";
        try { //TRY
            String filename = "Req0002.txt";
            FileWriter fw = new FileWriter(filename, true);
            Scanner sc = new Scanner(System.in);
            System.out.println(" Leave status approval (APPROVED / DISSAPROVED) : ");
            System.out.println();
            String AdminApproval = sc.nextLine();

            //appends the string to the file
            fw.write(AdminApproval);
            fw.close();
            BufferedReader br = new BufferedReader(new FileReader("Req0002.txt"));
            //read the file content
            while (strLine != null) {
                sb.append(strLine);
                sb.append(System.lineSeparator());
                strLine = br.readLine();
                System.out.println(strLine);
            }
            br.close();
        } //TRY CLOSE
        catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

}
