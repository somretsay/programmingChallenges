import java.util.HashMap;
import java.util.Scanner;

public class addingwords {
    public static void main(String[] args) {
        /*
         *  HashMap<Integer, String> words = new HashMap<>();
        Scanner keyboard = new Scanner(System.in);
    

        words.put(1, "first");
        words.put(2,"second");
        String userinput = keyboard.nextLine();
        String[ ] operation = userinput.split(" ");
        String key = (operation[1]);
         */
       
        //System.out.println(words.get(key));

        //why is it null after typing out calc first + second 
        //it should be 1 since first is under 1


        HashMap<String, String> words = new HashMap<>();
        HashMap<String, Integer> flipped = new HashMap<>();
        Scanner keyboard = new Scanner(System.in);
        

        while(true) {
            String userInput = keyboard.nextLine();
            String[] operation = userInput.split(" ");

            if(userInput.isEmpty()){
                System.out.println("calculating....");
                break;
                
            }
            if(operation[0].equalsIgnoreCase("def")){
                    words.put(operation[2],operation[1]);     
                    flipped.put(operation[1],Integer.parseInt(operation[2]));   
                    //System.out.println(words.keySet());  
                }
            else if(operation[0].equalsIgnoreCase("calc")){
                
                    if(!words.containsValue(operation[1]) || !words.containsValue(operation[3]) ){   
                        String answer = "unknown";
                        System.out.println(operation[1]+" "+operation[2]+" "+operation[3]+" "+"="+" "+ answer);

                    }
                    else{
                        //System.out.println(flipped.get(operation[1]));
                        //int answer = flipped.get(operation[1]) + flipped.get(operation[3]);
                        //System.out.println(answer);
                        //System.out.println(operation[1]+" "+operation[2]+" "+operation[3]+" "+"="+" "+words.get(Integer.toString(answer)));
                        for(int i = 0; i < operation.length;i++){
                            if(operation[i].equals("+") && operation[i].equals("-")){
                                
                                
                                int answer = flipped.get(operation[i-1]) + flipped.get(operation[i+1]);
                                for(int m = 1; m<operation.length; m++){
                                    System.out.print(operation[m]+ " ");
                                    //System.out.print(words.get(Integer.toString(answer)));
                                }
                                System.out.println(" " + words.get(Integer.toString(answer)));
                            }
                            else if(operation[i].equals("-")){
                                int answer = flipped.get(operation[i-1]) - flipped.get(operation[i+1]);
                                for(int m = 1; m<operation.length; m++){
                                    System.out.print(operation[m]+ " ");
                                    //System.out.print(words.get(Integer.toString(answer)));
                                }
                                System.out.println(" " + words.get(Integer.toString(answer)));
                            }
                            else if(operation[i].equals("-") && operation[i].equals("+")){
                                System.out.println("trial");
                            }

                            

                        }
                        
                    }
              
            }
            else if(operation[1].equalsIgnoreCase("clear")){
                System.out.println("Clear");
                words.clear();
                flipped.clear();
            }
            
            













            //test
        //words.put("first", 1);
        //words.put("second", 2);
        // Convert the second element of operation to Integer
        //String key = operation[3];

        // Get the corresponding value from the HashMap
        //String value = words.get(key);

        //prints out the value of the key corresponding to its position in the sentence. but if the value is not real or null then it will say Key not found
       // if (value != null) {
         //   System.out.println(value);
        //} else {
         //   System.out.println("Key not found");
        //}
          
            }

        }
    



        

    }

