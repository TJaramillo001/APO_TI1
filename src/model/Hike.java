package model;

public class Hike{
    private RouteName routeName;
    private int guides;
    private int participants;
    /**
     * Description : This is the constructor class for Hike. This will store all information regarding a hike to one of the pre-registered routes
     * @param RouteName routeName : This type enum validates that the selected route is actually registered
     * @param int guides : This number is representative of the amount of human guides that will be assisting and helping visitors throughout the hike.
     * @param int participants : This number is representative of the number of human participants, volunteers, tourists, etc that will be participating in the visit to a certain route.
     */
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
    public RouteName getRouteName(){
        return routeName;
    }   
}