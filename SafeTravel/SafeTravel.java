import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.lang.Math;
import java.util.ArrayList;
import java.lang.Math;

public class SafeTravel {

    public static int numberOfRoutes;
    // public static String[]routeNames = new String[numberOfRoutes];
    public static int INFINITY = 9999;

    public static void dijkstra(int[][] graph, int source, String[] routeNames, int numberOfRoutes) {

        boolean[] visitedVertex = new boolean[numberOfRoutes];
        int[] distance = new int[numberOfRoutes];

        for (int i = 0; i < numberOfRoutes; i++) {

          visitedVertex[i] = false;
          distance[i] = Integer.MAX_VALUE;

        }

        distance[source] = 0;

        for (int i = 0; i < numberOfRoutes; i++) {

          int u = findMinDistance(distance, visitedVertex);
          visitedVertex[u] = true;
    
          for (int v = 0; v < numberOfRoutes; v++) {

            if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
              distance[v] = distance[u] + graph[u][v];

            }

          }

        }

        System.out.println("\n\t\t\t----------------------------------------------------");
        System.out.println("\t\t\t|                   Route Plan                     |");
        System.out.println("\t\t\t----------------------------------------------------\n");

        int i, j;

        for (i = 1; i < distance.length; i++) {

            System.out.println(String.format("\n\tTotal cost from %s to %s: %d\n", routeNames[0], routeNames[i], distance[i]));

        }

        int min = 999999;
        int location = 0;

        for (i = 0, j = 0; i < distance.length; i++, j++) {

            if (min > distance[i]) {

                if (distance[i]!=0) {

                    min = distance[i];
                    location = i;

                }  

            }

        }
        
        System.out.printf("\tMinimum cost is to travel from %s to %s: %d\n", routeNames[0], routeNames[location], min);

