public class palindrome {
    public static void main(String[] args) {

        System.out.println(palinumber(1));
        
    }
    public static int palinumber(int n ){
        if(palinumber(n)==(palinumber(n))){
            palinumber(n-1);
            return 1;
        }
        else 
            return 2;
    }
    
}
