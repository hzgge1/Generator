package Generators;

import Enums.Colors;

public class Generators {

    //Distribuição Uniforme
    public static int clothesGenerator(double u, int n){
        return (int) (u*n);
    }

    //Distribuição Uniforme
    public static int colorsGenerator(double u){
        return (int) (u* Colors.values().length);
    }

    // equação Gerador de CHUVA
    public static int rainGenerator(double u){
        if(u < 0.19)
            return 1;
        return 0;
    }
    // equação Gerador de TEMPERATURA
    public static double temperatureGenerator(double u1, double u2){
        return (5.52 * Math.sqrt(-2 * Math.log(u1)) * Math.cos(2 * Math.PI * u2)) + 15.88;
    }

    // equação Gerador de HUMIDADE
    public static double humidityGenerator(double u1, double u2){
        return (5.52 * Math.sqrt(-2 * Math.log(u1)) * Math.cos(2 * Math.PI * u2)) + 79;
    }
}
