public class facotoral {

    public static void main(String[] args) {
        System.out.println(factoral(4));
        
    }
    
    public static double factoral(int n){

        if(n==0 || n==1){
            return n;
        }
        else{
            return n *factoral(n-1);
        }
       
       
        
    }
    public static String palindrome(String i ){
       if(i.length()==1){
        return "no";
       }
       else{
        
       }
       
       
        return "palidrome";
    }
}
