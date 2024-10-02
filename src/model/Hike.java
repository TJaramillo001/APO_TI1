package model;

import model.Route;

public class Hike{
    private RouteName routeName;
    private int guides;
    private int participants;
    private int totalPeople;

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
    public static double busesNeeded(int guides, int participants){
        totalPeople = guides+participants;
        double numBus=(totalPeople/25)
        int necessaryBus=(int)(Math.ceil(numBus));

        return necessaryBus;
    }
}