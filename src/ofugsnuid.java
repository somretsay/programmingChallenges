import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ofugsnuid {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int iterations = 0;
        int num;
        ArrayList<Integer> arr = new ArrayList<>();

        while(iterations < n){
            num = keyboard.nextInt();
            arr.add(num);
            iterations++;
        }
        Collections.reverse(arr);
        for(Integer numbers: arr){
            System.out.println(numbers);
        }
        
    }

}
