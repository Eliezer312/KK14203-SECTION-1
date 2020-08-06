package com.company;

import java.util.Scanner;
import java.io.FileNotFoundException;


class Login {
    public static void main(String[] args) {
            { //AFTER PUBLIC STATIC
                System.out.println("Welcome to HC00 Company Leave Management System");
                String username, password;
                int digit;
                Scanner in = new Scanner(System.in);
                System.out.println("(1) Employee Login");
                System.out.println("(2) Admin Login");
                digit = in.nextInt();

                if (digit == 1) {
                    Scanner s = new Scanner(System.in);
                    System.out.print("Enter id without capital letters:");//username:matric_number
                    username = s.nextLine();
                    System.out.print("Enter password:");//password:ic
                    password = s.nextLine();

                    if (username.equals("wan") && password.equals("1234")) {
                        Employee newAccess = new Employee();
                        System.out.println("Authentication Successful");
                        newAccess.displayEmployeeMenu();
                        System.out.println("Select [01-03] or type 00 to exit system: ");
                        String EmployeeInput = s.next();
                        switch (EmployeeInput) {
                            case "01":
                                newAccess.UpdatePersonalInfo_01();
                                break;

                            case "02":
                                Application apply = new Application();
                                apply.ApplyNewLeave_02();
                                break;

                            case "03":
                                try {
                                    newAccess.CheckLeaveStatus_03();
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                                break;

                            default:
                                System.out.println("There is an error");
                        }

                    }
                }

                if (digit == 2) {
                    Scanner a = new Scanner(System.in);

                    System.out.print("Enter id without capital letters:");//username:matric_number
                    username = a.nextLine();
                    System.out.print("Enter password:");//password:ic
                    password = a.nextLine();
                    if (username.equals("admin_username") && password.equals("admin_password")) {//AFTER THE FIRST IF (USERNAME.EQUALS.....
                        System.out.println("Authentication Successful");
                        Admin admin = new Admin();
                        admin.displayAdminMenu();
                        System.out.println("Select [01-02] or type 00 to exit system : \n");
                        String AdminInput = a.next();
                        switch (AdminInput) {
                            case "01":
                                admin.PersonalInfo_01();
                                break;

                            case "02":
                                System.out.println("Opening Leave Application Request... ");
                                System.out.println();
                                Approval approv = new Approval();
                                Approval.approval();
                                break;

                            default:
                                System.out.println("\nAuthentication Failed, Please try again\n");

                        }

                    }
                }
            }
        }
        // write your code here

    }

