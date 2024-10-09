import java.util.Arrays;
import java.util.Random;

public class quickSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = {9,3,2,8,6,3,4,7};

        //for(int i = 0; i < nums.length; i++){
          //  nums[i] = rand.nextInt(100);
        //}

        System.out.println("before");
        System.out.print(Arrays.toString(nums));

        quicksort(nums, 0, nums.length-1);

        System.out.println("after:");
        System.out.print(Arrays.toString(nums));



        
    }
    public static void quicksort(int[] array, int index1, int index2){
        
        if(index1 >= index2){
            return;
        }

        int pivot = array[index2];
        //chose my pivot as the last number of array.

        int leftP = index1;
        int rightP = index2;

        while(leftP < rightP){

            while(array[leftP] <= pivot && leftP < rightP){
                leftP ++;
                //moves along the array from left to right
            }
            while(array[rightP] >= pivot && leftP < rightP){
                rightP --;
                //moves along the array from right to left

            }
            swap(array, leftP, rightP);



        }
        swap(array, leftP, index2);

        quicksort(array, index1, leftP -1);
        //recursively calls for left side
        quicksort(array, leftP + 1, index2);
        //recursively calls for right side
        

    }
    private static void swap(int[] array, int index1, int index2){
        int holder = array[index1];
        array[index1] = array[index2];
        array[index2] = holder;
    }
    
    
}
