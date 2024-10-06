package model;
import model.*;
import java.util.Comparator;
import java.util.Arrays;

public class Controller {
    private Place[] places;
    private int placesCount;
    private int communityCount;
    private Species[] species;
    private Community[] communities;
    private Route rLadera;
    private Route rFarallones;
    private Route rOriente;
    /**
     * Description: This is the Controller constructor class which initializes every important variable that will be used throughout the most important part of the code. 
     */
    public Controller(){
        this.places = new Place[30]; // Max of 30 places 
        this.species=new Species[50*placesCount]; //50 species per place allowed
        this.communities=new Community[30]; //We can have a max of 30 communities (one per place) (each communitity can have one or more places)
        this.placesCount = 0; //Initialize places at 0
        this.communityCount=0; // Initialize communities at 0
        this.rLadera = new Route("Ladera", "7:00am", "4:00pm", "Bulevar del Rio");
        this.rFarallones = new Route("Farallones", "6:40am", "4:00pm", "Calle 16 - Universidad del Valle");
        this.rOriente = new Route("Oriente", "7:00am", "4:00pm", "Bulevar del Rio");
        Organizer Tomas = new Organizer("Tomas", "1032876581"); //Initialize the only volunteer that is allowed to schedule Hikes
    }

    //Part 1
    /**
     * Description: This allows a registered organizer to schedule a hike to an ecological route
     * @param String routeName : This is the name of the route selected
     * @return : returns the selected route's information (name, meeting point, start and end times)
     */
    public String scheduleHike(String routeName){
        switch(routeName.toUpperCase()){
            case "FARALLONES":
                return rFarallones.getRouteInfo();
            case "LADERA":
                return rLadera.getRouteInfo();
            case "ORIENTE":
                return rOriente.getRouteInfo();
            default:
                return "Sorry, that route doesn't exist";
        }
    }
    /**
     * Description: This method is used to analyze the meterological data of that day. It calls the ClimateAnalysis class
     * @param double temp : This is that day's temperature
     * @param double humidity: This is that days relative humidity percentage.
     * @return : Returns a string that says whether it's a good day to walk or not according to the provided data.
     */
    public String showMetData(double temp, double humidity){
        return ClimateAnalysis.showMeterologicalData(temp, humidity);
    }
    /**
     * Description : This method calculates how many buses will be needed to transport the total people that will be assisting the hike (max 25 people per bus)
     * @param int guides : This number represents how many guides will accompany
     * @param int participants : This represents how many citizens or common people will assist
     * @return int necessaryBus: This is the product of dividing the total people by 25 and rounding up to calculate how many buses are needed.
     */
    public double busesNeeded(int guides, int participants){
        int totalPeople = guides+participants;
        double numBus=((double) totalPeople/25);
        int necessaryBus=(int)(Math.ceil(numBus));

        return necessaryBus;
    }
    //Part 2
    /**
     * Description: This method calls on the Place constructor to create a new Place
     * @param String namePlace : This is the name of the biodiverse place
     * @param String department : This is the name of the department in which the biodiverse place is located
     * @param double size : This is the size of the place stored in km squared
     * @param double requiredBudget : This is the budget that the government provides to this place
     * @param String picOfLoc : This is the picture of the location. It is the file route (Ej. xxxxxx.jpg)
     * @param String dateOfIna : This is the date of inauguration requested as dd-mm-aaaa
     */
    public void createPlace(String namePlace, String department, double size, double requiredBudget, String picOfLoc, String dateOfIna){
        places[placesCount] = new Place(namePlace, department, size, requiredBudget, picOfLoc, dateOfIna);
        placesCount++;
        System.out.println("Place successfully registered");
    }
    /**
     * Description: This method sorts and calculates the sizes of all the registered places and outputs a list of the places organized from smallest to largest
     */
    public void consultPlace() {
        if (placesCount == 0) {
            System.out.println("Sorry, there currently are no registered places");
            return;
        }
        // Create a new array with the exact number of non-null places
        Place[] nonNullPlaces = new Place[placesCount];
        int index = 0;

        // Add only non-null places to the new array
        for (int i = 0; i < places.length; i++) {
            if (places[i] != null) {
                nonNullPlaces[index] = places[i];
                index++;
            }
        }
        // Sort the non-null places in ascending order by size
        Arrays.sort(nonNullPlaces, new Comparator<Place>() {
            @Override
            public int compare(Place p1, Place p2) {
                return Double.compare(p1.getSize(), p2.getSize());  // Ascending order. 
            }
        });

        // Display the name, department, and size of each place
        for (Place place : nonNullPlaces) {
            System.out.println("Name: " + place.getNamePlace() + ", Department: " + place.getDepartment() +", Size: " + place.getSize());
        }
    }    
    /**
     * Description: This method calculates which department has the largest amount of places registered within it.
     */
    public void maxDepartment() {
        if (placesCount == 0) {
            System.out.println("Sorry, there currently are no registered places.");
            return; // Exit early if no places are registered
        }
        String maxDept = "";
        int numMaxDept = 0;
    
        // Iterate through all registered places (up to placesCount)
        for (int i = 0; i < placesCount; i++) {
            if (places[i] == null) continue;  // Skip null entries just in case
    
            String currentDept = places[i].getDepartment();
            int currentDeptCount = 0;
    
            for (int j = 0; j < placesCount; j++) {
                if (places[j] != null && places[j].getDepartment().equalsIgnoreCase(currentDept)) {
                    currentDeptCount++;
                }
            }
            // Update maxDept if this department appears more times than the current max
            if (currentDeptCount > numMaxDept) {
                numMaxDept = currentDeptCount;
                maxDept = currentDept;
            }
        }
        System.out.println("The department with the most biodiverse places is " + maxDept + " with " + numMaxDept + " places.");
    }
    /**
     * Description: This method is the equivalent of a get, it finds a requested place.
     * @param String namePlace : This is the name of the place we are trying to find
     * @return : The array in which the name is found is returned. We use this to associate and consult various things
     */
    public Place findPlace(String namePlace){
        for(int i=0;i<placesCount;i++){
            if(places[i].getNamePlace().equalsIgnoreCase(namePlace)){
                return places[i];
            }
        }
        return null;
    }
    //Part 3
    /**
     * Description: This method calls the community constructor class and creates a new community
     * @param String communityName : This value represents the name of the community
     * @param CommunityType communityType : This enum validates that the community can be catalogued
     * @param String nameRepresentative : This value represents the name of the community representative to the government
     * @param String celRepresentative : This is the community representatives contact phone number.
     * @param int population : This is the given population of the community
     * @param NameIssue nameIssue : This enum logs an issue that each community has.
     */
    public void createCommunity(String communityName, CommunityType communityType,String nameRepresentative, String celRepresentative, int population, NameIssue nameIssue){
        communities[communityCount]=new Community(communityName, communityType, nameRepresentative, celRepresentative, population, nameIssue);
        communityCount++;
        System.out.println("Community successfully registered");
    }
    /**
     * Description: We use this method to add a species to a place. It registers a species and associates it directly with a registered place
     * @param String namePlace : Name of the place we want to add the species to
     * @param String speciesName : This is the name of the species to be registered
     * @param SpeciesType speciesType : This type enum validates whether its a Flora or Fauna
     * @param String speciesPicture : This, as in the case with the place, will take in the file route of an image
     * @param int speciesPopulation : This is the population number of this specimen.
     */
    public void associateSpecies(String namePlace, String speciesName, SpeciesType speciesType, String speciesPicture, int speciesPopulation) {
        Place place = findPlace(namePlace);
        if (place != null) {
            Species newSpecies = new Species(speciesName, speciesType, speciesPicture, speciesPopulation);
            place.addSpecies(newSpecies);
            
            // Add the new species to the species array
            for (int i = 0; i < species.length; i++) {
                if (species[i] == null) { 
                    species[i] = newSpecies;
                    break;
                }
            }
        } else {
            System.out.println("That place is currently not registered");
        }
    }
    /**
     * Description: This method associates a community with a place if allowed and shows a confirmation message
     * @param String namePlace: This is the name of the place to which a community will be associated to
     * @param String communityName: This is the name of a registered community that we will associate to a place
     */
    public void associateCommunity(String namePlace, String communityName) {
        // Find the Place by its name
        Place place = findPlace(namePlace);
        if (place == null) {
            System.out.println("That place is currently not registered");
            return;
        }
        // Find the Community by its name
        Community communityToAssociate = null;
        for (int i = 0; i < communityCount; i++) {
            if (communities[i] != null && communities[i].getCommunityName().equalsIgnoreCase(communityName)) {
                communityToAssociate = communities[i];
                break;
            } else{
                System.out.println("Sorry, this place already has a community registered to it");
            }
        }
        // If the community is found, associate it with the Place
        if (communityToAssociate != null) {
            place.addCommunity(communityToAssociate);
            System.out.println("Community " + communityName + " has been successfully associated with " + namePlace);
        } else {
            System.out.println("Community " + communityName + " is not registered."); 
        }
    }
    /**
     * Description: This method allows the user to modify an existing species. 
     * @param String speciesName : This is the name of the species we wish to modify
     * @param String newSpeciesName : This is the new name we will be assigining the species
     * @param SpeciesType newSpeciesType : This is the new type we will be assigning to the species
     * @param String newSpeciesPicture : This is the new picture of the species
     * @param int newSpeciesPopulation : This is the new population valur of the species
     * @return : Returns a confirmation message or an error message if unsuccessful.
     */
    public String modifySpecies(String speciesName, String newSpeciesName, SpeciesType newSpeciesType, String newSpeciesPicture, int newSpeciesPopulation) {
        // Check if species array is null or empty
        if (this.species == null || this.species.length == 0) {
            return "No species available to modify.";
        }

        for (Species species : this.species) {
            if (species != null && species.getSpeciesName().equalsIgnoreCase(speciesName)) {
                species.setSpeciesName(newSpeciesName);
                species.setSpeciesType(newSpeciesType);
                species.setSpeciesPicture(newSpeciesPicture);
                species.setSpeciesPopulation(newSpeciesPopulation);
                return "Species successfully modified";
            }
        }
        return "Sorry, we weren't able to modify your species. It may not exist.";
    }
    /**
     * Description : This method searches all communities that lack a hospital or school and outputs the name of these communities
     * @return : Returns a message that says which communities lack either a hosiptal or a school. Returns an error message if no communities have these issues
     */
    public Community commIssues(){
        for (int i = 0; i < communityCount; i++) {
            if (communities[i].getNameIssue().equals(NameIssue.NEEDSHOSPITAL)) {
                System.out.println("The community " + communities[i].getCommunityName() + " is in need of a hospital");
            } else if (communities[i].getNameIssue().equals(NameIssue.NEEDSSCHOOL)) {
                System.out.println("The community " + communities[i].getCommunityName() + " is in need of a school");
            } else{
                System.out.println("There are currently no registered communities which lack a hospital or school");
            }
        }
        // Return an appropriate Community object or null if there's nothing to return
        return null;
    }
    /**
     * Description : This method calculates which biodiverse place has the most amount of species registered to it
     * @return : Returns either an error message if there are no species registered or returns a message that shows which place has the most species
     */   
    public String maxSpecies() {
        int numMaxSpecies = 0;
        String maxPlace = "";
        
        for (int i = 0; i < placesCount; i++) {
            if (places[i] == null) continue; // Skip null places
            
            String currentPlace = places[i].getNamePlace();
            int currentSpeciesCount = 0;
            
            for (int j = 0; j < species.length; j++) {
                if (species[j] != null && places[i].getNamePlace().equals(currentPlace)) {
                    currentSpeciesCount++;
                }
            }
            
            if (currentSpeciesCount > numMaxSpecies) {
                numMaxSpecies = currentSpeciesCount;
                maxPlace = currentPlace;
            }
        }
        if(numMaxSpecies==0){
            return "There are currently no species registered";
        }
        return "The place with the most species is " + maxPlace + " with a total of " + numMaxSpecies + " species.";
    }
}