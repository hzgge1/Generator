package User;
import Enums.*;

import java.io.File;
import java.util.List;
import java.util.Scanner;


public class Clothes {

    //atriibutos da roupa

    private String name;
    private List<Temperature> temperature;
    private List<Colors> color;
    private List<Humidity> humidity;
    private boolean isRain;
    private Type type;
    private List<Event> event;
    private String url;

    public Clothes(String name, List<Temperature> temperature, List<Colors> color, List<Humidity> humidity,boolean isRain,Type type, List<Event> event, String url){
        this.name=name;
        this.temperature=temperature;
        this.color=color;
        this.humidity=humidity;
        this.isRain=isRain;
        this.type=type;
        this.event=event;
        this.url=url;
    }

    public static Clothes lineToClothes(String s) {
        String[] data = s.split(",");
        Temperature.CALOR.toString();

        return new Clothes(data[0],Temperature.getListTemperatureWithString(data[1]),Colors.getListColorWithString(data[2]),
                Humidity.getListHumidityWithString(data[3]),Boolean.parseBoolean(data[4]),
                Type.getTypeWithString(data[5]),Event.getListEventWithString(data[6]),data[7]);
    }

    public String ClothesToString(){
        return name+","+Temperature.toString(temperature)+","+Colors.toString(color)+","+Humidity.toString(humidity)+","+isRain+","+type.name()+","+Event.toString(event)+","+url;
    }

    public boolean canBeSelected(Temperature temperature, Humidity humidity, boolean rainBoolean, Colors colors) {
        if(!this.temperature.contains(temperature))
            return false;
        if(!this.humidity.contains(humidity))
            return false;
        if(this.isRain != rainBoolean)
            return false;
        if(!color.contains(colors))
            return false;
        return true;
    }

    public boolean isEventOf(Event e){
        return this.event.contains(e);
    }

    public boolean isTypeOf(Type t) { return this.type.equals(t); }

    public String getURL(){
        return url;
    }
}
