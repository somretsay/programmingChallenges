import java.util.HashMap;
import java.util.*;
public class toktik {
    public static void main(String[] args) {
        HashMap<Integer, String> view = new HashMap<>();
        HashMap<String, Integer> viewFlipped = new HashMap<>();

        Scanner keyboard = new Scanner(System.in);

        int entry = keyboard.nextInt();
        keyboard.nextLine();

        for(int i = 0 ; i<entry; i++){
            String account = keyboard.nextLine();
            String[] info = account.split(" ");
            String accountName = info[0];
            int viewCount = Integer.parseInt(info[1]);

            if(view.containsValue(accountName)){ // info[0] is the tiktok name and this is checking if it's not been added yet.
                
            int currentViews = viewFlipped.get(info[0]);   
            view.put(viewCount,info[0]+currentViews); // adding the updared view count. 
            view.remove(info[0]);
                
            
                
            }
            else{
                view.put(viewCount, accountName);
                viewFlipped.put(accountName,viewCount);
            }
            

            



        }
        System.out.println(view.entrySet());

    }
    
}
