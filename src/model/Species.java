package model;

public class Species{
    private String speciesName;
    private SpeciesType speciesType;
    private String speciesPicture;
    private int speciesPopulation;
    /**
     * Description: This is the Species constructor class. It will store all species registered.
     * @param String speciesName : This is the name of the species to be registered
     * @param SpeciesType speciesType : This type enum validates whether its a Flora or Fauna
     * @param String speciesPicture : This, as in the case with the place, will take in the file route of an image
     * @param int speciesPopulation : This is the population number of this specimen.
     */
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
    //Setters to modify the species
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
}