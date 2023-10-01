#!/bin/bash

# Specify the CSV file path
csv_file="/home/saad/Desktop/Digital_Voting_Machine/Candidate_Information.csv"

# Define your conditions
condition1="Position == "   # Example: Select rows with RollNumber 101
condition2="Grade == 'A'"        # Example: Select rows with Grade 'A'

# Use awk to filter and print rows that meet the conditions
awk -F ',' -v c1="$condition1" -v c2="$condition2" 'NR==1 || (c1 && c2)' "$csv_file"
