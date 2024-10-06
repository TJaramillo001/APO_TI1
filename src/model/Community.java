package model;

public class Community{
    private String communityName;
    private CommunityType communityType;
    private String nameRepresentative;
    private String celRepresentative;
    private int population;
    private NameIssue nameIssue;
    /**
     * Description: This is the constructor class for the communities. It will store all community information.
     * @param String communityName : This value represents the name of the community
     * @param CommunityType communityType : This enum validates that the community can be catalogued
     * @param String nameRepresentative : This value represents the name of the community representative to the government
     * @param String celRepresentative : This is the community representatives contact phone number.
     * @param int population : This is the given population of the community
     * @param NameIssue nameIssue : This enum logs an issue that each community has.
     */
    public Community(String communityName, CommunityType communityType, String nameRepresentative, String celRepresentative, int population, NameIssue nameIssue){
        this.communityName=communityName;
        this.communityType=communityType;
        this.nameRepresentative=nameRepresentative;
        this.celRepresentative=celRepresentative;
        this.population=population;
        this.nameIssue=nameIssue;
    }
    //GETTERS
    public String getCommunityName(){
        return communityName;
    }
    public CommunityType getCommunityType(){
        return communityType;
    }
    public String getNameRepresentative(){
        return nameRepresentative;
    }
    public String getCelRepresentative(){
        return celRepresentative;
    }
    public int getPopulation(){
        return population;
    }
    public NameIssue getNameIssue(){
        return nameIssue;
    }
    //We dont need setters since this information won't be modified
    
}