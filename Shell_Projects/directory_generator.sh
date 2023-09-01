#!/bin/bash

display_header(){

    echo -e "\n\t\t\t|                               |"
    echo -e "\t\t\t|------|  Dr. Directory  |------|"
    echo -e "\t\t\t|                               |\n"
    
}

display_header

echo -e "This project is open source and free to use. For more information type 'info' or 'skip' to skip the details"

rename_directory() {}

delete_directory() {

    echo -e "It is always recommended to check for backup before deleting the directory"
    echo -e "Delete a file or folder ? Type 'f' for file and 'd' for folder"
    read -p ">_ " deletion_choice

    if [ $deletion_choice = "f" ]; 
    then
        echo -e "Enter the file name to delete"
        read -p ">_ " file_name
        echo -e "Searching file in the system..."
        find . -type $deletion_choice -name "$file_name" #how user will know that the searched file is being chosen???
        sleep 1
        read -p "File found in the system. Delete it? [y/n]: " dlt_ack
        if [ $dlt_ack = "y" ];
        then
            #delete the file

}

creating_directory() {

    echo -e "Enter the location of the directory that you are attempting to"
    read -p ">_ " location
        
    echo -e "Reaching to location...."
    cd 
    cd $location

    sleep 2

    echo -e "Reached to $location"

    read -p "Do you want to create single folder as parent or multiple folders as the children of $location directory [single/multiple]: " ack1

    if [ $ack1 == 'single' ];
    then

        echo -e "Enter the parent folder name **this will be child of $location branch**"
        read -p ">_ " parent_folder_name

        mkdir $parent_folder_name
        
    fi

}

make_choice() {

    echo -e "\t\t1. Create a directory\t2. Rename the directory\t3. Delete the directory"

    read -p ">_ " choice

    if [ $choice == 1 ]; 
    then
        creating_directory
    elif [ $choice == 2 ];
    then
        rename_directory
    elif [ $choice == 3 ];
    then
        delete_directory
    else
        make_choice
    fi

}

take_opinion() {

    read -p ">_ " opinion

    if [ $opinion == 'info' ]; 
    then
        echo -e "\nThis project is a directory creator. The user can just give the instructions to the system rather than creating a working tree manually.\nFor UNIX/Linux based distributions the working directories perform as a tree. Assume, The 'root' directory is the source of the tree and\nothers are the children that have been created for working purposes.\n"

        echo -e "\t\t\t\t\t\t  --------"
        echo -e "\t\t\t\t\t\t  | root |"
        echo -e "\t\t\t\t\t\t  --------"
        echo -e "\t\t\t\t\t\t      |   "
        echo -e "\t\t\t\t\t----------------------------"
        echo -e "\t\t\t\t\t|                          |"
        echo -e "\t\t\t\t    --------            \t--------"
        echo -e "\t\t\t\t    | home |            \t|  bin |"
        echo -e "\t\t\t\t    --------            \t--------"
        echo -e "\t\t\t\t       |                \t    |   "
        echo -e "\t\t\t-------------------------        ---------------------"
        echo -e "\t\t\t|           |           |        |          |        |"
        echo -e "\t\t  -----------\t---------- ---------- --------\t-------- ----------"
        echo -e "\t\t  | Desktop |\t| Videos | |  Music | | bash |\t| dpkg | |  mandb |"
        echo -e "\t\t  -----------\t---------- ---------- --------\t-------- ----------"
        echo -e "\n\t\t*dpkg -> debian package"
        echo -e "\t\t*mandb -> Used to initialise or manually update index database caches. \n"

        creating_directory
    
    elif [ $opinion == 'skip' ]; 
    then
        
        echo -e "Directory or Creation is a part of Directory Manipulation. Please choose an option..."

        make_choice

    else
        echo -e "\nInvalid input. Please try again......"
        take_opinion
    fi

}

take_opinion