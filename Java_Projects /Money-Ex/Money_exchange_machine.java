import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Money_exchange_machine {

    // File myfile = new File("Taka.txt");

    public static double[]Machine_balance = new double [1];
    public static int chanceOfLogin = 3;
    
    public static void Main_Menu_Header(){

        System.out.println("\n\n\t\t\t----------------------------------------------------");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t|               Welcome to Money-Ex                |");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t----------------------------------------------------\n\n");

        System.out.println("\tWelcome to our Money Exchange Machine. Please Enter your designation: \n");
        System.out.println("\n\t1: Customer      2: Admin      3: Objection Box      3: Exit\n");
        System.out.println("\n\tPress [ CTRL + C ] to exit the portal and it is a pleassure to have you with us !!");

        System.out.print("\n\tEnter choice: ");

    }

    public static void Customer_Page_Header(){

        System.out.println("\n\n\t\t\t----------------------------------------------------");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t|       Welcome to Money-Ex Customer Section       |");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t----------------------------------------------------\n\n");

        System.out.println("\tWelcome to our Money Exchange Machine. Please choose your currency region: \n");
        // System.out.println("\n\tCurreny\t\tRegion\t\tExchange Rate [ 1 Taka ]\n");
        System.out.println("\n\t1: USD    [ United States --> 1 USD = 104.20 Taka ]\n\n\t2: Rupee  [ India --> 1 Rupee = 1.27 Taka ]\n\n\t3: Rupee  [ Pakistan --> 1 Rupee = 0.46 Taka ]\n\n\t4: Euro   [ Europe --> 1 Euro = 111.87 Taka ]\n\n\t5: Riyal  [ Qatar --> 1 Riyal = 28.62 Taka ]\n\n\t6: Yen    [ Japan --> 1 Yen = 0.79 Taka ]\n\n\t7: Yuan   [ Chaina --> 1 Yuan = 15.37 Taka ]\n\n\t8: Dirham [ Dubai --> 1 Dirham = 28.37 Taka ]\n\n\t9: Ruble  [ Russia --> 1 Ruble = 1.50 Taka ]\n\n\t10: Exit");
        System.out.println("\n\tPress [ CTRL + C ] to exit the portal and it is a pleassure to have you with us !!");

        System.out.print("\n\tEnter choice: ");

    }

    public static void Admin_Page_Header(){

        System.out.println("\n\n\t\t\t----------------------------------------------------");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t|        Welcome to Money-Ex Admin Section         |");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t|                    Login Page                    |");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t----------------------------------------------------\n\n");

        System.out.println("\tWelcome to Admin Pannel. Please login: \n");
        // System.out.println("\n\tCurreny\t\tRegion\t\tExchange Rate [ 1 Taka ]\n");
        System.out.println("\n\t1: Login      2: Exit\n");
        System.out.println("\n\tPress [ CTRL + C ] to exit the portal and it is a pleassure to have you with us !!");

        System.out.print("\n\tEnter choice: ");

    }

    public static void Main_Menu_Choice(){

        Scanner scanner = new Scanner(System.in);
        File myfile = new File("objection.txt");

        Main_Menu_Header();

        int choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                Customer_Page_Choice();
                break;
            case 2:
                Admin_Page_Choice();
                break;
            case 3:
                System.out.println("\n\tPlease write your objectoins and once again....\n\tIt's a pleasure to have you with us.\n");
                scanner.nextLine();
                System.out.print("\tWrite Objection: ");
                String objection = scanner.nextLine();

                try {
                    
                    FileWriter filewriter = new FileWriter("objection.txt");
                    filewriter.write(objection);
                    filewriter.close();
                } 
                catch (Exception e) {
                    System.out.println("\n\tError while uploading your objection. Try again.\n");
                    Main_Menu_Choice();
                }
                finally{
                    Main_Menu_Choice();
                }

                break;
            case 4:
                break;
            default: 
                System.out.println("\n\tInvalid choice. Try Again.\n");
                Main_Menu_Choice();
                break;
        }

    }

    public static void Customer_Page_Choice(){

        File myFile = new File("Taka.txt");
        
        Scanner scanner = new Scanner(System.in);

        Customer_Page_Header();

        int choice2 = scanner.nextInt();

        switch (choice2) {

            case 1:

                System.out.println("\n\n\t\t\t----------------------------------------------------");
                System.out.println("\t\t\t|                   USD to Taka                    |");
                System.out.println("\t\t\t----------------------------------------------------\n\n");
        
                System.out.println("\t1 USD = 104.20 Taka: \n");
                System.out.print("\tEnter the amount of money to be exchanged ( in USD ): ");
                double amount = scanner.nextDouble();

                double temp = amount * 104.20;

                if (temp > Machine_balance[0]) {
                    
                    System.out.println("\n\tInsufficient Balance in the server. Please wait for an admin to fix the prolbem. Thank you.");
                    Main_Menu_Choice();

                }
                else {

                    System.out.println("\n\tTotal amount is: " + temp + " Taka");
                    System.out.println("\n\tPress 1 to withdraw the amount");
                    System.out.println("\n\t1: Withdraw      2: Exit\n");

                    System.out.print("\n\tEnter choice: ");

                    int innerChoice = scanner.nextInt();

                    switch (innerChoice) {

                        case 1:
                        
                            System.out.println("\n\tExchange and Withdraw Successfull !!");
                            System.out.println("\n\tTotal Amount: " + temp + " Taka\n");

                            Machine_balance[0] = Machine_balance[0] - temp;

                            System.out.println("\n\tEnter choice to continue the program: ");
                            System.out.println("\n\t1: Continue      2: Exit\n");

                            System.out.print("\n\tEnter choice: ");

                            int outChoice = scanner.nextInt();

                            switch (outChoice) {
                                case 1:

                                    Main_Menu_Choice();
                                    break;

                                case 2: 

                                    break;

                                default: 
                                    break;
                            }

                            break;
                        
                        case 2:

                            System.out.println("\n\tThanks for using our portal.");
                            Main_Menu_Choice();
                            break;
                    
                        default:
                            
                            System.out.println("\n\tInvalid Choice. Try again."); 
                            Customer_Page_Choice();
                            break;

                    }

                }

                break;

            case 2:

                System.out.println("\n\n\t\t\t----------------------------------------------------");
                System.out.println("\t\t\t|                Indian Rupee to Taka                |");
                System.out.println("\t\t\t----------------------------------------------------\n\n");
        
                System.out.println("\t1 IND-Rupee = 1.27 Taka: \n");
                System.out.print("\tEnter the amount of money to be exchanged ( in Rupee ): ");
                double amount1 = scanner.nextDouble();

                double temp1 = amount1 * 1.27;

                if (temp1 > Machine_balance[0]) {
                    
                    System.out.println("\n\tInsufficient Balance in the server. Please wait for an admin to fix the prolbem. Thank you.");
                    Main_Menu_Choice();

                }
                else {

                    System.out.println("\n\tTotal amount is: " + temp1 + " Taka");
                    System.out.println("\n\tPress 1 to withdraw the amount");
                    System.out.println("\n\t1: Withdraw      2: Exit\n");

                    System.out.print("\n\tEnter choice: ");

                    int innerChoice = scanner.nextInt();

                    switch (innerChoice) {

                        case 1:
                        
                            System.out.println("\n\tExchange and Withdraw Successfull !!");
                            System.out.println("\n\tTotal Amount: " + temp1 + " Taka\n");

                            Machine_balance[0] = Machine_balance[0] - temp1;

                            System.out.println("\n\tEnter choice to continue the program: ");
                            System.out.println("\n\t1: Continue      2: Exit\n");

                            System.out.print("\n\tEnter choice: ");

                            int outChoice = scanner.nextInt();

                            switch (outChoice) {
                                case 1:

                                    Main_Menu_Choice();
                                    break;

                                case 2: 

                                    break;

                                default: 
                                    break;
                            }

                            break;
                        
                        case 2:

                            System.out.println("\n\tThanks for using our portal.");
                            Main_Menu_Choice();
                            break;
                    
                        default:
                            
                            System.out.println("\n\tInvalid Choice. Try again."); 
                            Customer_Page_Choice();
                            break;

                    }

                }

                break;

            case 3:

                System.out.println("\n\n\t\t\t----------------------------------------------------");
                System.out.println("\t\t\t|               Pakistani Rupee to Taka                |");
                System.out.println("\t\t\t----------------------------------------------------\n\n");
        
                System.out.println("\t1 PAK-Rupee = 0.46 Taka: \n");
                System.out.print("\tEnter the amount of money to be exchanged ( in Rupee ): ");
                double amount2 = scanner.nextDouble();

                double temp2 = amount2 * 0.46;

                if (temp2 > Machine_balance[0]) {
                    
                    System.out.println("\n\tInsufficient Balance in the server. Please wait for an admin to fix the prolbem. Thank you.");
                    Main_Menu_Choice();

                }
                else {

                    System.out.println("\n\tTotal amount is: " + temp2 + " Taka");
                    System.out.println("\n\tPress 1 to withdraw the amount");
                    System.out.println("\n\t1: Withdraw      2: Exit\n");

                    System.out.print("\n\tEnter choice: ");

                    int innerChoice = scanner.nextInt();

                    switch (innerChoice) {

                        case 1:
                        
                            System.out.println("\n\tExchange and Withdraw Successfull !!");
                            System.out.println("\n\tTotal Amount: " + temp2 + " Taka\n");

                            Machine_balance[0] = Machine_balance[0] - temp2;

                            System.out.println("\n\tEnter choice to continue the program: ");
                            System.out.println("\n\t1: Continue      2: Exit\n");

                            System.out.print("\n\tEnter choice: ");

                            int outChoice = scanner.nextInt();

                            switch (outChoice) {
                                case 1:

                                    Main_Menu_Choice();
                                    break;

                                case 2: 

                                    break;

                                default: 
                                    break;
                            }

                            break;
                        
                        case 2:

                            System.out.println("\n\tThanks for using our portal.");
                            Main_Menu_Choice();
                            break;
                    
                        default:
                            
                            System.out.println("\n\tInvalid Choice. Try again."); 
                            Customer_Page_Choice();
                            break;

                    }

                }

                break;

            case 4:

                System.out.println("\n\n\t\t\t----------------------------------------------------");
                System.out.println("\t\t\t|                   Euro to Taka                    |");
                System.out.println("\t\t\t----------------------------------------------------\n\n");
        
                System.out.println("\t1 USD = 111.87 Taka: \n");
                System.out.print("\tEnter the amount of money to be exchanged ( in Euro ): ");
                double amount3 = scanner.nextDouble();

                double temp3 = amount3 * 104.20;

                if (temp3 > Machine_balance[0]) {
                    
                    System.out.println("\n\tInsufficient Balance in the server. Please wait for an admin to fix the prolbem. Thank you.");
                    Main_Menu_Choice();

                }
                else {

                    System.out.println("\n\tTotal amount is: " + temp3 + " Taka");
                    System.out.println("\n\tPress 1 to withdraw the amount");
                    System.out.println("\n\t1: Withdraw      2: Exit\n");

                    System.out.print("\n\tEnter choice: ");

                    int innerChoice = scanner.nextInt();

                    switch (innerChoice) {

                        case 1:
                        
                            System.out.println("\n\tExchange and Withdraw Successfull !!");
                            System.out.println("\n\tTotal Amount: " + temp3 + " Taka\n");

                            Machine_balance[0] = Machine_balance[0] - temp3;

                            System.out.println("\n\tEnter choice to continue the program: ");
                            System.out.println("\n\t1: Continue      2: Exit\n");

                            System.out.print("\n\tEnter choice: ");

                            int outChoice = scanner.nextInt();

                            switch (outChoice) {
                                case 1:

                                    Main_Menu_Choice();
                                    break;

                                case 2: 

                                    break;

                                default: 
                                    break;
                            }

                            break;
                        
                        case 2:

                            System.out.println("\n\tThanks for using our portal.");
                            Main_Menu_Choice();
                            break;
                    
                        default:
                            
                            System.out.println("\n\tInvalid Choice. Try again."); 
                            Customer_Page_Choice();
                            break;

                    }

                }

                break;

            case 5:

                System.out.println("\n\n\t\t\t----------------------------------------------------");
                System.out.println("\t\t\t|                   Riyal to Taka                    |");
                System.out.println("\t\t\t----------------------------------------------------\n\n");
        
                System.out.println("\t1 Qatar Riyal = 28.62 Taka: \n");
                System.out.print("\tEnter the amount of money to be exchanged ( in Riyal ): ");
                double amount4 = scanner.nextDouble();

                double temp4 = amount4 * 28.62;

                if (temp4 > Machine_balance[0]) {
                    
                    System.out.println("\n\tInsufficient Balance in the server. Please wait for an admin to fix the prolbem. Thank you.");
                    Main_Menu_Choice();

                }
                else {

                    System.out.println("\n\tTotal amount is: " + temp4 + " Taka");
                    System.out.println("\n\tPress 1 to withdraw the amount");
                    System.out.println("\n\t1: Withdraw      2: Exit\n");

                    System.out.print("\n\tEnter choice: ");

                    int innerChoice = scanner.nextInt();

                    switch (innerChoice) {

                        case 1:
                        
                            System.out.println("\n\tExchange and Withdraw Successfull !!");
                            System.out.println("\n\tTotal Amount: " + temp4 + " Taka\n");

                            Machine_balance[0] = Machine_balance[0] - temp4;

                            System.out.println("\n\tEnter choice to continue the program: ");
                            System.out.println("\n\t1: Continue      2: Exit\n");

                            System.out.print("\n\tEnter choice: ");

                            int outChoice = scanner.nextInt();

                            switch (outChoice) {
                                case 1:

                                    Main_Menu_Choice();
                                    break;

                                case 2: 

                                    break;

                                default: 
                                    break;
                            }

                            break;
                        
                        case 2:

                            System.out.println("\n\tThanks for using our portal.");
                            Main_Menu_Choice();
                            break;
                    
                        default:
                            
                            System.out.println("\n\tInvalid Choice. Try again."); 
                            Customer_Page_Choice();
                            break;

                    }

                }

                break;

            case 6:

                System.out.println("\n\n\t\t\t----------------------------------------------------");
                System.out.println("\t\t\t|                   Yen to Taka                    |");
                System.out.println("\t\t\t----------------------------------------------------\n\n");
        
                System.out.println("\t1 Yen = 0.79 Taka: \n");
                System.out.print("\tEnter the amount of money to be exchanged ( in Yen ): ");
                double amount5 = scanner.nextDouble();

                double temp5 = amount5 * 0.79;

                if (temp5 > Machine_balance[0]) {
                    
                    System.out.println("\n\tInsufficient Balance in the server. Please wait for an admin to fix the prolbem. Thank you.");
                    Main_Menu_Choice();

                }
                else {

                    System.out.println("\n\tTotal amount is: " + temp5 + " Taka");
                    System.out.println("\n\tPress 1 to withdraw the amount");
                    System.out.println("\n\t1: Withdraw      2: Exit\n");

                    System.out.print("\n\tEnter choice: ");

                    int innerChoice = scanner.nextInt();

                    switch (innerChoice) {

                        case 1:
                        
                            System.out.println("\n\tExchange and Withdraw Successfull !!");
                            System.out.println("\n\tTotal Amount: " + temp5 + " Taka\n");

                            Machine_balance[0] = Machine_balance[0] - temp5;

                            System.out.println("\n\tEnter choice to continue the program: ");
                            System.out.println("\n\t1: Continue      2: Exit\n");

                            System.out.print("\n\tEnter choice: ");

                            int outChoice = scanner.nextInt();

                            switch (outChoice) {
                                case 1:

                                    Main_Menu_Choice();
                                    break;

                                case 2: 

                                    break;

                                default: 
                                    break;
                            }

                            break;
                        
                        case 2:

                            System.out.println("\n\tThanks for using our portal.");
                            Main_Menu_Choice();
                            break;
                    
                        default:
                            
                            System.out.println("\n\tInvalid Choice. Try again."); 
                            Customer_Page_Choice();
                            break;

                    }

                }

                break;

            case 7:

                System.out.println("\n\n\t\t\t----------------------------------------------------");
                System.out.println("\t\t\t|                   Yuan to Taka                    |");
                System.out.println("\t\t\t----------------------------------------------------\n\n");
        
                System.out.println("\t1 Yuan = 15.37 Taka: \n");
                System.out.print("\tEnter the amount of money to be exchanged ( in Yuan ): ");
                double amount6 = scanner.nextDouble();

                double temp6 = amount6 * 15.37;

                if (temp6 > Machine_balance[0]) {
                    
                    System.out.println("\n\tInsufficient Balance in the server. Please wait for an admin to fix the prolbem. Thank you.");
                    Main_Menu_Choice();

                }
                else {

                    System.out.println("\n\tTotal amount is: " + temp6 + " Taka");
                    System.out.println("\n\tPress 1 to withdraw the amount");
                    System.out.println("\n\t1: Withdraw      2: Exit\n");

                    System.out.print("\n\tEnter choice: ");

                    int innerChoice = scanner.nextInt();

                    switch (innerChoice) {

                        case 1:
                        
                            System.out.println("\n\tExchange and Withdraw Successfull !!");
                            System.out.println("\n\tTotal Amount: " + temp6 + " Taka\n");

                            Machine_balance[0] = Machine_balance[0] - temp6;

                            System.out.println("\n\tEnter choice to continue the program: ");
                            System.out.println("\n\t1: Continue      2: Exit\n");

                            System.out.print("\n\tEnter choice: ");

                            int outChoice = scanner.nextInt();

                            switch (outChoice) {
                                case 1:

                                    Main_Menu_Choice();
                                    break;

                                case 2: 

                                    break;

                                default: 
                                    break;
                            }

                            break;
                        
                        case 2:

                            System.out.println("\n\tThanks for using our portal.");
                            Main_Menu_Choice();
                            break;
                    
                        default:
                            
                            System.out.println("\n\tInvalid Choice. Try again."); 
                            Customer_Page_Choice();
                            break;

                    }

                }

                break;

            case 8:

                System.out.println("\n\n\t\t\t----------------------------------------------------");
                System.out.println("\t\t\t|                   Dirham to Taka                    |");
                System.out.println("\t\t\t----------------------------------------------------\n\n");
        
                System.out.println("\t1 Dirham = 28.37 Taka: \n");
                System.out.print("\tEnter the amount of money to be exchanged ( in Dirham ): ");
                double amount7 = scanner.nextDouble();

                double temp7 = amount7 * 28.37;

                if (temp7 > Machine_balance[0]) {
                    
                    System.out.println("\n\tInsufficient Balance in the server. Please wait for an admin to fix the prolbem. Thank you.");
                    Main_Menu_Choice();

                }
                else {

                    System.out.println("\n\tTotal amount is: " + temp7 + " Taka");
                    System.out.println("\n\tPress 1 to withdraw the amount");
                    System.out.println("\n\t1: Withdraw      2: Exit\n");

                    System.out.print("\n\tEnter choice: ");

                    int innerChoice = scanner.nextInt();

                    switch (innerChoice) {

                        case 1:
                        
                            System.out.println("\n\tExchange and Withdraw Successfull !!");
                            System.out.println("\n\tTotal Amount: " + temp7 + " Taka\n");

                            Machine_balance[0] = Machine_balance[0] - temp7;

                            System.out.println("\n\tEnter choice to continue the program: ");
                            System.out.println("\n\t1: Continue      2: Exit\n");

                            System.out.print("\n\tEnter choice: ");

                            int outChoice = scanner.nextInt();

                            switch (outChoice) {
                                case 1:

                                    Main_Menu_Choice();
                                    break;

                                case 2: 

                                    break;

                                default: 
                                    break;
                            }

                            break;
                        
                        case 2:

                            System.out.println("\n\tThanks for using our portal.");
                            Main_Menu_Choice();
                            break;
                    
                        default:
                            
                            System.out.println("\n\tInvalid Choice. Try again."); 
                            Customer_Page_Choice();
                            break;

                    }

                }

                break;

            case 9:

                System.out.println("\n\n\t\t\t----------------------------------------------------");
                System.out.println("\t\t\t|                   Ruble to Taka                    |");
                System.out.println("\t\t\t----------------------------------------------------\n\n");
        
                System.out.println("\t1 Ruble = 1.50 Taka: \n");
                System.out.print("\tEnter the amount of money to be exchanged ( in Ruble ): ");
                double amount8 = scanner.nextDouble();

                double temp8 = amount8 * 1.50;

                if (temp8 > Machine_balance[0]) {
                    
                    System.out.println("\n\tInsufficient Balance in the server. Please wait for an admin to fix the prolbem. Thank you.");
                    Main_Menu_Choice();

                }
                else {

                    System.out.println("\n\tTotal amount is: " + temp8 + " Taka");
                    System.out.println("\n\tPress 1 to withdraw the amount");
                    System.out.println("\n\t1: Withdraw      2: Exit\n");

                    System.out.print("\n\tEnter choice: ");

                    int innerChoice = scanner.nextInt();

                    switch (innerChoice) {

                        case 1:
                        
                            System.out.println("\n\tExchange and Withdraw Successfull !!");
                            System.out.println("\n\tTotal Amount: " + temp8 + " Taka\n");

                            Machine_balance[0] = Machine_balance[0] - temp8;

                            System.out.println("\n\tEnter choice to continue the program: ");
                            System.out.println("\n\t1: Continue      2: Exit\n");

                            System.out.print("\n\tEnter choice: ");

                            int outChoice = scanner.nextInt();

                            switch (outChoice) {
                                case 1:

                                    Main_Menu_Choice();
                                    break;

                                case 2: 

                                    break;

                                default: 
                                    break;
                            }

                            break;
                        
                        case 2:

                            System.out.println("\n\tThanks for using our portal.");
                            Main_Menu_Choice();
                            break;
                    
                        default:
                            
                            System.out.println("\n\tInvalid Choice. Try again."); 
                            Customer_Page_Choice();
                            break;

                    }

                }

                break;

            case 10: 

                Main_Menu_Choice();
                break;

            default: System.out.println("\n\tInvalid Choice. Try again."); Customer_Page_Choice();
                break;
        }

    }

    public static void Admin_Page_Choice() {

        Scanner scanner = new Scanner(System.in);

        int admin_id = 212;
        int admin_password = 14729;

        Admin_Page_Header();

        int adminChoice = scanner.nextInt();

        switch (adminChoice) {
            case 1:
            
                if(chanceOfLogin > 0) {

                    System.out.print("\n\tEnter Admin ID: ");
                    int inputAdminID = scanner.nextInt();

                    System.out.print("\n\tEnter Admin Password: ");
                    int inputAdminPass = scanner.nextInt();

                    if (inputAdminID==admin_id && inputAdminPass==admin_password) {
                        Admin_Page_Workout();
                    }
                    else if (inputAdminID!=admin_id && inputAdminPass==admin_password) {
                        chanceOfLogin--;
                        System.out.println("\n\tIncorrect Admin Id. Try again.");
                        Admin_Page_Choice();
                    }
                    else if (inputAdminID==admin_id && inputAdminPass!=admin_password) {
                        chanceOfLogin--;
                        System.out.println("\n\tIncorrect Admin Password. Try again.");
                        Admin_Page_Choice();
                    }
                    else if (inputAdminID!=admin_id && inputAdminPass!=admin_password) {
                        chanceOfLogin--;
                        System.out.println("\n\tIncorrect Admin Id and Password. Try again.");
                        Admin_Page_Choice();
                    }

                }
                else{

                    System.out.println("\n\tAttemp Expired. Restart the Machine to login again or Use other functions");
                    System.out.println("\n\t1: Turn off      2: Main Menu\n");
                    System.out.print("\n\tEnter choice: ");

                    int choice5 = scanner.nextInt();

                    switch (choice5) {
                        case 1:    
                            break;
                        case 2:
                            Main_Menu_Choice();
                            break;
                        default:
                            Main_Menu_Choice();
                            break;
                    }

                }

                break;
            
            case 2: Main_Menu_Choice(); break;
        
            default: Main_Menu_Choice();
                break;
        }

    }

    public static void Admin_Page_Workout() {

        Scanner scanner = new Scanner(System.in);
        File myFile = new File("objection.txt");

        System.out.println("\n\n\t\t\t----------------------------------------------------");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t|          Welcome to Money-Ex Admin Portal        |");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t----------------------------------------------------\n\n");

        System.out.println("\tWelcome to our Money Exchange Machine Admin Portal. \n");
        System.out.println("\n\t1: View Balance      2: Add Balance      3: Objection Box      3: Exit\n");
        System.out.println("\n\tPress [ CTRL + C ] to exit the portal and it is a pleassure to have you with us !!");

        System.out.print("\n\tEnter choice: ");

            int innerAdminChoice = scanner.nextInt();

            switch (innerAdminChoice) {
                case 1:
                    System.out.println("\n\tCurrent Balance: " + Machine_balance[0] + " Taka\n");
                    System.out.print("\n\tPress 1 to continue or Press 2 to exit: ");
                            
                    int press = scanner.nextInt();

                    switch (press) {
                        case 1:
                            Admin_Page_Workout();
                            break;
                        case 2:
                            Main_Menu_Choice();
                            break;
                        default: Main_Menu_Choice();
                            break;
                    }

                    break;

                case 2:

                    System.out.print("\n\tEnter amount to add in the Machine Balance: ");
                    double addBalance = scanner.nextDouble();
                    Machine_balance[0] += addBalance;
                    System.out.println("\n\tSuccessfully added " + addBalance + " Taka to the Machine Balance !!!");
                    System.out.print("\n\tPress 1 to continue or Press 2 to exit: ");
                            
                    int press1 = scanner.nextInt();

                    switch (press1) {
                        case 1:
                            Admin_Page_Workout();
                            break;
                        case 2:
                            Main_Menu_Choice();
                            break;
                        default: Main_Menu_Choice();
                            break;
                    }

                    break;

                case 3:

                    System.out.println("\n\n\t\t\t----------------------------------------------------");
                    System.out.println("\t\t\t|                   Objection Box                    |");
                    System.out.println("\t\t\t----------------------------------------------------\n\n");

                    try {
                        
                        Scanner sc = new Scanner(myFile);

                        while (sc.hasNextLine()) {
                            
                            System.out.println("\n\t"+sc.nextLine()); 

                        }
                        System.out.println("\n");
                        sc.close();
                        Admin_Page_Workout();

                    } catch (Exception e) {
                        System.out.println("\n\tError, Try again");
                        Admin_Page_Workout();
                    }
                    
                    break;

                case 4: 
                    Main_Menu_Choice();
                    break;
                default: Main_Menu_Choice();
                    break;
            }

    }
    
    public static void main(String[] args) {
        
        // Scanner scanner = new Scanner(System.in);

        Machine_balance[0] = 10000000.00;

        Main_Menu_Choice();

    }

}
