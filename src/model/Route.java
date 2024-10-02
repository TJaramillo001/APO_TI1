package model;

import model.*;

public class Route{
    private String routeName;
    private String routeStartTime;
    private String routeEndTime;
    private String routeEncounterPoint;

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

    //Route rutaLadera = new Route("....")
}