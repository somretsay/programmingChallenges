import java.util.Scanner;

public class quadrant {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int x;
        int y;
       
        
        System.out.println("Enter x value");
        x= keyboard.nextInt();
        System.out.println("Enter y value");
        y= keyboard.nextInt();
        if (x > 0 && y>0){
            System.out.println("1");

        }
        else if (x > 0 && y<0 ){
            System.out.println("4");
        }
        else if (x <0 && y <0){
            System.out.println("3");
        }
        else if (x <0 && y>0){
            System.out.println("2");
        }
        else {
            System.out.println("Origin");
        }
        
    }

}
