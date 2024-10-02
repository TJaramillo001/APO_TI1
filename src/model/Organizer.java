package model;

import model.Controller;

public class Organizer{
    private String organizerName;
    private String volunteerID;

    public Organizer(String organizerName, String volunteerID){
        this.organizerName=organizerName;
        this.volunteerID=volunteerID;
    }
    //Getters
    public String getOrganizerName(){
        return organizerName;
    }
    public String getVolunteerID(){
        return volunteerID;
    }
}