package stack.concept;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int arr[] ={1, 2, 3, 4};
        int n= arr.length;
        int res []=previousSmaller(arr, n);

        System.out.println(Arrays.toString(res));
    }

    static int [] previousSmaller(int[] nums, int n){

        //value
        int result [] = new int[n];
        Arrays.fill(result, -1);
        // index
        Stack<Integer> stack = new Stack<>();


        for(int i =0; i < n; i++){
            int current = nums[i];
            while(!stack.isEmpty() &&   current<=nums[stack.peek()] ){
                int idx = stack.pop();
            }
            if(!stack.isEmpty()){
                result[i] = nums[stack.peek()];
            }

            stack.push(i);
        }
        return result;
    }
}
