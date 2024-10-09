import java.util.Scanner;

public class equalsumseasy {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int testCases;
        int iterations = 0;
        int subsetIterations=0;
        int n;
        int subset;
        int x=0;

        testCases = keyboard.nextInt();

        while(iterations<testCases){
            n = keyboard.nextInt();
            while(subsetIterations<n){
                subset= keyboard.nextInt();
                subsetIterations++;

                if(subsetIterations==n){
                    subsetIterations=0;
                }
                
            
            }
            iterations++;
            x++;
            

            System.out.println("Case #"+x);
        }
        


    
    }

}
