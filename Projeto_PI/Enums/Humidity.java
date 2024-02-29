package Enums;

import java.util.ArrayList;
import java.util.List;
import Generators.Generators;
public enum Humidity {

    MENOS_HUMIDO(24,45), MEIO_HUMIDO(45,65), HUMIDO(65,85), MUITO_HUMIDO(85,100);

    private int min;
    private int max;

    private Humidity(int min, int max){
        this.min=min;
        this.max=max;
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

    public String toString(){
        String s = "";
        String[] aux = name().split("_");
        for(String a : aux) s += a + " ";
        return s + getMinMax();
    }

    public static List<Humidity> getListHumidityWithString(String s){
        List<Humidity> humidities = new ArrayList<>();
        String[] data = s.split(":");
        for(int i=0; i<data.length; i++) {
            Humidity h = getHumidityWithString(data[i]);
            if(!h.equals(null)) humidities.add(h);
        }
        return humidities;
    }

    private static Humidity getHumidityWithString(String s){
        for(Humidity h : Humidity.values())
            if(h.name().equals(s)) return h;
        return null;
    }

    public static String toString(List<Humidity> humidities){
        String s="";
        for(Humidity h: humidities){
            Humidity h1 = getHumidityWithString(h.name());
            if(!h1.name().isEmpty())
                s+=h1.name()+":";
        }
        return s.substring(0,s.length()-1);
    }

    public static List<Humidity> getListOfHumidity(){
        List<Humidity> result = new ArrayList<>();
        for(int i = 0; i < Humidity.values().length; i ++)
            result.add(Humidity.values()[i]);
        return result;
    }
    public static Humidity getHumidity(double d) {
        for(Humidity h : Humidity.values())
            if(d < h.getMax() && d >= h.getMin() )
                return h;
        return null;
    }
}
