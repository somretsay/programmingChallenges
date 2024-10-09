import java.util.ArrayList;
import java.util.Scanner;

public class taxes {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int i =1;
        int income;
        ArrayList<Integer> incomeS = new ArrayList<Integer>();
        while(true){
            
            
            double fed;
            double state;

           

            System.out.println("Enter your income for job " + i +":");
            income = keyboard.nextInt();
            //System.out.println("Federal Tax 18.5%");
            //System.out.println("State Tax 8.75");
            i++;
           
            
            

            if(income == -1 ){
                           break;
                           
          }
          else if(income <0){
            System.out.println("income cannot be less than 0");
            i--;

          }
          else{
             incomeS.add(income);
          }

         
            
          

        }
        int sum = 0; 
        for (int num : incomeS) { 
            sum += num; 
        } 

        double fed = sum-(sum*.185);
        double state = sum-(sum*.0875);

        System.out.println("Total Income before taxes: $" +sum);
        System.out.println("Income after federal taxes: $" + fed);
        System.out.println("Income after state taxes: $" + state);

        
        
    }
    
}
