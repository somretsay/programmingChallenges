import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class naq23_contestadvancement {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Map<Integer, Integer> scoreboard = new LinkedHashMap<>();
        if(keyboard.hasNextInt() && keyboard.hasNextInt() && keyboard.hasNextInt()){
        int n = keyboard.nextInt();
        // n is number of teams
        int k = keyboard.nextInt();
        // k is number of winners from each team is allowed
        int c = keyboard.nextInt(); 
        // c is number of teams that is allowed to win in total 
        int max = k;

        int iterations = 0;
       // while loop goes on n times for each time so we know how many teams to input. 
        while(iterations < n){
            if(keyboard.hasNextInt() && keyboard.hasNextInt()){
                int team = keyboard.nextInt();
                int teamschool = keyboard.nextInt();
                scoreboard.put(team,teamschool);
                iterations++;
                


                

            }
        }
        

        
         
        
        }
        else{
            System.out.println("Enter n,k,c again");
        }

       

        
    }

}
