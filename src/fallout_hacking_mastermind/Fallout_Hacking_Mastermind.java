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
public class Fallout_Hacking_Mastermind{

    public static int picks, size;
    public static ArrayList<String> WordList = new ArrayList<String>();      
    public static File dict = new File("C:/Users/Irukandji/Documents/NetBeansProjects/Fallout_Hacking_Mastermind/src/fallout_hacking_mastermind/enable1.txt");
    public static Scanner reader = new Scanner(System.in);
    public static String inpt;
    
    public static void main(String[] args) throws IOException {
    
        int diff;
        System.out.println("Please enter the difficulty level you wish to play at:");
        System.out.println("- Easy");
        System.out.println("- Medium");
        System.out.println("- Hard");
        System.out.println();
        String input = reader.nextLine().toLowerCase();
        if(input.equals("easy")){
            diff = 0;
            System.out.println("Easy difficulty selecterd.");
            runGame(setSize(diff),setPicks(diff));
        }else
            if(input.equals("medium")){
                diff=1;
                System.out.println("Medium difficulty selected.");
                runGame(setSize(diff),setPicks(diff));
            }else if(input.equals("hard")){
                diff=2;
                System.out.println("Hard difficulty selected.");
                runGame(setSize(diff),setPicks(diff));
            }else{
                System.out.println("Invalid input. Please restart the program and try again.");
            }
        reader.close();
        
    }
    
    public static void runGame(int q, int w) throws FileNotFoundException, IOException{
        
        BufferedReader dictreader = new BufferedReader(new FileReader(dict));
        String word = null;
        String pass = null;
        while((word=dictreader.readLine())!=null){
            if(word.length()==q){
                WordList.add(word);
            }
            word=dictreader.readLine();
        }
        Random rnd = new Random();
        String arr[]=new String[q];
                for(int i=0; i<q; i++){
                    arr[i]=WordList.get(rnd.nextInt(WordList.size())).toUpperCase();
                }
                pass = arr[rnd.nextInt(arr.length)];
                boolean found=false;
                do{
                    System.out.println();
                    System.out.println("==========");
                    for(int i=0; i<arr.length; i++){
                        System.out.println(arr[i]);
                    }
                    System.out.println("==========");
                    System.out.println();
                    System.out.println(w + " guesses left. Please enter your guess:");
                    int sum=0;
                    //Scanner in = new Scanner(System.in);
                    //String inpt = in.nextLine().toUpperCase();
                    inpt = reader.nextLine().toUpperCase();
                    if(inpt.equals(pass)){
                        System.out.println(q+"/"+q+" correct. You win!");
                        found=true;
                    }else{
                    for(int i=0; i<inpt.length(); i++){
                        if(inpt.charAt(i)==pass.charAt(i)){
                            sum++;
                            }
                        }
                    }
                    /*if(sum==inpt.length()){
                        found=true;
                        System.out.println(sum + "/" + q + " correct. You win!");
                    }else*/
                    if(sum!=inpt.length()&&found!=true){
                        System.out.println(sum + "/" + q + " correct. Try again.");
                        w--;
                    }
                    //in.close();
                }while(found!=true&&w>0);
                if(w==0){
                    System.out.println("0 guesses left. Game over.");
                    System.out.println("TEST PURPOSE ONLY - Pass was: " + pass);
                }
                dictreader.close();
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
    
    public static int setSize(int q){
        switch(q){
            case 0:
                size=5;
                return size;
            case 1:
                size=7;
                return size;
            case 2:
                size=10;
                return size;
            default:
                return 0;
        }
    }
    
    public static int setPicks(int q){
        switch(q){
            case 0:
                picks=3;
                return picks;
            case 1:
                picks=4;
                return picks;
            case 2:
                picks=5;
                return picks;
            default:
                return 0;
        }
    }
}
