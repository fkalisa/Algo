package binasysearch;

public class MinimumValueForK {

    public static void main(String[] args) {
        int arr [] = {2, 3, 5, 6, 4, 7};
        int sum = 3;
        compute(arr, sum);
        bruteForce(arr, sum);

    }

    static void compute (int arr[], int sum){

        int left = 1;
        int right = 8; // max+1

        int result = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            int tmpSum = 0;
            for (int item: arr) {
                tmpSum = tmpSum+ item/mid;
            }
            if( sum <= tmpSum){ // included
                left = mid+1;

            }else{
                right = mid-1;
            }
        }
        System.out.println(right);
    }

    static void bruteForce (int arr[], int sum) {
        for (int k = 1;  ; k++) {
            int tmpSum = 0;
            for(int item: arr) {
                tmpSum = tmpSum  + item/k;
            }
            if(tmpSum <= sum){
                System.out.println(k);
                break;
            }
        }


    }
}
