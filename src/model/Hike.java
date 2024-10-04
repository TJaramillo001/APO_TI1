package model;

import model.Route;

public class Hike{
    private RouteName routeName;
    private int guides;
    private int participants;

    public Hike(RouteName routeName, int guides, int participants){
        this.routeName=routeName;
        this.guides=guides;
        this.participants=participants; 
    }
    //Getters
    public int getGuides(){
        return guides;
    }
    public int getParticipants(){
        return participants;
    }
    
}