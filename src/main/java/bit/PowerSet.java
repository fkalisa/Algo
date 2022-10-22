package bit;

import java.util.Stack;

public class PowerSet {
    public static void main(String[] args) {
        int arr[] ={4, 1, 7};
        int n = arr.length;
        int size = (1 << n);

        for (int i = 0; i < size; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < n; j++) {
                // 2^N
                if ((i & (1 << j) ) == 0) {
                   //not picked
                } else {
                    stack.add(arr[j]);
                }
            }

            System.out.println(stack);
        }

    }
}
