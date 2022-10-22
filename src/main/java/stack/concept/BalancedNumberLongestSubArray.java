package stack.concept;

import java.util.Stack;

public class BalancedNumberLongestSubArray {

    /*
    use index, add 0 before starting
     */
    public static void main(String[] args) {
        int arr[] = {2, -2, 4, -4, 1, -1};
        compute(arr);

    }

    static void compute(int arr[]){
        int maxi = 0;
        Stack<Integer> stack = new Stack<>();

        stack.add(0);
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int current = arr[i];
            int idx = i+1;
            if(current > 0){
                stack.push(idx);
            }else {
                if (stack.isEmpty()){
                    stack.push(idx);
                } else {
                    int popped = stack.pop();
                    if(arr[popped-1] == -1* current){
                        if(!stack.isEmpty()){
                            maxi = Math.max(maxi, idx-stack.peek());
                        }
                    }
                }
            }

        }

        System.out.println("maxi : " + maxi);
    }
}
