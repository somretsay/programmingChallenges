// Recount, Kattis, Curt Powley

// example java template code
// HashMap using containsKey, incrementing values, checking for ties, and keeping track of leader
// when no tie for the lead.
//
// Can consider two basic simulation approaches.
// (1) keep track of each vote as it comes in, and the current leader (or leaders if there is a tie).
// (2) record all votes, then at the end, check the results by traversing through all candidates and their votes. 

import java.util.*;

public class recount {

    public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    Map<String, Integer> counts = new HashMap<>();
    int value = 1; 
    boolean runoff = false;

    // your code here    
    for (String candidate=keyboard.nextLine(); !candidate.equals("***"); candidate=keyboard.nextLine()) {

        if(counts.containsKey(candidate)){
                int currentcount = counts.get(candidate);
                counts.put(candidate,currentcount+1);
        }
        else{
                counts.put(candidate,value);
                
        }

        // your code here
    }
    
    
    int maxVotes = Collections.max(counts.values());
    int leaderCount = 0;

    for (int votes : counts.values()) {
        if (votes == maxVotes) {
            leaderCount++;
        }
    }

    runoff = leaderCount > 1;

    if (runoff) {
        System.out.println("Runoff!");
    } else {
        System.out.println(Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey());
    }


}}
