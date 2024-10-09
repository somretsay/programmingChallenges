import java.util.*;



public class babelfish {
    public static void main(String[] args) {
        //implement hashmap so it can have a dictionary
        Scanner keyboard = new Scanner(System.in);
        Map<String, String> newLan = new HashMap<>();
        
        while(keyboard.hasNextLine()){
            String word = keyboard.nextLine();
            String[ ] input = word.split(" ");
            
            if(input.length >= 2){
                String v = input[0];
                String k = input[1];
                newLan.put(k, v);
            }
            
            else if(word.isEmpty()){
                break; 
            } 
            
        }
        //prints the array to ensure it works
        //for (String name : newLan.keySet()) {
          //  System.out.println(name);
        //}

        
           while(keyboard.hasNextLine()){
            String ans = keyboard.nextLine();
            if(newLan.containsKey(ans)){
            System.out.println(newLan.get(ans));
             }
            else if(ans.isEmpty()){
                break;
             }
             else{
                System.out.println("eh");
            }
            
            
        }    
        // if statement for the inouts to check if its in the dictionary
       
        // if true then print the key but if not then print eh. 
    }

}
