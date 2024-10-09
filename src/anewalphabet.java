import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class anewalphabet {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String userInput = keyboard.nextLine();
        Map<Character, String> alphabet = new HashMap<>();
        alphabet.put('a',"@");
        alphabet.put('b',"8");
        alphabet.put('c',"(");
        alphabet.put('d',"|)");
        alphabet.put('e',"3");
        alphabet.put('f',"#");
        alphabet.put('g',"6");
        alphabet.put('h',"[-]");
        alphabet.put('i',"|");
        alphabet.put('j',"_|");
        alphabet.put('k',"|<");
        alphabet.put('l',"1");
        alphabet.put('m',"[]"+"\\"+"/"+"[]");
        alphabet.put('n',"[]"+"\\"+"[]");
        alphabet.put('o',"0");
        alphabet.put('p',"|D");
        alphabet.put('q',"(,)");
        alphabet.put('r',"|Z");
        alphabet.put('s',"$");
        alphabet.put('t',"']['");
        alphabet.put('u',"|_|");
        alphabet.put('v',"\\"+"/");
        alphabet.put('w',"\\"+"/"+"\\"+"/");
        alphabet.put('x',"}{");
        alphabet.put('y',"`/");
        alphabet.put('z',"2");
        String lowercase = userInput.toLowerCase();
        
        StringBuilder codedMessage = new StringBuilder();
        for(char letter : lowercase.toCharArray()){
            if(alphabet.containsKey(letter)){
                codedMessage.append(alphabet.get(letter));
            }
            else{
                codedMessage.append(letter);
            }
        }
        System.out.println(codedMessage.toString());

    
        
    }

}
