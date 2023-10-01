#!/bin/bash

figlet "Digital Voting Machine"

# echo -e "\n\t|----------------------------------|"
# echo -e "\t|--|   Digital Voting Machine   |--|"
# echo -e "\t|__________________________________|\n"

file_of_voter_registration='/home/saad/Desktop/Digital_Voting_Machine/Voter_Information.csv'
file_of_candidate_registration='/home/saad/Desktop/Digital_Voting_Machine/Candidate_Information.csv'
garbage_collerctor='/home/saad/Desktop/Digital_Voting_Machine/Garbage.csv'
system_location='/home/saad/Desktop/Digital_Voting_Machine/Digital_Voting_Machine.py'
candidate_registration_completion='/home/saad/Desktop/Digital_Voting_Machine/Candidate_registration_completion.mp3'
feedback_file='/home/saad/Desktop/Digital_Voting_Machine/feedback.txt'

vote_menu() {

    echo -e "\n|--------------  -----------------|"
    echo -e "|--|   Welcome to Voter Menu   |--|"
    echo -e "|_________________________________|\n"

    read -p "Enter your NID number: " voter_NID

    column_to_search=2

    first_result=$(awk -F ',' -v first="$voter_NID" '$0 ~ first { found=1; row=$0; exit } END { if (!found) exit 1 }' "$file_of_voter_registration")

    if [ $? -eq 0 ];
    then

        # selected_row=()

        # selected_row=$(grep "$voter_NID" "$file_of_voter_registration")

        # IFS="," read -ra row_elements <<< "$selected_row"
        # for element in "${row_elements[@]}"; do
        #     selected_rows+=("\"$element\"")
        # done

        # echo "Selected row elements:"
        # # Print the selected row elements
        # for element in "${selected_rows[@]}"; do
        #     echo "$element"
        # done

        # for field in "${selected_row[@]}"; do
        #     echo "$field"
        # done

        # Prompt the user for the second value to search for
        # read -p  "Enter your password: " voter_password

        # status=false

        # for i in "${selected_row[@]}"; 
        # do
        #     if [[ "$i" == "$voter_password" ]]; then
        #         status=true
        #         break  # Exit the loop once the target value is found
        #     fi
        # done

        # if $status; 
        # then
        #     echo -e "Welcome user" #voting
        # else
        #     echo -e "\nIncorrect password. Remember the password and try again.\nRemember that frequently pushing wrong password will suspend the user from voting.\n"
        # fi

        echo -e "\n|------------------------------------|"
        echo -e "|--|   Welcome to Voting System   |--|"
        echo -e "|____________________________________|\n"

        read -p "Enter your region: " target_region

        count=0

        while IFS=',' read -r Name NID Symbol Party Position Region Participation; 
        do
            if [ "$Region" = "$target_region" ];
            then
                echo -e "\nName: $Name"
                echo -e "NID: $NID"
                echo -e "Symbol: $Symbol"
                echo -e "Party: $Party"
                echo -e "Position Candidate: $Position"
                echo -e "Participation at: " $Participation
                # echo -e "Candidate Region: $Region"
                count=$(($count+1))
                # echo -e "Password: $password"
                # break  # Stop searching once the record is found
            fi
        done < "$file_of_candidate_registration"

        echo -e "\nTotal $count candidates in $target_region\n"

        read -p "Enter your voting position: " target_position

        while IFS=',' read -r Name NID Symbol Party Position Region Participation; 
        do
            if [ "$Region" = "$target_region" ] && [ "$Position" = "$target_position" ];
            then
                echo -e "\nName: $Name"
                echo -e "NID: $NID"
                echo -e "Symbol: $Symbol"
                echo -e "Party: $Party"
                echo -e "Participation at: " $Participation
                # echo -e "Position Candidate: $Position"
                # echo -e "Candidate Region: $Region"
                count2=$(($count2+1))
                # echo -e "Password: $password"
                # break  # Stop searching once the record is found
            fi
        done < "$file_of_candidate_registration"

        echo -e "\n Total $count2 candidates for $target_position in $target_region"

        echo -e "\nStart voting for $target_position in $target_region? [y/n]: " proceed2

        if [ $proceed2 == "y" ] || [ $proceed2 == 'Y' ]; 
        then

            echo -e "Preparing the Digital Voting System card....."
            

        else
            top_menu
        fi

    else

        echo -e "\n$voter_NID is not registered."
        read -p "Do you want to register? [y/n]: " want_to_register

        if [ $want_to_register == "y" ] || [ $want_to_register == "Y" ]; 
        then

            voter_registration

        else

            top_menu

        fi

    fi

}

