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
    public Controller(){
        this.places=new Place[10]; //No se da un límite de lugares, entonces se asume que 10 es un valor máximo.
        this.placesCount=0;
        Route rLadera = new Route("Ladera","7:00am","4:00pm","Bulevar del Rio");
        Route rFarallones = new Route("Farallones","6:40am","4:00pm","Calle 16 - Universidad del Valle");
        Route rOriente = new Route("Oriente","7:00am","4:00pm","Bulevar del Rio");
        Organizer Tomas = new Organizer("Tomas","admin");
    }
    //PARTE 1
    //public void scheduleHike
    //showMetData
    //Parte 2
    public void createPlace(String namePlace, String department, double size, double requiredBudget, String picOfLoc, String dateOfIna){
        places[placesCount] = new Place(namePlace, department, size, requiredBudget, picOfLoc, dateOfIna);
        placesCount++;
    }

    public void consultPlace(){
        String placeList="";
        if(placesCount==0){
            placeList="Sorry, there currently are no registered places";
            return;
        }

        Arrays.sort(places, new Comparator<Place>(){
            @Override
            public int compare(Place p1, Place p2){
                return Double.compare(p1.getSize(), p2.getSize());
            }
        });
        for(Place place : places){
            System.out.println(place.getSize());
        }
    }

    public String maxDepartment(){
        String reply="";
        if(placesCount==0){
            reply="Sorry, there currently are no registered places";
            return reply;
        }
        String maxDept = ""; //Name of department that appears the most
        int numMaxDept = 0; // Number of times maxDept appears

        for (int i=0; i<places.length;i++){
            String currentDept = places[i].getDepartment();
            int currentDeptCount=0;

            for(int j=0;j<places.length;j++){
                if(places[j].getDepartment().equalsIgnoreCase(currentDept)){
                    currentDeptCount++;
                }
            }
            if(currentDeptCount>numMaxDept){
                numMaxDept=currentDeptCount;
                maxDept=currentDept;
            }
        }
        reply="\nThe department with the most biodiverse places is " + maxDept +" with " + numMaxDept + " places.";
        return reply;

    }
    public Place findPlace(String namePlace){
        for(int i=0;i<placesCount;i++){
            if(places[i].getNamePlace().equalsIgnoreCase(namePlace)){
                return places[i];
            }
        }
        return null;
    }
    
    //Parte 3
    public void associateSpecies(String namePlace, String speciesName, SpeciesType speciesType, String speciesPicture, int speciesPopulation){
        Place place = findPlace(namePlace);
        if(place!=null){
            place.addSpecies(new Species(speciesName, speciesType, speciesPicture, speciesPopulation));
        }
    }

    public void associateCommunity(String namePlace, String communityName, CommunityType communityType, String nameRepresentative, String celRepresentative, int population, NameIssue nameIssue){
        Place place=findPlace(namePlace);
        if(place!=null){
            place.addCommunity(new Community(communityName, communityType, nameRepresentative, celRepresentative, population, nameIssue));
            communityCount++;
        }
    }

    public boolean modifySpecies(String speciesName, SpeciesType newSpeciesType, String newSpeciesPicture, int newSpeciesPopulation){
        for(Species species:this.species){
            if(species.getSpeciesName().equalsIgnoreCase(speciesName)){
                species.setSpeciesType(newSpeciesType);
                species.setSpeciesPicture(newSpeciesPicture);
                species.setSpeciesPopulation(newSpeciesPopulation);
                return true;
            }
        }
        return false;

    public Community commIssues(){
        for(int i=0;i<communityCount;i++){
            if(communities[i].getCommunityType().equals(FALTAHOSPITAL))
        }
    }    
    }
    /*
     * public Place findPlace(String namePlace){
        for(int i=0;i<placesCount;i++){
            if(places[i].getNamePlace().equalsIgnoreCase(namePlace)){
                return places[i];
            }
        }
        return null;
    }
     */

}   