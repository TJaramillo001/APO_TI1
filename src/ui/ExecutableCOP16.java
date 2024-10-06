package ui;
import java.util.*;
import model.*;

public class ExecutableCOP16 {
    private static Scanner in=new Scanner(System.in);
    private static Controller cont=new Controller();

    public static void main(String[] args){
        System.out.println("Welcome to the COP 16!");
        int selection=99;

        while (selection!=0){ //Menu
            System.out.println("\n \nWelcome to the Menu application for the COP 16 Cali - Colombia");
            System.out.println("\nHere are the following options, please enter:\n");
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

            switch (selection){ //In this menu, we call methods for all the longer ones, The single line methods are simply placed without a method.
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
                    cont.consultPlace();                        
                    break;
                case 4:
                    cont.maxDepartment();
                    break;
                case 5:
                    caseFive();
                    break;
                case 6:
                    caseSix();
                    break;
                case 7:
                    caseSeven();
                    break;
                case 8:
                    caseEight();
                    break;
                case 9:
                    cont.commIssues();
                    break;
                case 10:
                    System.out.println(cont.maxSpecies());
                    break;
                default:
                    System.out.println("\nSorry, please enter a valid option");
                    break;
            }
        }
    } 
    /**
     * Description: This is the method that is used to schedule hikes. It consults whether the user is authorized to schedule a hike or not.
     */
    public static void caseOne(){ //Schedule hike
        System.out.println("Please enter your name: ");
        String org=in.nextLine();

        System.out.println("Please enter your ID: ");
        String orgID=in.nextLine();

        if(org.equalsIgnoreCase("Tomas")&&orgID.equalsIgnoreCase("1032876581")){
            System.out.println("Welcome, TOMAS!");
            System.out.println("Which route will you be hiking through today?");
            String routeName=in.nextLine();
            System.out.println("Excellent!");

            System.out.println("How many guides will assist today");
            int guides = in.nextInt();
            in.nextLine();

            System.out.println("How many participants will be visiting today?");
            int participants=in.nextInt();
            in.nextLine(); //Clear buffer
            double temp=0;
            while(temp<10 || temp>40){ //Normal weather in Cali will never be less than 10°C or more than 40°C. 
                System.out.println("What is today's temperature?");
                temp=in.nextDouble();
                in.nextLine();
            }
            double humidity=-1;
            while (humidity<0 || humidity>100) { //This is a percentage
                System.out.println("What is the relative humidity?");
                humidity=in.nextDouble();
                in.nextLine();
            }
            
            System.out.println("\n"+cont.scheduleHike(routeName));
            System.out.println("\nFor today's hike, you will need "+(int) cont.busesNeeded(guides, participants)+" bus(es).");
            System.out.println(cont.showMetData(temp, humidity));
            System.out.println("Please enjoy your hike!");
        } 
    }
    
    public static void caseTwo(){ //Register place
        System.out.println("\nTo register a new biodiverse place, please input the following data:");
        System.out.println("\nPlease enter the name of the place:");
        String namePlace=in.nextLine();

        System.out.println("\nPlease enter the department in which it's located:");
        String dept=in.nextLine();

        System.out.println("\nPlease enter the size of " +namePlace+":");
        double size=in.nextDouble();
        in.nextLine();

        System.out.println("\nPlease enter the allocated budget for "+namePlace+":");
        double requiredBudget=in.nextDouble();
        in.nextLine();
        
        System.out.println("\nPlease enter a picture of "+namePlace+"(file route):");
        String picOfLoc=in.nextLine();

        System.out.println("\nPlease enter the date of inauguration (dd-mm-aaaa):");
        String dateOfIna=in.nextLine();

        cont.createPlace(namePlace, dept, size, requiredBudget, picOfLoc, dateOfIna);
    } 
   
