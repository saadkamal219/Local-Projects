import java.util.Scanner;

public class Action_page {

    Action_page AI = new Action_page();

    public static Hospital_Server[]docList = new Hospital_Server[5];
    public static Hospital_Server[]patientList = new Hospital_Server[10];
    public static Hospital_Server[]userObjectionList = new Hospital_Server[3];
    public static int patientID;

    public static void title_box_Main_page() {

        System.out.println("\n\n\t\t\t----------------------------------------------------");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t|           Welcome to Medicare Hospital           |");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t----------------------------------------------------\n\n");

        System.out.println("\tWelcome to our hospitals data management section. Feel free to perform necessary activities\n");
        System.out.print("\tPlease verify your designation: \n");
        System.out.println("\n\t1: Docotr      2: Patient      3: Admin");

        System.out.println("\n\tPress [ CTRL + C ] to exit the portal and it is a pleassure to have you with us !!");

        System.out.print("\n\tEnter choice: ");
        
    }

    public static void title_box_Admin_page() {

        System.out.println("\n\n\t\t\t----------------------------------------------------");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t|             Welcome to Admin Pannel              |");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t----------------------------------------------------\n\n");
        
    }

    public static void title_box_Doctor_page() {

        System.out.println("\n\n\t\t\t----------------------------------------------------");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t|            Welcome to Doctor Pannel              |");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t----------------------------------------------------\n\n");

    }

    public static void title_box_Patient_page() {

        System.out.println("\n\n\t\t\t----------------------------------------------------");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t|            Welcome to Patient Pannel             |");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t----------------------------------------------------\n\n");

    }

    public static void Main_page_choice() {

        title_box_Main_page();

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Doctor doctor = new Doctor();
                // doctor.go_to_doctor();
                title_box_Doctor_page();
                doctor_page_choice();
                login_doctor();
                break;

            case 2:
                // patient_portal();
                // System.out.println("Go to patient portal");
                title_box_Patient_page();
                patient_page_choice();
                break;

            case 3:
                // Admin admin = new Admin();
                // admin.go_to_admin();
                title_box_Admin_page();
                admin_page_choice();
                login_admin();

                break;

            default: 
                System.out.println("\n\tInvalid choice. Try Again\n");
                Main_page_choice();
                break;
                
        }

    }

    public static void admin_page_choice() {

        Scanner scanner = new Scanner(System.in);

        // Main_page mpc = new Main_page();

        System.out.println("\tAuthorized access only !!");
        System.out.println("\n\tChoose option: ");
        System.out.println("\n\t1: Login      2: Exit");

        System.out.print("\n\tEnter choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                login_admin();
                break;
            case 2: 
                Main_page_choice();break;
        
            default: 
                System.out.println("\n\tInvalid choice. Try again.\n");
                admin_page_choice();
                break;
        }

    }

    public static void doctor_page_choice() {

        Scanner scanner = new Scanner(System.in);

        // Main_page mpc = new Main_page();

        System.out.println("\tDoctors access only !!");

        System.out.println("\n\tChoose option: ");
        System.out.println("\n\t1: Login      2: Exit");

        System.out.print("\n\tEnter choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                login_doctor();
                break;
            case 2: 
                Main_page_choice();break;
        
            default: 
                System.out.println("\n\tInvalid choice. Try again.\n");
                doctor_page_choice();
                break;
        }

    }

    public static void patient_page_choice() {

        Scanner scanner = new Scanner(System.in);

        // Main_page mpc = new Main_page();

        System.out.println("\tWelcome to Patient Portal !!");

        System.out.println("\n\tChoose option: ");
        System.out.println("\n\t1: Add appointment      2: View appointment      3: Exit");

        System.out.print("\n\tEnter choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
            
                System.out.println(); 
                
                int count = 0;

                for (int i = 0; i < patientList.length; i++) {

                    if (patientList[i].getpatientContactNumber().equalsIgnoreCase("empty")) {
                        
                    }
                    else {
                        count++;
                    }

                }

                if (count >= 10) {
                    
                    System.out.println("\n\tPatient count has reached out. Please contact later.\n");
                    Main_page_choice();

                }
                else{

                    scanner.nextLine();

                    for (int i = 0; i < patientList.length; i++) {

                        if (patientList[i].getpatientContactNumber().equalsIgnoreCase("empty")) {
                            
                            System.out.print("\tEnter your name: ");
                            String newPatientName = scanner.nextLine();
                            patientList[i].setpatientName(newPatientName);
                            System.out.println();

                            System.out.print("\tEnter your contact number: ");
                            String newPatientContactNumber = scanner.nextLine();
                            patientList[i].setpatientContactNumber(newPatientContactNumber);
                            System.out.println();
                            
                            patientID = 2009;
                            patientList[i].setappointment(patientID);

                            System.out.print("\tEnter doctor initial: ");
                            String setdocinit = scanner.nextLine();
                            patientList[i].setdocInitial(setdocinit);
    
                        }
    
                    }

                    System.out.println("\n\tInformation added Successfully !!!");

                    System.out.println("\n\tYour appointment ID is " + patientID);

                    System.out.print("\n\tEnter Y to continue or press X to exit: ");

                    String choice4 = scanner.next();

                    if (choice4.equalsIgnoreCase("Y")){
                        title_box_Patient_page();
                        patient_page_choice();
                    }
                    else {
                        Main_page_choice();
                    }

                }

                break;

            case 2: 

                scanner.nextLine();

                int error = 0;

                System.out.print("\n\tEnter your appointment ID: ");
                int appointmentid = scanner.nextInt();
                System.out.println();

                for (int i = 0; i < patientList.length; i++){

                    if (patientList[i].getappointment() == appointmentid) {
                        
                        System.out.println("\n\t\t\t----------------------------------------------------");
                        // System.out.println("\t\t\t|                                                  |");
                        System.out.println("\t\t\t|                Patient Information               |");
                        // System.out.println("\t\t\t|                                                  |");
                        System.out.println("\t\t\t----------------------------------------------------\n");

                        System.out.println("\tName: " + patientList[i].getpatientName() + "\t\tContact Number: " + patientList[i].getpatientContactNumber() + "\t\tAppointment ID: " + patientList[i].getappointment() + "\t\tDoctor Initial: " + patientList[i].getdocInitial() + "\n");

                        System.out.println();
                        System.out.print("\tEnter Y to continue or press X to exit: ");

                        String choice2 = scanner.next();

                        if (choice2.equalsIgnoreCase("Y")){
                            title_box_Patient_page();
                            patient_page_choice();
                        }
                        else {
                            Main_page_choice();
                        }

                    }
                    else {
                        error++;
                    }

                }

                if (error >= 10) {

                    System.out.println("\n\tInformation not found");

                    System.out.print("\n\tEnter Y to continue or press X to exit: ");

                    String choice3 = scanner.next();

                    if (choice3.equalsIgnoreCase("Y")){
                        title_box_Patient_page();
                        patient_page_choice();
                    }
                    else {
                        Main_page_choice();
                    }
                    
                }
                
                break;
            case 3:
                Main_page_choice();
                break;
        
            default: 
                System.out.println("\n\tInvalid choice. Try again.\n");
                patient_page_choice();
                break;
        }

    }
    

    public static void login_admin() {

        Scanner scanner = new Scanner(System.in);

        int[]adminIdList = new int[100];
        int[]adminPinList = new int[100];

        adminIdList[0] = 21215;
        adminPinList[0] = 14729;
        
        System.out.print("\n\tEnter your Admin ID: ");
        int userid = scanner.nextInt();

        System.out.print("\n\tEnter your Admin PIN: ");
        int pin = scanner.nextInt();

        if (adminIdList[0] != userid && adminPinList[0] == pin) {
            System.out.println("\n\tIncorrect Admin ID. Try again.\n");
            login_admin();
        }
        else if (adminIdList[0] == userid && adminPinList[0] != pin) {
            System.out.println("\n\tIncorrect Admin PIN. Try again.\n");
            login_admin();
        }
        else if (adminIdList[0] != userid && adminPinList[0] != pin) {
            System.out.println("\n\tIncorrect Admin ID & PIN. Try again.\n");
            login_admin();
        }
        else {
            title_box_Admin_page();
            adminFunctionChoices();
        }

    }

    public static void login_doctor() {

        Scanner scanner = new Scanner(System.in);

        int[]doctorIdList = new int[100];
        int[]doctorPinList = new int[100];

        doctorIdList[0] = 212;
        doctorPinList[0] = 732;
        
        System.out.print("\n\tEnter your Doctor ID: ");
        int userid = scanner.nextInt();

        System.out.print("\n\tEnter your Doctor PIN: ");
        int pin = scanner.nextInt();

        int wrngInput = 0;

        if (doctorIdList[0] != userid && doctorPinList[0] == pin) {

            System.out.println("\n\tIncorrect doctor ID. Try again.\n");
            // wrngID++;
            login_doctor();

        }
        else if (doctorIdList[0] == userid && doctorPinList[0] != pin) {

            System.out.println("\n\tIncorrect doctor PIN. Try again.\n");
            // wrngPin++;
            login_doctor();

        }
        else if (doctorIdList[0] != userid && doctorPinList[0] != pin) {

            System.out.println("\n\tIncorrect doctor ID & PIN. Try again.\n");
            // wrngIDandPin++;
            login_doctor();

        }
        else {
            // Doctor_function df = new Doctor_function();
            // df.doctor_function();
            title_box_Doctor_page();
            doctor_function_options();
        }

    }

    public static void adminFunctionChoices() {

        Scanner scanner = new Scanner(System.in);
        // Admin_function af = new Admin_function();

        System.out.println("\tHello Sir, Welcome to Admin Pannel");
        System.out.println("\n\tAuthorized functionalities you may choose: ");
        System.out.println("\n\t1: Appoint Doctor      2: Release Doctor      3: Objection Box      4: Exit");

        System.out.print("\n\tEnter choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:

                int docCount = 0;

                for (int i = 0; i < docList.length; i++) {

                    if (docList[i].getdocName().equalsIgnoreCase("Released")) {
                        
                        scanner.nextLine();
                            
                            System.out.print("\n\tEnter doctor name: ");
                            String newDocName = scanner.nextLine();
                            docList[i].setdocName(newDocName);

                            System.out.print("\n\tEnter doctor designation: ");
                            String newDocDesignation = scanner.nextLine();
                            docList[i].setdocDesignation(newDocDesignation);

                            System.out.print("\n\tEnter doctor contact number: ");
                            String newDocContactNumber = scanner.nextLine();
                            docList[i].setdoccontactNumber(newDocContactNumber);

                            System.out.println("\n\tInformation of Mr. " + docList[i].getdocName() + " has been added successfully\n");


                    System.out.print("\tEnter Y to continue or press X to exit: ");

                    String choice2 = scanner.next();

                    if (choice2.equalsIgnoreCase("Y")){
                        title_box_Admin_page();
                        adminFunctionChoices();
                    }
                    else {
                        Main_page_choice();
                    }

                    }
                    else {
                        docCount++;
                    }
                }

                if (docCount >= 5) {
                    System.out.println("\n\tWe reached our doctors limit according to our accomodation budget. You have to release at least one doctor to appoint new doctor. !!\n");

                    System.out.print("\tEnter Y to continue or press X to exit: ");

                    String choice2 = scanner.next();

                    if (choice2.equalsIgnoreCase("Y")){
                        title_box_Admin_page();
                        adminFunctionChoices();
                    }
                    else {
                        Main_page_choice();
                    }
                }

                break;
            case 2:
            
                scanner.nextLine();

                System.out.print("\n\tEnter the doctor name to release: ");
                String poorDoc = scanner.nextLine();

                for (int i = 0; i < docList.length; i++) {

                    if (docList[i].getdocName().equalsIgnoreCase(poorDoc)) {
                        
                        docList[i].setdocName("Released");
                        docList[i].setdocDesignation("null");
                        docList[i].setdoccontactNumber("None");

                        System.out.println("\n\t" + poorDoc + " has been respectfully released from Medicare Hospital !!");

                        System.out.print("\n\tEnter Y to continue or press X to exit: ");

                        String choice2 = scanner.next();

                        if (choice2.equalsIgnoreCase("Y")){
                            title_box_Admin_page();
                            adminFunctionChoices();
                        }
                        else {
                            Main_page_choice();
                        }

                    }

                    else {

                        System.out.println("\n\t" + poorDoc + " does not belong from Medicare Hospital !!");

                        System.out.print("\n\tEnter Y to continue or press X to exit: ");

                        String choice2 = scanner.next();

                        if (choice2.equalsIgnoreCase("Y")){
                            title_box_Admin_page();
                            adminFunctionChoices();
                        }
                        else {
                            Main_page_choice();
                        }

                    }

                }

                break;
            case 3:
            
                System.out.println("\n\t\t\t----------------------------------------------------");
                System.out.println("\t\t\t|                   Objection Box                  |");
                System.out.println("\t\t\t----------------------------------------------------\n");

                for (int i = 0; i < userObjectionList.length; i++) {

                    System.out.println("\n\t" + userObjectionList[i].getUserObjection() + "\n");

                }

                System.out.print("\n\tEnter Y to continue or press X to exit: ");

                String choice2 = scanner.next();

                if (choice2.equalsIgnoreCase("Y")){
                    title_box_Admin_page();
                    adminFunctionChoices();
                }
                else {
                    Main_page_choice();
                }
            
                break;
            case 4:
                Main_page_choice();
                break;
        
            default: System.out.println("\n\tInvalid Choice. Try again.\n");
                title_box_Admin_page();
                adminFunctionChoices();
                break;
        }
        
    }

    public static void doctor_function_options() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\tHello Doctor, Welcome to Doctor Pannel");
        System.out.println("\n\tFacilities for doctors you may choose: ");
        System.out.println("\n\t1: View all Doctors      2: Edit information      3: Appointment queue      4: Exit");

        System.out.print("\n\tEnter choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:

                System.out.println("\n\t\t\t----------------------------------------------------");
                // System.out.println("\t\t\t|                                                  |");
                System.out.println("\t\t\t|                    Doctor List                   |");
                // System.out.println("\t\t\t|                                                  |");
                System.out.println("\t\t\t----------------------------------------------------\n");

                for (int i = 0; i < docList.length; i++) {

                    System.out.println("\tName: " + docList[i].getdocName() + "\t\tDesignation: " + docList[i].getdocDesignation() + "\t\tContact Number: " + docList[i].getdoccontactNumber() + "\n");

                }
                System.out.println();
                System.out.print("\tEnter Y to continue or press X to exit: ");

                String choice2 = scanner.next();

                if (choice2.equalsIgnoreCase("Y")){
                    title_box_Doctor_page();
                    doctor_function_options();
                }
                else {
                    Main_page_choice();
                }

                break;

            case 2: 
                
                scanner.nextLine();    

                System.out.print("\n\tEnter your name: ");
                String name = scanner.nextLine();
                
                int errorcount = 0;

                for (int i = 0; i < docList.length; i++) {

                    if (docList[i].getdocName().equalsIgnoreCase(name)) {
                        
                        System.out.print("\n\tEdit name or write the existing name: ");
                        String newName = scanner.nextLine();
                        docList[i].setdocName(newName);

                        System.out.print("\n\tEdit designation or write the existing designation: ");
                        String newDesignation = scanner.nextLine();
                        docList[i].setdocDesignation(newDesignation);

                        System.out.print("\n\tEdit phone number or write the existing number: ");
                        String newNumber = scanner.next();
                        docList[i].setdoccontactNumber(newNumber);

                    }

                    else {
                        errorcount++;
                    }

                }

                if (errorcount == 5) {

                    System.out.println("\n\tInformation not found");

                    System.out.print("\n\tEnter Y to continue or press X to exit: ");

                    String choice3 = scanner.next();

                    if (choice3.equalsIgnoreCase("Y")){
                        title_box_Doctor_page();
                        doctor_function_options();
                    }
                    else {
                        Main_page_choice();
                    }

                }
                else {

                    System.out.println("\n\tInformation added Successfully !!!");

                    System.out.print("\n\tEnter Y to continue or press X to exit: ");

                    String choice4 = scanner.next();

                    if (choice4.equalsIgnoreCase("Y")){
                        title_box_Doctor_page();
                        doctor_function_options();
                    }
                    else {
                        Main_page_choice();
                    }

                }

                break;

            case 3: 

                scanner.nextLine();

                System.out.print("\n\tEnter your doctor initial: ");
                String searchinit = scanner.nextLine();
                int total = 0;

                System.out.println("\n\t\t\t----------------------------------------------------");
                System.out.println("\t\t\t|                 Appointment Queue                |");
                System.out.println("\t\t\t----------------------------------------------------\n");

                for (int i = 0; i < patientList.length; i++) {

                    if (patientList[i].getdocInitial().equalsIgnoreCase(searchinit)) {
                        
                        System.out.println("\tPatient Name: " + patientList[i].getpatientName() + "\t\tPatient Contact Number: " + patientList[i].getpatientContactNumber() + "\t\tAppointment ID: " + patientList[i].getappointment() + "\n");

                        total++;

                    }

                }

                System.out.println("\tTotal count: " + total + "\n");

                System.out.print("\n\tEnter Y to continue or press X to exit: ");

                String choice4 = scanner.next();

                if (choice4.equalsIgnoreCase("Y")){
                    title_box_Doctor_page();
                    doctor_function_options();
                }
                else {
                    Main_page_choice();
                }

                break;

            case 4: 

                Main_page_choice();
                break;

            default: 
                System.out.println("\n\tInvalid choice. Try again.\n");
                title_box_Doctor_page();
                doctor_function_options();
                break;
        }

    }
    
    public static void main(String[] args) {
        
        String docName, docDesignation, docContactNumber, patientName, patientContactNumber, appointment, userObjection;

        docList[0] = new Hospital_Server("AKM Fazlul Haque", "Colorectal  Surgeon", "01901010101");
        docList[1] = new Hospital_Server("Professor Aminul", "Liver    Specialist", "01810101010");
        docList[2] = new Hospital_Server("Dr. Jahangir Alm", "Medicine Specialist", "01610101010");
        docList[3] = new Hospital_Server("Dr.Nesrudin Ahmd", "Medicine Specialist", "01710101010");
        docList[4] = new Hospital_Server("Dr. Ferdous  Ara", "Medicine Specialist", "01515151515");

        patientList[0] = new Hospital_Server("Sakib Dewan", "01926600000", 2000, "JA");
        patientList[1] = new Hospital_Server("Mehedi Naim", "01856565656", 2001, "AKMFH");
        patientList[2] = new Hospital_Server("Parvej Khan", "01756565656", 2002, "PA");
        patientList[3] = new Hospital_Server("Khaled Alif", "01556565656", 2003, "NA");
        patientList[4] = new Hospital_Server("Rafi Likhon", "01778787878", 2004, "FA");
        patientList[5] = new Hospital_Server("Mazhr Fahim", "01656565656", 2005, "JA");
        patientList[6] = new Hospital_Server("Sayem Ahmed", "01363636363", 2006, "AKMFH");
        patientList[7] = new Hospital_Server("Sayma Jannt", "01802020202", 2007, "FA");
        patientList[8] = new Hospital_Server("Jarrin Khan", "01703030303", 2008, "FA");
        patientList[9] = new Hospital_Server("empty", "empty", 0, "empty");
        
        userObjectionList[0] = new Hospital_Server("There are no children specialist in this hospital.");
        userObjectionList[1] = new Hospital_Server("Hospital management should add a portal for managers and accountants.");
        userObjectionList[2] = new Hospital_Server("Insufficience of doctors.");

        Main_page_choice();

    }

}
