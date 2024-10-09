public class statdemo2 {
    public static void main(String[] args) {
        //HW-2 Answers
    //Test sample from the book
    Statistician s = new Statistician();
    s.nextNumber(1.1);
    s.nextNumber(-2.4);
    s.nextNumber(8);

    System.out.println("TEST 1");

    System.out.println("The length is  " + s.length());
    System.out.println("The largest number added is " + s.maximum());
    System.out.println("The smallest number added is " + s.minimum());
    System.out.println("Sum of the set is " + s.sum());
    System.out.println("Last number added: " + s.last());
    System.out.println("Mean: " + s.mean());
   
    System.out.println("TEST 2");

    //Test2 shows no inputs added 
    Statistician test2 = new Statistician();
    
    System.out.println("The length is  " + test2.length());
    System.out.println("The largest number added is " + test2.maximum());
    System.out.println("The smallest number added is " + test2.minimum());
    System.out.println("Sum of the set is " + test2.sum());
    System.out.println("Last number added: " + test2.last());
    System.out.println("Mean: " + test2.mean());

    System.out.println("TEST 3");

    //Test3 shows sum being 0
    Statistician test3 = new Statistician();
    test3.nextNumber(5.4);
    test3.nextNumber(-9.8);
    test3.nextNumber(4.4);

    
    System.out.println("The length is  " + test3.length());
    System.out.println("The largest number added is " + test3.maximum());
    System.out.println("The smallest number added is " + test3.minimum());
    System.out.println("Sum of the set is " + test3.sum());
    System.out.println("Last number added: " + test3.last());
    System.out.println("Mean: " + test3.mean());

    System.out.println("TEST 4");

    //Test4 shows sum being negatibr
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
    }

}
