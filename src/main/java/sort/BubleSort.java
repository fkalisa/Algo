package sort;

import java.util.Arrays;

public class BubleSort {

    public static void main(String[] args) {

        int arr[] ={4, 1, 9, 2 ,3 , 5};
        compute1( arr);

        arr =new int []{4, 1, 9, 2 ,3 , 5};
        compute1( arr);
        System.out.println(Arrays.toString(arr));
    }


    // compare i and j - not optimized
    public static void compute1( int [] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

    // compare j-1 and j - optimized as the second loop gets smaller


    public static void compute2( int [] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){

            for(int j = i+1; j < n - i; j++){
                int val1 = arr[j];
                int val2 = arr[j-1];

                if(val2 > val1){
                    swap(arr, j,  j-1);
                }
            }
        }
    }

    static void swap(int arr[], int i, int j){

        System.out.println("here");

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

