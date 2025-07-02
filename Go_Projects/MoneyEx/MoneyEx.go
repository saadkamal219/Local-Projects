package main

import (
	"fmt"
	// "math"
)

var Balance float64 = 100000000

func welcomeMessage() {
	fmt.Println("\n\n\t\t\t----------------------------------------------------")
	fmt.Println("\t\t\t|                                                  |")
	fmt.Println("\t\t\t|               Welcome to Money-Ex                |")
	fmt.Println("\t\t\t|                                                  |")
	fmt.Println("\t\t\t----------------------------------------------------\n\n")

	fmt.Println("\tWelcome to our Money Exchange Machine. Please Enter your designation: \n")
	fmt.Println("\n\t1: Customer      2: Admin      3: Objection Box      4: Exit\n")
	fmt.Println("\n\tPress [ CTRL + C ] to exit the portal and it is a pleassure to have you with us !!")

	fmt.Printf("\n\tEnter choice: ")
}

func CustomerGreet() {
	fmt.Println("\n\n\t\t\t----------------------------------------------------")
	fmt.Println("\t\t\t|                                                  |")
	fmt.Println("\t\t\t|       Welcome to Money-Ex Customer Section       |")
	fmt.Println("\t\t\t|                                                  |")
	fmt.Println("\t\t\t----------------------------------------------------\n\n")

	fmt.Println("\tWelcome to our Money Exchange Machine. Please choose your currency region: \n")
	// t.println("\n\tCurreny\t\tRegion\t\tExchange Rate [ 1 Taka ]\n");
	fmt.Println("\n\t1: USD    [ United States --> 1 USD = 104.20 Taka ]\n\n\t2: Rupee  [ India --> 1 Rupee = 1.27 Taka ]\n\n\t3: Exit")
	fmt.Println("\n\tPress [ CTRL + C ] to exit the portal and it is a pleassure to have you with us !!")

	fmt.Printf("\n\tEnter choice: ")
}

func main() {

StartPoint:
	welcomeMessage()

	var choice1 int

	fmt.Scanf("%d", &choice1)

	// fmt.Println("Entered:", choice1)

	switch choice1 {
	case 1:

	CustomerCenter:
		CustomerGreet()

		var choice2 int

		fmt.Scanf("%d", &choice2)

		switch choice2 {
		case 1:
			fmt.Println("\n\n\t\t\t----------------------------------------------------")
			fmt.Println("\t\t\t|                   USD to Taka                    |")
			fmt.Println("\t\t\t----------------------------------------------------\n\n")

			fmt.Println("\t1 USD = 122.20 Taka: \n")
			fmt.Printf("\tEnter the amount of money to be exchanged ( in USD ): ")

			var amount float64

			fmt.Scanf("%f", &amount)

			// fmt.Println(amount)

			var total float64 = amount * 122.20

			if total > Balance {
				fmt.Println("\n\tInsufficient Balance in the server. Please wait for an admin to fix the prolbem. Thank you.")
				goto StartPoint
			} else {
				fmt.Printf("\n\tTotal amount is: %.2f Taka\n", total)
				fmt.Println("\n\tPress 1 to withdraw the amount")
				fmt.Println("\n\t1: Withdraw      2: Exit\n")

				fmt.Printf("\n\tEnter choice: ")

				var choice3 int

				fmt.Scanf("%d", &choice3)

				switch choice3 {
				case 1:
					fmt.Println("\n\tExchange and Withdraw Successfull !!")
					fmt.Printf("\n\tTotal amount is: %.2f Taka\n\n", total)

					Balance -= total

					fmt.Println("\n\tEnter choice to continue the program: ")
					fmt.Println("\n\t1: Continue      2: Exit\n")

					fmt.Print("\n\tEnter choice: ")

					var choice4 int

					fmt.Scanf("%d", &choice4)

					switch choice4 {
					case 1:
						goto CustomerCenter
					case 2:
						goto StartPoint
					default:
						fmt.Println("\tInvalid choice")
						goto CustomerCenter
					}
				case 2:
					goto CustomerCenter
				default:
					fmt.Println("\tInvalid choice")
				}

			}
		case 2:
			fmt.Println("\n\n\t\t\t----------------------------------------------------")
			fmt.Println("\t\t\t|                Indian Rupee to Taka                |")
			fmt.Println("\t\t\t----------------------------------------------------\n\n")

			fmt.Println("\t1 IND-Rupee = 1.27 Taka: \n")
			fmt.Print("\tEnter the amount of money to be exchanged ( in Rupee ): ")

			var amount float64

			fmt.Scanf("%f", &amount)

			var total float64 = amount * 1.27

			if total > Balance {
				fmt.Println("\n\tInsufficient Balance in the server. Please wait for an admin to fix the prolbem. Thank you.")
				goto StartPoint
			} else {
				fmt.Printf("\n\tTotal amount is: %.2f Taka\n", total)
				fmt.Println("\n\tPress 1 to withdraw the amount")
				fmt.Println("\n\t1: Withdraw      2: Exit\n")

				fmt.Printf("\n\tEnter choice: ")

				var choice3 int

				fmt.Scanf("%d", &choice3)

				switch choice3 {
				case 1:
					fmt.Println("\n\tExchange and Withdraw Successfull !!")
					fmt.Printf("\n\tTotal amount is: %.2f Taka\n\n", total)

					Balance -= total

					fmt.Println("\n\tEnter choice to continue the program: ")
					fmt.Println("\n\t1: Continue      2: Exit\n")

					fmt.Print("\n\tEnter choice: ")

					var choice4 int

					fmt.Scanf("%d", &choice4)

					switch choice4 {
					case 1:
						goto CustomerCenter
					case 2:
						goto StartPoint
					default:
						fmt.Println("\tInvalid choice")
						goto CustomerCenter
					}
				}
			}
		case 3:
			goto StartPoint

		default:
			fmt.Println("\tInvalid choice")
			goto CustomerCenter
		}

	case 2:
		fmt.Println("Admin")
	case 3:
		fmt.Println("Objection Box")
	case 4:
		fmt.Println("Exit")
	default:
		fmt.Println("Invalid choice")
		goto StartPoint
	}
}
