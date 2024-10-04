package model;

import model.*;

public class Place{
    private String namePlace;
    private String department;
    private double size;
    private double requiredBudget;
    private String picOfLoc; //picture of location
    private String dateOfIna; //Inauguration

    private Species[] species;
    private Community[] comms;
    
    public Place(String namePlace, String department, double size, double requiredBudget, String picOfLoc, String dateOfIna){
        this.namePlace= namePlace;
        this.department=department;
        this.size=size;
        this.requiredBudget=requiredBudget;
        this.picOfLoc=picOfLoc;
        this.dateOfIna=dateOfIna;

        this.species=new Species[50];
        this.comms= new Community[1]
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
    //Setters
    public void setRequiredBudget(double requiredBudget) {
        this.requiredBudget = requiredBudget;
    }
    //Methods
    public void addSpecies(Species spec){
        for(int i=0;i<species.length;i++){
            if(species[i]==null){
                species[i]=spec;
                //speciesCount++
                System.out.println("Species successfully registered.");
                break;
            }
        }
    }
    public void addCommunity(Community community){
        for(int i=0;i<comms.length;i++){
            if(comms[i]==null){
                comms[i]=community;
                //speciesCount++
                System.out.println("Community successfully registered.");
                break;
            }
        }
    }
    
}