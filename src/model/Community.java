package model;

import model.*;

public class Community{
    private String communityName;
    private CommunityType communityType;
    private String nameRepresentative;
    private String celRepresentative;
    private int population;
    private NameIssue nameIssue;

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

    //SETTERS
    public void setNameRepresentative(String nameRepresentative){
        this.nameRepresentative=nameRepresentative;
    }
    public void setCelRepresentative(String celRepresentative){
        this.celRepresentative=celRepresentative;
    }
    public void setPopulation(int population){
        this.population=population;
    }
    public void setNameIssue(NameIssue nameIssue){
        this.nameIssue=nameIssue;
    }
    
}