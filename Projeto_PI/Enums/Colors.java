package Enums;

import java.util.*;

public enum Colors {

    GAMA1("Azul,Laranja"),GAMA2("Rosa,Verde"),GAMA3("Vermelho,Verde"),
    GAMA4("Amarelo,Roxo"), GAMA5("Laranja,Preto,Branco"), GAMA6("Preto ,Branco");

    private String c;

    private Colors(String c){
        this.c = c;
    }

    public String toString(){
        return name() + " (" + c + ")";
    }

    public boolean isColorInGama(String s){
        return c.contains(s);
    }

    public static List<Colors> getListColorWithString(String s){
        List<Colors> colors = new ArrayList<>();
        String[] data = s.split(":");
        for(int i=0; i<data.length; i++) {
            Colors c = Colors.getGamaWithString(data[i]);
            if(!c.equals(null)) colors.add(c);
        }
        return colors;
    }

    private static Colors getGamaWithString(String s){
        for(Colors c : Colors.values())
            if(c.isColorInGama(s) || c.name().equals(s)) return c;
        return null;
    }



    public static  String toString(List<Colors> colors){
        String s="";
        for(Colors c: colors){
            Colors c1 = Colors.getGamaWithString(c.name());
            if(!c1.name().isEmpty())
                s+=c1.name()+":";
        }
        return s.substring(0,s.length()-1);
    }

    public static Colors getColors(int i) {
        return Colors.values()[i];
    }

}