    public static void caseFive(){ //Register community
        System.out.println("To register a community please input the following data:");
        System.out.println("What is the community name?");
        String communityName=in.nextLine();

        System.out.println("What is the community type(AFROCOLOMBIANA, INDIGENA, RAIZAL)");
        String opt = in.nextLine();

        CommunityType communityType=null;
        switch(opt.toUpperCase()){
            case "AFROCOLOMBIANA":
                communityType=CommunityType.AFROCOLOMBIANA;
                break;
            case "INDIGENA":
                communityType=CommunityType.INDIGENA;
                break;
            case "RAIZAL":
                communityType=CommunityType.RAIZAL;
                break;
            default:
                System.out.println("Sorry, that type is not available. Please try again. The community information has not been saved");
                return;      
        }

        System.out.println("What is the name of the community representative");
        String nameRepresentative=in.nextLine();

        System.out.println("What is "+nameRepresentative+"'s contact number");
        String celRepresentative=in.nextLine();

        System.out.println("What is the population of "+communityName);
        int population=in.nextInt();
        in.nextLine();

        System.out.println("\nWhat issue does "+communityName+" have?");
        System.out.println("1. Needs a hospital");
        System.out.println("2. Needs a school");
        System.out.println("3. Needs clean water");
        System.out.println("4. Needs more food");
        int select=in.nextInt();
        in.nextLine();

        NameIssue nameIssue =null;
        switch(select){
            case 1:
                nameIssue=NameIssue.NEEDSHOSPITAL;
            break;
            case 2:
                nameIssue=NameIssue.NEEDSSCHOOL;
            break;
            case 3:
                nameIssue=NameIssue.NEEDSWATER;
            break;
            case 4:
                nameIssue=NameIssue.NEEDSFOOD;
            break;
            default:
                System.out.println("\nSorry, that option isn't valid. Please try again, the community information has not been saved");
            return;
            }
        cont.createCommunity(communityName, communityType, nameRepresentative, celRepresentative, population, nameIssue);

    }
    public static void caseSix(){ //Associate community
        System.out.println("Please input the name of the community you want to associate:");
        String communityName=in.nextLine();

        System.out.println("Please input the name of the place you want to associate "+communityName+" to:");
        String namePlace = in.nextLine();

        cont.associateCommunity(namePlace, communityName);
    }
    public static void caseSeven(){// Create and associate Species
        System.out.println("To register a species, please enter the following data");
        System.out.println("Please enter the name of the registered place in which the species will be registered");
        String namePlace=in.nextLine();
        
        System.out.println("Please enter your species' name:");
        String speciesName=in.nextLine();

        System.out.println("Please enter your species type (FLORA or FAUNA):");
        String opt=in.nextLine();

        SpeciesType speciesType=null;
        switch (opt.toUpperCase()){
            case "FLORA":
                speciesType=SpeciesType.FLORA;
                break;
            case "FAUNA":
                speciesType=SpeciesType.FAUNA;
                break;
            default:
                System.out.println("Sorry, that type is not available. Please try again. The species information has not been saved");
                return;      
        }
        System.out.println("Please enter an image of the species (file route)");
        String speciesPicture=in.nextLine();

        System.out.println("Please enter the species' population");
        int speciesPopulation=in.nextInt();
        in.nextLine();

        cont.associateSpecies(namePlace, speciesName, speciesType, speciesPicture, speciesPopulation);
    }

    public static void caseEight(){//Modify a species
        System.out.println("Please enter the name of the species you want to modify:");
        String speciesName=in.nextLine();

        System.out.println("Please enter the new name:");
        String newSpeciesName=in.nextLine();

        System.out.println("Please enter your new species type (FLORA or FAUNA):");
        String opt=in.nextLine();

        SpeciesType newSpeciesType=null;
        switch (opt.toUpperCase()){
            case "FLORA":
                newSpeciesType=SpeciesType.FLORA;
                break;
            case "FAUNA":
                newSpeciesType=SpeciesType.FAUNA;
                break;
            default:
                System.out.println("Sorry, that type is not available. Please try again. The species information has not been saved");
                return;      
        }
        System.out.println("Please enter a new image of the species (file route)");
        String newSpeciesPicture=in.nextLine();

        System.out.println("Please enter the new species' population");
        int newSpeciesPopulation=in.nextInt();
        in.nextLine();

        System.out.println(cont.modifySpecies(speciesName, newSpeciesName, newSpeciesType, newSpeciesPicture, newSpeciesPopulation));
    }
}
