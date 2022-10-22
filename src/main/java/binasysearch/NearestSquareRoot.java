package binasysearch;

public class NearestSquareRoot {

    public static void main(String[] args) {

        int input = 26;

        int left = 1;
        int right = input;
        while(left <= right){
            int mid = (left+right) >> 1;

             if( input <= mid*mid ){
                right = mid-1;

            }else{
                left =
                        mid+1;
            }
        }

        System.out.println(right);
    }
}