        System.out.println("\n\t------------------------------------------------------------------------------------");

    }

    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
          if (!visitedVertex[i] && distance[i] < minDistance) {
            minDistance = distance[i];
            minDistanceVertex = i;
          }
        }
        return minDistanceVertex;
    }

    private static void bubble_sort(int[]array){
        
        int temp = 0;

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void Optmizer(String[]routeNames, int numberOfRoutes){

        Scanner scanner = new Scanner(System.in);

        int [][]Graph = new int [numberOfRoutes + 1][numberOfRoutes + 1];
        int source = 0;

        System.out.print("\n\tEnter the possible number of routes from your location to destinations: ");
        int numberOfWays = scanner.nextInt();

        int firstPoint, secondPoint, travelCost;

        System.out.println("\n\tNow we will generate the travel cost of one place to another.");
        System.out.println("\tThe manual is if you have 3 destination and and one current"); 
        System.out.println("\tlocation than consider the current location as \'0\' and the ");
        System.out.println("\tdestinations as the uncrement of the current location. For example,");
        System.out.println("\tconsider current location as \"Dhaka\" and input it as \'0\'. Than");
        System.out.println("\tyou want to go to \"Comilla\" and \"Barishal\". So consider these as");
        System.out.println("\t\'1\' and \'2\'.\n");
                                                  
        for(int i = 1; i <= numberOfWays; i++){

            System.out.print("\n\tEnter current location: ");
            firstPoint = scanner.nextInt();
            System.out.print("\n\tEnter next location: ");
            secondPoint = scanner.nextInt();
            System.out.print("\n\tEnter travel cost from " + firstPoint + " to " + secondPoint + ": ");
            travelCost = scanner.nextInt();

            Graph[firstPoint][secondPoint] = travelCost;
            Graph[secondPoint][firstPoint] = travelCost;

        }

        dijkstra(Graph, source, routeNames, numberOfRoutes);

    }
    
    public static void Main_Menu_Header(){

        System.out.println("\n\n\t\t\t----------------------------------------------------");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t|              Welcome to Safe Travel              |");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t----------------------------------------------------\n\n");

        System.out.println("\tWelcome to \"Safe Travel\" Portal. Please Enter your designation: \n");
        System.out.println("\n\t1: Customer      2: Admin      3: Objection Box      3: Exit\n");
        System.out.println("\n\tPress [ CTRL + C ] to exit the portal and it is a pleassure to have you with us !!");

        System.out.print("\n\tEnter choice: ");

    }
    public static void Customer_Menu_Header(){

        System.out.println("\n\n\t\t\t----------------------------------------------------");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t|              Welcome to Safe Travel              |");
        System.out.println("\t\t\t|                                                  |");
        System.out.println("\t\t\t----------------------------------------------------\n\n");

        System.out.println("\tWelcome to \"Safe Travel\" Portal. Please choose region.\n");
        System.out.println("\n\t1: Travel Bangladesh      2: Exit\n");
        System.out.println("\n\tPress [ CTRL + C ] to exit the portal and it is a pleassure to have you with us !!");

        System.out.print("\n\tEnter choice: ");

    }

    public static void Main_Menu_Choice(){

        Scanner scanner = new Scanner(System.in);

        Main_Menu_Header();

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                //Customer
                Customer_Page_Choice();
                break;
            case 2:
                //Admin
                break;
            case 3:
                // Objection

                File myFile = new File("Objection.txt");

                System.out.println("\n\n\t\t\t----------------------------------------------------");
                System.out.println("\t\t\t|                  Objection Box                   |");
                System.out.println("\t\t\t----------------------------------------------------\n\n");   

                try {
                    FileWriter writer = new FileWriter("Objection.txt");
                    System.out.println("\tEnter your objection here: ");
                    scanner.nextLine();
                    String line = scanner.nextLine();
                    writer.write(line);
                    writer.close();
                    
                } catch (Exception e) {
                    System.out.println("\n\tErro occured. Please try again.");
                    Main_Menu_Choice();
                }

                break;
            case 4:
                // Exit
                break;
        
            default: 
                System.out.println("Invalid Choice. Please Try again.");
                Main_Menu_Choice();
                break;
        }

    }

    public static void Customer_Page_Choice(){

        Scanner scanner = new Scanner(System.in);

        Customer_Menu_Header();

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("\n\n\t\t\t----------------------------------------------------");
                System.out.println("\t\t\t|                Local Route Manager                 |");
                System.out.println("\t\t\t----------------------------------------------------\n\n");
        
                System.out.println("\tHello, I am Jarvis. Please share your travel planning with me so that I can help you with the most effective plan.\n");
                System.out.print("\tEnter the number of places you want to travel: ");
                numberOfRoutes = scanner.nextInt();
                System.out.print("\n\tEnter your location from where you will start your journey: ");
                // scanner.nextLine()
                String[]routeNames = new String[numberOfRoutes];
                routeNames[0] = scanner.next();
                System.out.print("\n\tEnter other locations that you want to visit during your journey: ");
                for (int i = 1; i < numberOfRoutes; i++) {
                    routeNames[i] = scanner.next();
                }

                System.out.println("\n\tDo you want to view the list of routes?\n");
                System.out.println("\n\t1: View List      2: Start Optimization\n");
                System.out.println("\n\tPress [ CTRL + C ] to exit the portal and it is a pleassure to have you with us !!");

                System.out.print("\n\tEnter choice: ");

                int innerChoice = scanner.nextInt();

                switch (innerChoice) {
                    case 1:
                        System.out.println("\n\tHere are the places you want to visit: \n");
                        for (int i = 0; i < numberOfRoutes; i++) {
                            if (i==0) {
                                System.out.println("\n\tStart point: "+routeNames[i]);
                            }
                            else{
                                System.out.println("\n\tDestination no "+i+": "+routeNames[i]);
                            }
                        }
                        
                        System.out.print("\n\tPress 1 to start optimizations");

                        // String choice1 = scanner.next();
                        int outChoice = scanner.nextInt();

                        if (outChoice == 1) {
                            Optmizer(routeNames, numberOfRoutes);
                            Customer_Page_Choice();
                        }

                        break;
                    case 2:
                        Optmizer(routeNames, numberOfRoutes);
                        Customer_Page_Choice();
                        break;
                    default: System.out.println("\n\tInvalid Choice. Try again.");
                        Customer_Page_Choice();
                        break;
                }

                break;
            case 2:
                Main_Menu_Choice();
                break;
            default: System.out.println("\n\tInvalid Choice. Try again.");
                Customer_Page_Choice();
                break;
        }

    }

    public static void main(String[] args) {
        Main_Menu_Choice();
    }

}
