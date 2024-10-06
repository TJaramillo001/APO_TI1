package model;

public class Route{
    private String routeName;
    private String routeStartTime;
    private String routeEndTime;
    private String routeEncounterPoint;
    /**
     * Description: This is the constructor class for the route. It will store the predetermined routes.
     * @param String routeName : This is the name of the route and will be either Farallones, Ladera or Oriente
     * @param String routeStartTime : This will be the time that the hike starts
     * @param String routeEndTime : This will be the time at which the hike ends and they return to Cali
     * @param String routeEncounterPoint : This is the address of a place in Cali where participants are expected to meet up.
     */
    public Route(String routeName, String routeStartTime, String routeEndTime, String routeEncounterPoint){
        this.routeName=routeName;
        this.routeStartTime=routeStartTime;
        this.routeEndTime=routeEndTime;
        this.routeEncounterPoint=routeEncounterPoint;
    }
    //Getters
    public String getRouteName(){
        return routeName;
    }
    public String getRouteStartTime(){
        return routeStartTime;
    }
    public String getRouteEndTime(){
        return routeEndTime;
    }
    public String getRouteEncounterPoint(){
        return routeEncounterPoint;
    }
    /**
     * Description: This method will be used to get all the route info back to the user in an organized manner
     * @return String: The return will return the name of the Route, its encounter and its start and end time in that same order.
     */
    public String getRouteInfo(){
        return "Route: "+routeName+".\nEncounters at: "+routeEncounterPoint+".\nStart Time: "+routeStartTime+".\nEnd Time: "+routeEndTime;
    }
}