package Enums;

import java.util.ArrayList;
import java.util.List;

//Tipo de roupa(calçado,parte de cima, etc..)
public enum Type {

    PARTE_CIMA,COMPLEMENTO_CIMA,PARTE_BAIXO,CALCADO,ACESSORIO;

    public static List<Type> getListOfTypes(){
        List<Type> result = new ArrayList<>();
        for(int i = 0; i < Type.values().length; i ++)
            result.add(Type.values()[i]);
        return result;
    }

    public static Type getTypeWithString(String s){
        switch(s){
            case "PARTE_CIMA":
                return Type.PARTE_CIMA;
            case "COMPLEMENTO_CIMA":
                return Type.COMPLEMENTO_CIMA;
            case "PARTE_BAIXO":
                return Type.PARTE_BAIXO;
            case "CALCADO":
                return Type.CALCADO;
            case "ACESSORIO":
                return Type.ACESSORIO;
            default:
                return null;
        }
    }

}
