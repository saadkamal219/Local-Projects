import csv
import pandas as pd

print("\n\t|----------------------------------|")
print("\t|--|   Digital Voting Machine   |--|")
print("\t|__________________________________|\n")

fields_of_voter_registration = ['Name', 'NID', 'Sex', 'Date of Birth', 'Father name', 'Mother name', 'Password']
file_of_voter_registration = '/home/saad/Desktop/Digital_Voting _Machine/Voter_Information.csv'
file_of_candidate_registration = '/home/saad/Desktop/Digital_Voting _Machine/Candidate_Information.csv'
list_of_voter_registration = list()
dataframe_voter = pd.read_csv(file_of_voter_registration)
dataframe_candidate = pd.read_csv(file_of_candidate_registration)

def database_handling():

    print("Welcome to Database Management System (DBMS). Please choose your action.\n")
    print("\t1. Check null values")
    print("\t2. View database info")
    print("\t3. Exit DBMS mode")

    choice4 = int(input("\t>_ "))

    if choice4 == 1:
        print("Status of Voter Database\n")
        print(dataframe_voter.isnull().sum() / len(dataframe_voter)*100)
        print()
        
        print("Status of Candidate Database\n")
        print(dataframe_candidate.isnull().sum() / len(dataframe_candidate)*100)
        print()
        database_handling()

    elif choice4 == 2:
        print("Information of Voter Database\n")
        print(dataframe_voter.info())
        print()
        print("Information of Candidate Database\n")
        print(dataframe_candidate.info())
        print()
        database_handling()
    elif choice4 == 3:
        print()
        developer_choice()
    else:
        print("Invalid choice. Try again\n")
        database_handling()

def developer_choice():

    print("Welcome Administrator. Please choose your action.\n")
    print("\t1. View Voter List")
    print("\t2. View Candidate List")
    print("\t3. Delete from Voter List")
    print("\t4. Delete from Candidate List")
    print("\t5. Handel Database")
    print("\t5. Exit Developer mode")

    choice3 = int(input("\t>_ "))

    if choice3 == 1:
        print(dataframe_voter)
        print()
        developer_choice()
    elif choice3 == 2:
        print(dataframe_candidate)
        print()
        developer_choice()
    elif choice3 == 3:
        print()
        developer_choice()
    elif choice3 == 4:
        print()
        developer_choice()
    elif choice3 == 5:
        database_handling()

def developer_mode():

    print("\n\t|-------------------------------------|")
    print("\t|--|   Welcome to Developer Mode   |--|")
    print("\t|_____________________________________|\n")

    print("Hello Sir. Please enter your username and password to confirm your identity\n")
    usename = input("\tEnter admin username: ")
    adminpassword = input("\tEnter admin password: ")

    if usename == 'admin' and adminpassword == 'admin':
        
        developer_choice()

    elif usename != 'admin' and adminpassword == 'admin':
        print(usename, " not in record. You may have mistaken the username. Please try again.\n")
        developer_mode()
    elif usename == 'admin' and adminpassword != 'admin':
        print("Invalid password. You may have mistaken the passowrd. Please try again.\n")
        developer_mode()
    else:
        print(usename, " not in record and password is invalid. You may have mistaken the username and password. Please try again.\n")
        developer_mode()
        

def registration_panel():

    print("\n\t|------------------------------------------|")
    print("\t|--|   Welcome to Registration Portal   |--|")
    print("\t|__________________________________________|\n")

    name = input("\tEnter your name: ")
    nid = int(input("\tEnter your NID number: "))
    sex = input("\tEnter your sex: ")
    dob = input("\tEnter your date of birth: ")
    father_name = input("\tEnter your father name: ")
    mother_name = input("\tEnter your mother name: ")
    print("\tNow enter your passowrd. Password must not cross digit limit of 8. Use numerical numbers only.")
    password = int(input("\tEnter your password: "))

    record = [name, nid, sex, dob, father_name, mother_name, password]

    list_of_voter_registration.append(record)

    choice2 = input("\tYour records has been recorded. Do you want to finish the process? [y/n]: ")

    try:

        if choice2 == "y":

            # list_of_voter_registration.append(record)

            with open(file_of_voter_registration, 'a') as voter_csv_file:
                    
                csvWriter = csv.writer(voter_csv_file)
                # csvWriter.writerow(fields_of_voter_registration)
                csvWriter.writerows(list_of_voter_registration)
                
                df1 = pd.read_csv(file_of_voter_registration)
                check = df1.empty

                if check == False:

                    print("\n\tInformation successfully recorded\n")

                else:

                    print("\n\tError recording information\n")

    except:

        print("\tError transferring information.")

    finally:

        main_menu()

def main_menu():

        print("Enter your cooresponding number: \n")
        print("\t1. Voter Registration")
        print("\t2. Candidate Registration")
        print("\t3. Enter Developer mode")
        print("\t4. Return to main menu")

        choice1 = int(input("\t>_ "))

        if choice1 == 1:
          
            registration_panel()

        elif choice1 == 2:
            print("Welcome to candidate registration")
        elif choice1 == 3:

            developer_mode()

        elif choice1 == 4:
            print("Welcome to return to main menu")
        else:
            print("Invalid choice. Please Try again.")

while True:

    main_menu()    