#!/bin/bash

echo -e "\n\t--|--|   Basic  Calculator   |--|--\n"

read -p "Please enter the first number: " num1

read -p "Please enter the second number: " num2

read -p "Please enter the operation (+, -, *, /): " op

if [ "$op" == "+" ]; 
then
    echo -e "\nThe result is: $(($num1+$num2))"
elif [ "$op" == "-" ]; 
then
    echo -e "\nThe result is: $(($num1-$num2))"
elif [ "$op" == "*" ]; 
then
    echo -e "\nThe result is: $(($num1*$num2))"
elif [ "$op" == "/" ]; 
then
    echo -e "\nDo you want to perform floating point division or floor division ?"
    read -p "Type 'floor' for floor division and 'float' for floating point division: " divisor
    if [ "$divisor" == "float" ];
    then
        result=$(echo "scale=2;$num1/$num2 "| bc)
        echo -e "\nThe result is: $result"
    elif [ "$divisor" == "floor" ];
    then
        echo -e "\nThe result is: $(($num1/$num2))"
    fi
fi

