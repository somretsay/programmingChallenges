import java.util.Arrays;
import java.util.Scanner;

public class ClassFieldTrip {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);

        String input1= keyboard.nextLine();
        String input2= keyboard.nextLine();
        String merged = input1 + input2;

        System.out.println(merged);
        
        char[] charArray = merged.toCharArray();
        Arrays.sort(charArray);
        System.out.println(charArray);

    }

}
