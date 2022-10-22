package stack.concept;

import java.util.Arrays;
import java.util.Stack;

public class NextOrPreviousSmallerElement {

      /*
        stack is increasing
     */

    public static void main(String[] args) {
        int [] arr = {5, 8, 7,6, 3, 9, 10, 10,  8};
        compute(arr);
    }


    static void compute(int [] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int result[] = new int[n];
        for (int i = n-1; i >=0 ; i--) {
            int current = arr[i];
            while(!stack.isEmpty() && stack.peek()>= current){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]= -1;
            }else{
                result[i]= stack.peek();
            }
            stack.push(current);
        }
        System.out.println(stack);
        System.out.println(Arrays.toString(result));
    }
}
