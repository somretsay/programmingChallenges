public class recursivePrac {
    public static void main(String[] args) {
    System.out.println(fact(3));
    }

    public static double fact(int n){
        if(n ==0){
            return 1;
        }
        else
        return n *fact(n-1);
    }
    

}

