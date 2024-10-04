package ui;

import java.util.*;
import model.Controller;

public class ExecutableCOP16 {
    private static Scanner in=new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Welcome to the COP 16!");
        int selection=99;
        Controller cont=new Controller();

        while (selection!=0){
            System.out.println("\n \nWelcome to the Menu application for the COP 16 Cali - Colombia")
            System.out.println("Here are the following options, please enter:");
            System.out.println("1. Schedule a hike to one of the Ecological Routes");
            System.out.println("2. Register a biologically diverse place");
            System.out.println("3. Consult the registered biodiverse locations ordered from smallest to largest");
            System.out.println("4. Consult which department has the most biodiverse places registered");
            System.out.println("5. Register a community");
            System.out.println("6. Associate a community to a place");
            System.out.println("7. Register a Species to a Place");
            System.out.println("8. Modify a Species within a Place");
            System.out.println("9. Consult which communities are in need of a hospital or school");
            System.out.println("10. Check which place has the highest number of Species");
            System.out.println("\n0. To Exit");

            selection=in.nextInt();
            in.nextLine(); //Clear buffer

            switch (selection){
                case 0:
                    System.out.println("Thank you for visiting the COP 16!\nGoodbye!");
                    in.close();
                    System.exit(0);
                    break;
                case 1:
                    caseOne();
                    break;
                case 2:
                    caseTwo();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                default:
                    Systen.out.println("\nSorry, please enter a valid option")
                    break;
            }
        }
    } 
    public static void caseOne(){
        boolean condition = false;
        while(!condition){
            System.out.println("Please enter your name: ");
            String org=in.nextLine();

            System.out.println("Please enter your ID: ");
            String orgID=in.nextLine();
            //Get organizer name y ID en caso de que se haga metodo de registrar y se pueda consultar
        }   //Despues de validar organizer, se pide datos para hike.
    }   
}