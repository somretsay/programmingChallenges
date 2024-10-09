import java.util.Scanner;

public class nodup {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        String [] words = input.split(" ");
            // this places the input into an array but, this splits it by the space between
        boolean rep = false; 
            // creates the rep booleann

        for(int i = 0; i < words.length; i++){
            // iterates through the array
            for(int j = i+1; j < words.length; j++){
                //also does the same but compares the two values i and j. i is before j
                if(words[i].equalsIgnoreCase(words[j])){
                    // the word at index i is compared to the word at index j to see if they are equal ignoring the characters. 
                    rep= true;
                    // if they are then return true 
                      

                }
            }
        }
        if(rep){
            // output is no because rep is true meaning theres repetition. In directions is says if there is a rep then you say no. 
            System.out.println("no");
        }
        else{
            // rep is false so you would say yes as in there is no repititions
            System.out.println("yes");
        }
    }

}
