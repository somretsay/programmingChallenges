public class prime2024th {
    public static void main(String[] args) {
        int i = 0;
        int numberPrimed=0;

//checks until we reach 2024th prime number
        while(numberPrimed<2024){
            //checks if prime, if it is then we increment number primed unil we get 2024 and also increments the number we are checking
            if(isPrime(i)){
            numberPrimed++;
            i++;
            
        }
            //if number isnt prime then we increment the number we are checking to the next
            else{
            i++;
        }
        }
        System.out.println(i-1);
        

    




        


    }
    public static boolean isPrime(int number){
        if(number<=1){
            return false;
        }
        else{
            for(int i = 2; i<=Math.sqrt(number); i++){
                if(number%i==0){
                    return false;
                }

            }
        }
        return true;
        
        
    }

}
