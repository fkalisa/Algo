package sort;

import java.util.ArrayList;
import java.util.List;

public class CycleSort {

    public static void main(String[] args) {

        int arr[] = {1, 7, 2, 4, 8, 4, 13, 0};

        computeMissingNumber( new int []{3,0,1});
    }


    //https://leetcode.com/problems/missing-number/
    public static void computeMissingNumber(int [] nums){
        int n = nums.length;

        for(int i = 0; i < n; i++){

            while(nums[i]!= i){
                int d = nums[i]; // d an index but we put arr[i]
                if(d>= n){ //difference - because the value are thant index array
                    break;
                }
                swap(nums, i, d);
            }
        }

        int result = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i]!= i){
                result = i;
                break;
            }
        }

        System.out.println("result" + result);
    }

    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

    public static void computeDisappearedNumber(int [] nums) {

        List<Integer> result = new ArrayList<>();
        int n = nums.length;


        for(int i = 0; i < n; i++){

            while(i+1!= nums[i]){
                int d = nums[i]-1;
                if(nums[i] == nums[d]){ //difference - because duplicate
                    break;
                }
                swap(nums, d, i);
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] != i+1){
                result.add(i+1);
            }
        }

        System.out.println( result);

    }



    static void swap (int arr[], int i, int j){
        int tmp = arr[i];
        arr[i] =  arr[j];
        arr[j] = tmp;
    }
}
