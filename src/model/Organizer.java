package model;

public class Organizer{
    private String organizerName;
    private String volunteerID;
    /**
     * Description : This is the Organizer constructor, this stores information about the authorized organizers (Currently only Tomas, 1032876581)
     * @param String organizerName : This is the name of the organizer (In this case, Tomas, since there are no more authorized organizers)
     * @param String volunteerID : This is the organizers ID (In this case, Tomas' ID is 1032876581)
     */
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