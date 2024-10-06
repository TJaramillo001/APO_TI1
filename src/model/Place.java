package model;

public class Place{
    private String namePlace;
    private String department;
    private double size;
    private double requiredBudget;
    private String picOfLoc; //picture of location
    private String dateOfIna; //Inauguration

    private Species[] species;
    private Community[] comms;
    
    /**
     * Description: This is the constructor class for all places. This will store place information to be consulted later
     * @param String namePlace : This is the name of the biodiverse place
     * @param String department : This is the name of the department in which the biodiverse place is located
     * @param double size : This is the size of the place stored in km squared
     * @param double requiredBudget : This is the budget that the government provides to this place
     * @param String picOfLoc : This is the picture of the location. It is the file route (Ej. xxxxxx.jpg)
     * @param String dateOfIna : This is the date of inauguration requested as dd-mm-aaaa
     */
    public Place(String namePlace, String department, double size, double requiredBudget, String picOfLoc, String dateOfIna){
        this.namePlace= namePlace;
        this.department=department;
        this.size=size;
        this.requiredBudget=requiredBudget;
        this.picOfLoc=picOfLoc;
        this.dateOfIna=dateOfIna;

        this.species=new Species[50]; //There is a limit of 50 species per place
        this.comms= new Community[1]; //There can only be one community in each place
    }
    //Getters
    public String getNamePlace(){
        return namePlace;
    }
    public String getDepartment(){
        return department;
    }
    public double getSize(){
        return size;
    }
    public double getRequiredBudget(){
        return requiredBudget;
    }
    public String getPicOfLoc(){
        return picOfLoc;
    }
    public String getDateOfIna(){
        return dateOfIna;
    }
    //Setters not included since the data isn't modified
    
    //Methods
    /**
     * Description: This method adds a registered species to a specific place
     * @param Species spec : This imports the Species array and associates it to a specific place
     */
    public void addSpecies(Species spec){
        for(int i=0;i<species.length;i++){
            if(species[i]==null){
                species[i]=spec;
                System.out.println("Species successfully registered.");
                break;
            }
        }
    }
    /**
     * Description: This method associates a community to a place as the caretaker
     * @param Community community: This imports the Community information and associates it to a requested place
     */
    public void addCommunity(Community community){
        for(int i=0;i<comms.length;i++){
            if(comms[i]==null){
                comms[i]=community;
    
                System.out.println("Community successfully registered.");
                break;
            }
        }
    }
}