developer_mode() {

    echo -e "\nHello Administrator. Please choose your action\n"
    # echo -e "\nPlease choose your action.\n"
    echo -e "1. View Voter List"
    echo -e "2. View Candidate List"
    echo -e "3. Delete from Voter List"
    echo -e "4. Delete from Candidate List"
    # echo -e "5. Handel Database"
    echo -e "5. Exit Developer mode\n"

    read -p ">_ " choice3

    if [ $choice3 == 1 ];
    then

        echo -e "\n---------------------------------------------------------------------------------------------------|"
        echo -e "-----------------------------------   | Voter Information |   -------------------------------------|"
        echo -e "---------------------------------------------------------------------------------------------------|"
        column -s, -t < "$file_of_voter_registration"
        echo -e "---------------------------------------------------------------------------------------------------|"
        # awk 'BEGIN { FS="," } { for (i=1; i<=NF; i++) printf "%-20s", $i; printf "\n" }' "$file_of_voter_registration"
        developer_mode

    elif [ $choice3 == 2 ];
    then

        echo -e "\n---------------------------------------------------------------------------------------------------|"
        echo -e "---------------------------------   | Candidate Information |   -----------------------------------|"
        echo -e "---------------------------------------------------------------------------------------------------|"
        column -s, -t < "$file_of_candidate_registration"
        echo -e "---------------------------------------------------------------------------------------------------|"

        developer_mode
    
    elif [ $choice3 == 3 ];
    then

        echo -e "\nEnter the NID card number of the voter"
        read -p ">_ " voter_nid_card_number

        echo -e "\nBefore removing the voter, it is preferred to view the information of the selected voter. Proceed ? [y/n] "
        read -p ">_ " proceed

        if [ $proceed == "y" ] || [ $proceed == "Y" ]; 
        then
            while IFS=',' read -r Name NID Sex Date_of_Birth Father_name Mother_name Password; 
            do
                if [ "$NID" = "$voter_nid_card_number" ]; 
                then
                    echo -e "\nName: $Name"
                    echo -e "NID: $NID"
                    echo -e "Sex: $Sex"
                    echo -e "Date of Birth: $Date_of_Birth"
                    echo -e "Father name: $Father_name"
                    echo -e "Mother name: $Mother_name"
                    # echo -e "Password: $password"
                    break  # Stop searching once the record is found
                fi
            done < "$file_of_voter_registration"

            echo -e "\nDeleting record..."
            sleep 2

            #delete voter record

            echo -e "Records for $voter_nid_card_number has been deleted. "

            developer_mode

        else

            echo -e "\nDeleting record..."
            sleep 2

            #delete voter record

            echo -e "Records for $voter_nid_card_number has been deleted. \n\n"

            developer_mode

        fi

    elif [ $choice3 == 4 ];
    then

        echo -e "\nEnter the NID card number of the candidate"
        read -p ">_ " candidate_nid_card_number

        echo -e "\nBefore removing the candidate, it is preferred to view the information of the selected candidate. Proceed ? [y/n] "
        read -p ">_ " proceed2

        if [ $proceed2 == "y" ] || [ $proceed2 == "Y" ]; 
        then
            while IFS=',' read -r Name NID Symbol Party Position Region Participation; 
            do
                if [ "$NID" = "$candidate_nid_card_number" ]; 
                then
                    echo -e "\nName: $Name"
                    echo -e "NID: $NID"
                    echo -e "Symbol: $Symbol"
                    echo -e "Party: $Party"
                    echo -e "Position Candidate: $Position"
                    echo -e "Candidate Region: $Region"
                    echo -e "Participation at: " $Participation
                    # echo -e "Password: $password"
                    break  # Stop searching once the record is found
                fi
            done < "$file_of_candidate_registration"

            echo -e "\nDeleting record..."
            sleep 2

            #delete voter record

            echo -e "Records for $candidate_nid_card_number has been deleted. "

            developer_mode

        else

            echo -e "\nDeleting record..."
            sleep 2

            #delete voter record

            echo -e "Records for $candidate_nid_card_number has been deleted. \n\n"

            developer_mode

        fi

    fi

}

developer_login() {

    echo -e "\n|-------------------------------------|"
    echo -e "|--|   Welcome to Developer Mode   |--|"
    echo -e "|_____________________________________|\n"

    echo -e "Hello Sir. Please enter your username and password to confirm your identity\n"

    read -p "Enter your username: " username
    echo -e "Enter your password: " 
    read -s password

    if [ $username == "admin" ] && [ $password == "admin" ]; 
    then 
        developer_mode
    elif [ $username != "admin" ] && [ $password == "admin" ]; 
    then 
        echo -e "\nInvalid username. Please try again\n"
        developer_login
    elif [ $username == "admin" ] && [ $password != "admin" ];
    then
        echo -e "\nInvalid password. Please try again\n"
        developer_login
    else
        echo -e "\nInvalid username and password. Please try again\n"
        developer_login
    fi

}

