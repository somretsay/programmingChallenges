public class test {
    public static void main(String[] args) {

        int a[]=  {1,-5,2};
        System.out.println(getmean(a));
     
        
    }

    public static double getmean(IntArraybag Bag){
        double mean = double.NaN;
        double sum=0;
        if(bagSize==0){
           
        }
        else
        for(int i = 0; i<a.length ;i++){
            sum +=a[i];

        }
        mean = sum/a.length;
        return mean;
    }

}
