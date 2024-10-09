import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class hissingmicrophone {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String word = keyboard.nextLine();
        //creates instance for the user input
        Pattern pattern =Pattern.compile("ss", Pattern.CASE_INSENSITIVE);
        //looks for "pattern" in this case it is the double ss and then it creates the condition that itdoesnt matter for lower case pr upper case
        Matcher match = pattern.matcher(word);
        //uses Matcher class to see if the the match is the same as the word in this case ss
        boolean matcher = match.find();
        //uses boolean to see if it can find the pattern in the word. 
        if(matcher){
            System.out.println("hiss");
        }
        else{
            System.out.println("no hiss");
        }


    }

}
