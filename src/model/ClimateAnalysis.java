 package model;

 import model.Hike;

 public class ClimateAnalysis{
    private double temperature;
    private double humidity;

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
    public String showMeterologicalData(double temp, double humidity){
        String infoDia=(temp<=25 && temp>=20 && this.humidity>=40 && this.humidity<=60)?"It's a good day to walk in Cali":"";
        // if method that analizes if it's a good day or not
        return(infoDia);
    }
 }