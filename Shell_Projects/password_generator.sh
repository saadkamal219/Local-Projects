#!/bin/bash

echo -e "\n\t|-------------------------------|"                   
echo -e "\t|--|   Password  Generator   |--|"
echo -e "\t|_______________________________|\n" 

echo -e "Starting Password Generator..."

read -p "Read password manual [y/n] " ack

generate_password(){

    read -p "Please enter the length of the password: " PASS_LENGTH

    sleep 2

    echo "Here is the password..."

    for p in $(seq 1);
    do
            openssl rand -hex 48 | cut -c1-$PASS_LENGTH
    done

}

if [ $ack == "y" ]; 
then
    echo -e "\t1. It is suggested that a user always use passwords with not less than 8 characters."
    echo -e "\t2. Use of special characters is highly recomended."
    echo -e "\t3. Use digits and upper and lower case letters to strengthen the password."

    generate_password

else
    generate_password
fi