candidate_registration() {

    echo -e "\n|----------------------------------------------------|"
    echo -e "|--|   Welcome to Candidate Registration Portal   |--|"
    echo -e "|____________________________________________________|\n"

    read -p "Enter your name: " candidate_name
    read -p "Enter your NID number: " candidate_nid
    read -p "Enter your symbol: " candidate_symbol
    read -p "Enter your party name: " candidate_party
    read -p "Enter your participation position: " candidate_participation_position
    read -p "Enter your region: " candidate_region
    read -p "Enter where you want to participate: " candidate_participation

    candidate_record=("$candidate_name", "$candidate_nid", "$candidate_symbol", "$candidate_party", "$candidate_participation_position", "$candidate_region", "$candidate_participation")

    read -p "Your records has been recorded. Do you want to finish the process? [y/n]: " choice2

    if [ $choice2 == 'y' ] || [ $choice2 == 'Y' ];
    then
        
        (IFS=''; echo "${candidate_record[*]}") >> "$file_of_candidate_registration"

        echo -e "\nSuccessfully updated information. Now you are a nominating candidate for the voting system.\nWait for the admin for confirmation\nAll of this are managed by the admin and admin has the right not to select you as candidate or remove you from the voting system.\n"

        main_menu

    else main_menu
    fi

}

voter_registration() {

    echo -e "\n|------------------------------------------------|"
    echo -e "|--|   Welcome to Voter Registration Portal   |--|"
    echo -e "|________________________________________________|\n"

    read -p "Enter your name: " name
    read -p "Enter you NID card number: " nid_card
    read -p "Enter your sex: " sex
    read -p "Enter your date of birth: " date_of_birth
    read -p "Enter your father name: " father_name
    read -p "Enter your mother name: " mother_name
    read -p "Enter password: " password

    voter_record=("$name", "$nid_card", "$sex", "$date_of_birth", "$father_name", "$mother_name", "$password")

    read -p "Your records has been recorded. Do you want to finish the process? [y/n]: " choice1

    # for iteam in "${voter_record[@]}";
    # do
    #     echo "$iteam" >> "$file_of_voter_registration"
    # done

    if [ $choice1 == "y" ] || [ $choice1 == "Y" ];
    then

        (IFS=''; echo "${voter_record[*]}") >> "$file_of_voter_registration"

        echo -e "\nSuccessfully registered.\n"

        main_menu

    else main_menu
    fi

}

main_menu() {

    echo -e "\nEnter your cooresponding number: \n"
    echo -e "1. Voter Registration"
    echo -e "2. Candidate Registration"
    echo -e "3. Enter Developer mode"
    echo -e "4. Exit main menu\n"

    read -p ">_ " choice1

    if [ $choice1 -eq 1 ]; then voter_registration
    elif [ $choice1 -eq 2 ]; then candidate_registration
    elif [ $choice1 -eq 3 ]; then developer_login
    elif [ $choice1 -eq 4 ]; 
    then 
        echo -e ""
        read -p "Thanks for using this portal. It will be our pleasure if you leave some feedback. Proceed? [y/n]: " proceeding

        if [  $proceeding == 'y' ] || [ $proceeding == 'Y' ]; 
        then
            echo -e "\nEnter your feedback here: \n"
            read feedback

            echo "$feedback" >> "$feedback_file"

            echo -e "recording..."
            sleep 2

            echo -e "Thnaks for your response. \n"

            sleep 2
            
            exit 1
        
        else

            echo -e "Thanks for using this portal."
            sleep 1

            exit 1
        
        fi

    else 
        echo -e "Invalid choice. Please try again."
        main_menu
    fi

}

top_menu() {

    echo -e "\n|-------------------------------|"
    echo -e "|--|   Welcome to Top Menu   |--|"
    echo -e "|_______________________________|\n"

    echo -e "\nEnter your cooresponding number: \n"
    echo -e "1. Registration"
    echo -e "2. Vote"
    echo -e "3. Exit\n"

    read -p ">_ " choice5

    if [ $choice5 == 1 ]; then main_menu
    elif [ $choice5 == 2 ]; then vote_menu
    elif [ $choice5 == 3 ]; then exit 0
    else top_menu
    fi

}

while [ true ];
do
    top_menu
done