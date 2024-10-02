package model;

import model.*;

public class Species{
    private String speciesName;
    private SpeciesType speciesType;
    private String speciesPicture;
    private int speciesPopulation;

    public Species(String speciesName, SpeciesType speciesType, String speciesPicture, int speciesPopulation){
        this.speciesName=speciesName;
        this.speciesType=speciesType;
        this.speciesPicture=speciesPicture;
        this.speciesPopulation=speciesPopulation;
    }
    //Getters
    public String getSpeciesName(){
        return speciesName;
    }
    public SpeciesType getSpeciesType(){
        return speciesType;
    }
    public String getSpeciesPicture(){
        return speciesPicture;
    }
    public int getSpeciesPopulation(){
        return speciesPopulation;
    }
    //Setters
    public void setSpeciesName(String speciesName){
        this.speciesName=speciesName;
    }
    public void setSpeciesType(SpeciesType speciesType){
        this.speciesType=speciesType;
    }
    public void setSpeciesPicture(String speciesPicture){
        this.speciesPicture=speciesPicture;
    }
    public void setSpeciesPopulation(int speciesPopulation){
        this.speciesPopulation=speciesPopulation;
    }

    //Place with most species?
}