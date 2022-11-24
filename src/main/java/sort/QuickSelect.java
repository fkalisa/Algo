package sort;

public class QuickSelect {

    /*
    O(N) in average
    O(N^2) in worse case
    kth small element
     */
    public static void main(String[] args) {
        int arr[] ={3,2,1,5,6,4};
        int n = arr.length;
        int k = 4;

        System.out.println(quickSelect(arr, 0, n-1, k));
    }

    static int quickSelect(int[] nums, int l, int r, int k){

        int p = l;
        int pivot = nums[r];

        for(int i = l; i < r; i++){
            if(nums[i] <= pivot){
                swap(nums, i, p);
                p++; //
            }
        }
        swap(nums, r, p);


        if(k < p){
            return  quickSelect( nums,  l,  p-1, k);
        }else if(k > p){
            return  quickSelect( nums,  p+1,  r,  k);
        }

        return nums[k];
    }

    static void swap(int arr[], int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
