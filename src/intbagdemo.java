

public class intbagdemo {

    public static void main(String[] args) {
        
        IntArrayBag2 b2 = new IntArrayBag2();
        IntArrayBag2 b1 = new IntArrayBag2();

        b2.add(2);
        b2.add(3);
        b1.add(2);
        b1.add(3);
        b1.add(1);

        IntArrayBag2 b3 = IntArrayBag2.minus(b2, b1);
        System.out.println(b3);

        int a,b,c;
        a= new Location(4,20);
        b= new Location(3,20);
        b=a.clone();
        c=a;



            
        

    }

}
