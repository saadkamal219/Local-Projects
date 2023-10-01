import csv
import pandas as pd
import os
import sys
import warnings
from playsound import playsound as play

print("\n\t|----------------------------------|")
print("\t|--|   Digital Voting Machine   |--|")
print("\t|__________________________________|\n")

fields_of_voter_registration = ['Name', 'NID', 'Sex', 'Date_of_Birth', 'Father_name', 'Mother_name', 'Password']
file_of_voter_registration = '/home/saad/Desktop/Digital_Voting_Machine/Voter_Information.csv'
file_of_candidate_registration = '/home/saad/Desktop/Digital_Voting_Machine/Candidate_Information.csv'
list_of_voter_registration = list()
list_of_candidate_registration = list()
dataframe_voter = pd.read_csv(file_of_voter_registration)
# dataframe_candidate = pd.read_csv('/home/saad/Desktop/Digital_Voting _Machine/Candidate_Information.csv')
dataframe_candidate = pd.read_csv('/home/saad/Desktop/Digital_Voting_Machine/Candidate_Information.csv')
system_location = '/home/saad/Desktop/Digital_Voting_Machine/Digital_Voting_Machine.py'
reset_command = 'python3 system_location'
candidate_registration_completion = '/home/saad/Desktop/Digital_Voting_Machine/Candidate_registration_completion.mp3'

def candidate_registration():

    print("\n\t|----------------------------------------------------|")
    print("\t|--|   Welcome to Candidate Registration Portal   |--|")
    print("\t|____________________________________________________|\n")

    candidate_name = input("\tEnter your name: ")
    candidate_nid = int(input("\tEnter your NID number: "))
    candidate_symbol = input("\tEnter your symbol: ")
    candidate_party = input("\tEnter candidate's party name: ")
    candidate_position = input("\tEnter your position: ")
    candidate_region = input("\tEnter your region: ")

    candidate_record = [candidate_name, candidate_nid, candidate_symbol, candidate_party, candidate_position, candidate_region]

    list_of_candidate_registration.append(candidate_record)

    choice5 = input("\tYour records has been recorded. Do you want to finish the process? [y/n]: ")

    try:

        if choice5 == 'y':

            with open('/home/saad/Desktop/Digital_Voting_Machine/Candidate_Information.csv', 'a') as candidate_csv_file:

                csvWriter2 = csv.writer(candidate_csv_file)
                    # csvWriter.writerow(fields_of_voter_registration)
                csvWriter2.writerows(list_of_candidate_registration)
                    
                # df2 = pd.read_csv(list_of_candidate_registration)
                # check2 = df2.empty

                # if check2 == False:
                print("\nSuccessfully updated information. Now you are a nominating candidate for the voting system.\nWait for the admin for confirmation\nAll of this are managed by the admin and admin has the right not to select you as candidate or remove you from the voting system.\n")
                play(candidate_registration_completion)
                main_menu()

            # else:
                # print("\tError while transferring data. Please try again\n")
                # candidate_registration()

    except:
        print("\tError while recording data. Please try again.\n")
        candidate_registration()

    finally:
        main_menu()

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

    print("Welcome Administrator.For better performance, please restart the program once.")
    onOff = input("Restart the program [yes|no]: ")

    if onOff == 'yes':
        try:
            exit(1)
            warnings.filterwarnings('ignore')
        except SystemExit as e:
            print("System exited with code ", e, ". Please restart")
            warnings.filterwarnings('ignore')
    elif onOff == 'no':
        print("\n\tPlease choose your action.\n")
        print("\t1. View Voter List")
        print("\t2. View Candidate List")
        print("\t3. Delete from Voter List")
        print("\t4. Delete from Candidate List")
        print("\t5. Handel Database")
        print("\t6. Exit Developer mode")

    choice3 = int(input("\t>_ "))

    if choice3 == 1:
        print(dataframe_voter)
        # os.system('cat /home/saad/Desktop/Digital_Voting_Machine/Voter_Information.csv')
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
                    os.system('python3 /home/saad/Desktop/Digital_Voting_Machine/Digital_Voting_Machine.py')

                else:

                    print("\n\tError recording information\n")
                    registration_panel()

    except:

        print("\tError transferring information.")
        registration_panel()

    finally:

        main_menu()

def main_menu():

        print("Enter your cooresponding number: \n")
        print("\t1. Voter Registration")
        print("\t2. Candidate Registration")
        print("\t3. Enter Developer mode")
        print("\t4. Exit main menu")

        choice1 = int(input("\t>_ "))

        if choice1 == 1:
          
            registration_panel()

        elif choice1 == 2:
            
            candidate_registration()
            # exit(1)

        elif choice1 == 3:

            developer_mode()

        elif choice1 == 4:
            print("Welcome to return to main menu")
        else:
            print("Invalid choice. Please Try again.")

while True:

    main_menu()    