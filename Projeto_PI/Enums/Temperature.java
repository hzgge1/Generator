package Enums;

import java.util.ArrayList;
import java.util.List;
import Generators.Generators;
import javafx.collections.FXCollections;

public enum Temperature {


    MUITO_FRIO(-100,5), FRIO(5,15), AMENO(15,25), CALOR(25,100);

    //Muito frio [math.minNumberPossible,5]
    //frio [5-15]
    //ameno[15-25]
    //calor[25-math.maxNumberPossible]

    private int min;
    private int max;

    private Temperature(int min, int max){
        this.min=min;
        this.max=max;
    }

    public String toString(){
        String[] aux = name().split("_");
        String s = "";
        for(String a : aux) s += a + " ";
        return s + getMinMax();
    }

    public int getMin(){
        return min;
    }

    public int getMax(){
     return max;
    }

    public String getMinMax(){
        return "("+getMin()+","+getMax()+")";
    }

    public static List<Temperature> getListTemperatureWithString(String s){
        List<Temperature> temperatures = new ArrayList<>();
        String[] data = s.split(":");
        for(int i=0; i<data.length; i++) {
            Temperature t = getTemperatureWithString(data[i]);
            if(!t.equals(null)) temperatures.add(t);
        }
        return temperatures;
    }

    private static Temperature getTemperatureWithString(String s){
        for(Temperature t : Temperature.values())
            if(t.name().equals(s)) return t;
        return null;
    }

    public static String toString(List<Temperature> temperatures){
        String s="";
        for(Temperature t: temperatures){
            Temperature t1 = getTemperatureWithString(t.name());
            if(!t1.name().isEmpty())
                s+=t1.name()+":";
        }
        return s.substring(0,s.length()-1);
    }

    public static List<Temperature> getListOfTemperatures(){
        List<Temperature> result = new ArrayList<>();
        for(int i = 0; i < Temperature.values().length; i ++)
            result.add(Temperature.values()[i]);
        return result;
    }
    public static Temperature getTemperature(double d) {
        for(Temperature t : Temperature.values())
            if(d < t.getMax() && d >= t.getMin() )
                return t;
        return null;
    }

}
