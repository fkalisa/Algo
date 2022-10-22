package math;

public class SquareRoot {
    public static void main(String[] args) {

        int n = 26;
        int left =1;
        int right = 26/2;

        int result = -1;
        while(left <= right){
            int mid = (left+right)/2;

            if(mid* mid <= n){
                result = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(result);

    }
}
