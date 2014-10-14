/**
 *  Program that simulates the Fallout games' Hacking minigame.
 *  Based on this reddit daily challenge:
 *  http://goo.gl/WIbXkL
 */
package fallout_hacking_mastermind;
import java.util.*;
import java.io.*;

/**
 *
 * @author todyerutz@plainintricacy.wordpress.com
 * 
 */
public class Fallout_Hacking_Mastermind {

    public static int picks, size;
    public static ArrayList<String> WordList = new ArrayList<String>();
    File dict = new File("C:/Users/Irukandji/Documents/NetBeansProjects/Fallout_Hacking_Mastermind/src/fallout_hacking_mastermind/enable1.txt");
    
    public static void main(String[] args) {
    
        Scanner reader = new Scanner(System.in);
        int diff;
        System.out.println("Please enter the difficulty level you wish to play at:");
        System.out.println("- Easy");
        System.out.println("- Medium");
        System.out.println("- Hard");
        String input = reader.nextLine().toLowerCase();
        if(input=="easy"){
            diff = 0;
            System.out.println("Easy difficulty selecterd.");
        }else
            if(input=="medium"){
                diff=1;
                System.out.println("Medium difficulty selected.");
            }else if(input=="hard"){
                diff=2;
                System.out.println("Hard difficulty selected.");
            }else{
                System.out.println("Invalid input. Please restart the program and try again.");
            }
        
        
    }
    
    public static void runGame(int q){
        switch(q){
            case 0:
                picks=3;
                size=5;
                break;
            case 1:
                picks=4;
                size=7;
                break;
            case 2:
                picks=5;
                size=10;
                break;
        }
    }
    
    public static void getList(BufferedReader x, int s) throws IOException{
        String word = x.readLine();
        while(word!=null){
            if(word.length()==s){
                WordList.add(word);
            }
            word=x.readLine();
        }
    }
    
    public static void getArray(ArrayList x){
        
    }
}
