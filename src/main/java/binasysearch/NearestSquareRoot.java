package binasysearch;

public class NearestSquareRoot {

    public static void main(String[] args) {
        compute();
        compute2();
    }

    private static void compute() {
        int input = 26;
        // return one of the pointer : left or right
        int left = 1;
        int right = input;

        while(left <= right){
            int mid = (left+right) >> 1;

            if( mid*mid <= input ){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(right);
    }

    private static void compute2() {
        // using variable result
        int input = 26;

        int left = 1;
        int right = input;
        int result = -1;
        // target mid !!
        while(left <= right){
            int mid = (left+right) >> 1;
            if( mid*mid <= input){
                result = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(result);
    }
}
