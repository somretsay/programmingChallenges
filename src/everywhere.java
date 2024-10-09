import java.util.HashSet;
import java.util.Scanner;

public class everywhere {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
       
        int counter=0;  
        
        
        
        int testcases = keyboard.nextInt();

        for(int i =1 ; i<=testcases; i++){
           
            int subTestCase = keyboard.nextInt();
            HashSet<String> list = new HashSet<>();
            keyboard.nextLine();
            
            for(int q = 1; q<=subTestCase; q++){
                
                String city = keyboard.nextLine();
                list.add(city);
                    
                
               
            }

             System.out.println(list.size());
            
        }
        
       

    }

}
