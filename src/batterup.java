import java.util.Scanner;

public class batterup {
    public static void Main (String args[]){
        Scanner keyboard = new Scanner(System.in);
        
        double atbats = keyboard.nextInt();
        double hits = keyboard.nextInt();
        String[] hitcounts = hits.split(" ");

        double slugging = hits/atbats;
        

        
    }
}
