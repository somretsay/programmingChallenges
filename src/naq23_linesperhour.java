import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class naq23_linesperhour {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        if(keyboard.hasNextInt() && keyboard.hasNextInt()){
            //makes sure there is two inputs
            int n = keyboard.nextInt();
            int lph = keyboard.nextInt();
            int arr[] = {n,lph};
            //adds those inputs to an array
            int questions = 0;
            int target = arr[1]*5;
            //gets our target which we know because they can only do x lines per hour and the competition is 5 hours long
            int sum = 0;
            int count =0;
            //initializes our sum and count

        ArrayList<Integer> loc = new ArrayList<>();
        //new array for the input of lines per question(n)
        

        while(questions < arr[0]){
            //iterates through the array n times so you can only input through n times. 0 is the position not the value. 
            int lines = keyboard.nextInt();
            questions ++;
            loc.add(lines);

        }
        Collections.sort(loc);
        //sorts the arrray
        for(int num: loc){
            if(sum + num <= target){
                sum+=num;

                count++;
                //count is the count of questions
            }else{
                break;
            }
        }
        System.out.println(count);

        }
        
       
        
        



    }

}
