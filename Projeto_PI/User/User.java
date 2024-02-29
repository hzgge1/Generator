package User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public List<Clothes> getCloset() throws FileNotFoundException {
        File file = new File(username + ".txt");
        Scanner s = new Scanner(file);
        List<Clothes> closet = new ArrayList<>();
        while(s.hasNextLine())
            closet.add(Clothes.lineToClothes(s.nextLine()));
        return closet;
    }

    public String getUername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public static boolean isUser(String username, String password) throws FileNotFoundException {
        File file = new File("users.txt");
        Scanner s = new Scanner(file);
        while(s.hasNextLine()){
            String aux = s.nextLine();
            String[] array = aux.split(" ");
            if(array[0].equals(username) && array[1].equals(password))
                return true;
        }
        s.close();
        return false;
    }

    public static boolean canBeUser(String username) throws FileNotFoundException {
        File file = new File("users.txt");
        Scanner s = new Scanner(file);
        while(s.hasNextLine()){
            String aux = s.nextLine();
            String[] array = aux.split(" ");
            if(array[0].equals(username))
                return false;
        }
        s.close();
        return true;
    }

    public static void registerUser(String username, String password) throws IOException {
        File file = new File("users.txt");
        PrintWriter w = new PrintWriter(new FileWriter(file,true));
        w.println(username + " " + password);
        w.close();
    }


    @Override
    public String toString(){
        return username + " " + password;
    }

    public  void registerClothes(Clothes c) throws IOException {
        File file = new File(username+".txt");
        PrintWriter w = new PrintWriter(new FileWriter(file,true));
        w.println(c.ClothesToString());
        w.close();
    }
}
