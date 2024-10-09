  
import edu.colorado.homework.Statistician;

public class StatisticianDemo {
    public static void main(String[] args) {


//HW-2 Answers
    //Test sample from the book
    Statistician s = new Statistician();
    s.nextNumber(1.1);
    s.nextNumber(-2.4);
    s.nextNumber(8);

    System.out.println("The length is  " + s.length());
    System.out.println("The largest number added is " + s.maximum());
    System.out.println("The smallest number added is " + s.minimum());
    System.out.println("Sum of the set is " + s.sum());
    System.out.println("Last number added: " + s.last());
    System.out.println("Mean: " + s.mean());

    //Test2 shows no inputs added 
    Statistician test2 = new Statistician();
    
    System.out.println("The length is  " + test2.length());
    System.out.println("The largest number added is " + test2.maximum());
    System.out.println("The smallest number added is " + test2.minimum());
    System.out.println("Sum of the set is " + test2.sum());
    System.out.println("Last number added: " + test2.last());
    System.out.println("Mean: " + test2.mean());

    //Test3 shows sum being 0
    Statistician test3 = new Statistician();
    test3.nextNumber(4.4);
    test3.nextNumber(8.8);
    test3.nextNumber(-4.4);

    
    System.out.println("The length is  " + test3.length());
    System.out.println("The largest number added is " + test3.maximum());
    System.out.println("The smallest number added is " + test3.minimum());
    System.out.println("Sum of the set is " + test3.sum());
    System.out.println("Last number added: " + test3.last());
    System.out.println("Mean: " + test3.mean());

    //Test4 shows sum being 0
    Statistician test4 = new Statistician();
    test4.nextNumber(4.4);
    test4.nextNumber(-8.8);
    test4.nextNumber(-4.4);

    
    System.out.println("The length is  " + test4.length());
    System.out.println("The largest number added is " + test4.maximum());
    System.out.println("The smallest number added is " + test4.minimum());
    System.out.println("Sum of the set is " + test4.sum());
    System.out.println("Last number added: " + test4.last());
    System.out.println("Mean: " + test4.mean());




// HW-3  Answers
        //Test 1 no numbers in the are in either

        Statistician s1 = new Statistician();
        //s1.nextNumber(1);
        //s1.nextNumber(3);  
        
        Statistician s2 = new Statistician();
        //s2.nextNumber(19);
        //s2.nextNumber(8);
        
        
        
        Statistician combined =  new Statistician();
        combined = Statistician.add(s1, s2);
         
        System.out.println("Test 1: Whole Statistician length "+ combined.length());
        System.out.println("Test 1: Statistician mean "+ combined.mean());
        System.out.println("Test 1: Statistician sum "+ combined.sum());
        System.out.println("Test 1: Statistician largest number is "+ combined.maximum());
        System.out.println("Test 1: Statistician smallest number "+ combined.minimum());
        System.out.println("Test 1: Statistician last number input "+ combined.last());

        //Test 2 numbers are entered

        Statistician s3 = new Statistician();
        Statistician combined2 =  new Statistician();
        s3.nextNumber(1);
        s3.nextNumber(3);
        s3.nextNumber(-4.7);
        
        
        Statistician s4 = new Statistician();
        s4.nextNumber(19);
        s4.nextNumber(8);
        
        combined2 = Statistician.add(s3, s4);
         
        System.out.println("Test 2: Whole Statistician length "+ combined2.length());
        System.out.println("Test 2: Statistician mean "+ combined2.mean());
        System.out.println("Test 2: Statistician sum "+ combined2.sum());
        System.out.println("Test 2: Statistician largest number is "+ combined2.maximum());
        System.out.println("Test 2: Statistician smallest number "+ combined2.minimum());
        System.out.println("Test 2: Statistician last number input "+ combined2.last());

 
        //Test 3 numbers are entered only in s5

        Statistician s5 = new Statistician();
        Statistician combined3 =  new Statistician();
        s5.nextNumber(1);
        s5.nextNumber(3);
        s5.nextNumber(-4.7);
        
        
        Statistician s6 = new Statistician();
        //s6.nextNumber(19);
        //s6.nextNumber(8);
        
        combined3 = Statistician.add(s5, s6);
        
        
        
        System.out.println("Test 3: Whole Statistician length "+ combined3.length());
        System.out.println("Test 3: Statistician mean "+ combined3.mean());
        System.out.println("Test 3: Statistician sum "+ combined3.sum());
        System.out.println("Test 3: Statistician largest number is "+ combined3.maximum());
        System.out.println("Test 3: Statistician smallest number "+ combined3.minimum());
        System.out.println("Test 3: Statistician last number input "+ combined3.last());



        //Test 4 numbers are entered only in s8

        Statistician s7 = new Statistician();
        Statistician combined4 =  new Statistician();
        //s7.nextNumber(1);
        //s7.nextNumber(3);
        //s7.nextNumber(-4.7);
        
        
        Statistician s8 = new Statistician();
        s8.nextNumber(19);
        s8.nextNumber(8);
        
        combined4 = Statistician.add(s7, s8);
        
         
        
        System.out.println("Test 4: Whole Statistician length "+ combined4.length());
        System.out.println("Test 4: Statistician mean "+ combined4.mean());
        System.out.println("Test 4: Statistician sum "+ combined4.sum());
        System.out.println("Test 4: Statistician largest number is "+ combined4.maximum());
        System.out.println("Test 4: Statistician smallest number "+ combined4.minimum());
        System.out.println("Test 4: Statistician last number input "+ combined4.last());
    
    }

}
