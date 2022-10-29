package sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = {1, 7, 2, 4, 8, 4, 13, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // min
    // swap i and min
    // O(N^2) - O(1)
    public static void sort(int arr[]){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            int min =  arr[i];
            int minIdx = i;
            int j = i;
            while(j < n){

                int current = arr[j];
                if(current < min){
                    min = current;
                    minIdx = j;
                }
                j++;
            }

            swap(arr,i, minIdx);
        }

    }

    public static void swap(int arr[], int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
