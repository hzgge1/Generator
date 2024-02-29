package Enums;

import java.util.ArrayList;
import java.util.List;

public enum Event {

    CASAMENTO,FORMAL,DESPORTO,FUNERAL,PRAIA,CASUAL;



    public static List<Event> getListOfEvents(){
        List<Event> result = new ArrayList<>();
        for(int i = 0; i < Event.values().length; i ++)
            result.add(Event.values()[i]);
        return result;
    }

    public static List<Event> getListEventWithString(String s){
        List<Event> events = new ArrayList<>();
        String[] data = s.split(":");
        for(int i=0; i<data.length; i++) {
            Event e = getEventWithString(data[i]);
            if(!e.equals(null)) events.add(e);
        }
        return events;
    }

    private static Event getEventWithString(String s){
        for(Event e : Event.values())
            if(e.name().equals(s)) return e;
        return null;
    }

    public static String toString(List<Event> events){
        String s="";
        for(Event t: events){
            Event t1 = getEventWithString(t.name());
            if(!t1.name().isEmpty())
                s+=t1.name()+":";
        }
        return s.substring(0,s.length()-1);
    }
}
