import java.util.Scanner;

public class addingtrouble {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int input1 = keyboard.nextInt();
        int input2 = keyboard.nextInt();
        int input3 = keyboard.nextInt();

        if(input1 + input2 == input3){
            System.out.println("correct!");

        }
        else{
            System.out.println("wrong!");
        }



        

    }

}
