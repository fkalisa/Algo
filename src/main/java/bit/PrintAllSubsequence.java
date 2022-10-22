package bit;

import java.util.Stack;

public class PrintAllSubsequence {
    public static void main(String[] args) {

        int n = 3;
        int size = (1 << n);

        for (int i = 0; i < size; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < n; j++) {
                // 2^N
                if ((i & (1 << j) ) == 0) {
                    stack.add(0);

                } else {
                    stack.add(1);
                }
            }
            while (!stack.isEmpty()){
                System.out.print(stack.pop());
            }
            System.out.println();
        }

    }
}
