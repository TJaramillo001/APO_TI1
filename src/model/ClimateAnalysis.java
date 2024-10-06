 package model;

 public class ClimateAnalysis{
    private double temperature;
    private double humidity;
    /**
     * Description: This is the constructor for the Climate analysis class which stores the given temperature and humidity percentage
     * @param double temperature : This number represents the temperature
     * @param double humidity : This number represents the relative humidity
     */
    public ClimateAnalysis(double temperature, double humidity){
        this.temperature=temperature;
        this.humidity=humidity;
    }
    //Getters
    public double getTemperature(){
        return temperature;
    }
    public double getHumidity(){
        return humidity;
    }
    /**
     * Description: This method calculates the meterological data of the day and returns whether it's a good day to hike or not.
     * @param double temp : This recieves the user-inputted temperature
     * @param humidity : This represents a percentage of today's humidity
     * @return
     */
    public static String showMeterologicalData(double temp, double humidity){
        String dayInfo=(temp<=25 && temp>=20 && humidity>=40 && humidity<=60)?"It's a good day to walk in Cali!":"";
        // if method that analizes if it's a good day or not
        return(dayInfo);
    }
 }