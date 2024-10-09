import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class GuesstheNumber {
    public static void main(String[] args) {
        int wrongAnswers = 0;
        Random randomNum = new Random();
        Scanner keyboard = new Scanner(System.in);
        //System.out.println(num);

        int numberofgames = keyboard.nextInt();
        int iterationofgames=0;
        int num = randomNum.nextInt(1,101);
        while(wrongAnswers != 10){
            while(iterationofgames<numberofgames){
            
            int guessednum = keyboard.nextInt();

            if(guessednum==num){
                System.out.println("correct");
                break;
            }
            else if(guessednum<num){
                System.out.println("higher");
                wrongAnswers++;

            }
            else if(guessednum>num){
                System.out.println("lower");
                wrongAnswers++;
            }
            //if correct then break 
            //if less than say higher .. 
            //if greater say lower 
            


        }
        }
        





    }

}
