import javax.swing.plaf.synth.SynthSplitPaneUI;

public class keyedbagDEMO {
    public static void main(String[] args) {
        
        //Test 1 makes sure some inputs are placed into a bag
        
        KeyedBag s = new KeyedBag();

        s.insert("somret", 1);
        s.insert("luke", 2);

        KeyedBag s2 = new KeyedBag();
        s2.insert("joe", 123);

        System.out.println("This is test case 1");
        System.out.println(s.size());
        System.out.println(s2.size());

        //Test Case 2 removes 123 and checks to see if it were taken out

        System.out.println("This is test case 2");
        s2.remove(123);
        System.out.println(s2.size());
       









        //Test Case 3 combines the two together to and then checks size,, I am adding 123 back into the bag
        System.out.println("Test Case 3:");
        s2.insert("joe", 1234);
        s.addAll(s2);
        System.out.println(s.size());
        //since i combined the two it should pop up as 3










        //Test case 4 is to check how many times a certain name pops up and checks to see what item 
        //corresponds with a certain key

        System.out.println("Test case 4:");
        s2.insert("joe", 12345);
        System.out.println(s2.countOccurrences("joe"));
        System.out.println(s2.check(12345));
 








        //Test 5 is to ensure that if a key is inserted that is already placed then it will be rejected. 
        System.out.println("Test Case 5: ");
        s2.insert("lary", 12345);
       










        
         
        //Test 6 is to ensure if we have two bags and they combine, there is no dupilate keys
        // Should only show one occurance of 3 because the second version was removed.

        System.out.println("Test case 6:");
        KeyedBag s3 = new KeyedBag();
        s3.insert("katie", 1);
        s3.insert("kalea", 2);
        s3.insert("tyler", 3);


        KeyedBag s4 = new KeyedBag();
        s4.insert("billy", 3);
        s4.insert("luke", 4);

        s3.addAll(s4);
        System.out.println("Times that the key 3 pops up "+s3.countKeyOccurrences(3));
        System.out.println("All the keys of s3 now that s4 merged to s3");   
        s3.print();
        // The 0s are null since manyItems needs compensate
        







        


    }

}
