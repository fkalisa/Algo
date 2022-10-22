package stack.concept;

import java.util.Arrays;
import java.util.Stack;

public class NextOrPreviousGreaterElement {
    /*
        stack in decreasing

     */

    public static void main(String[] args) {
        int arr[] = {13, 8, 1, 5, 2, 5, 9, 7, 6, 12};
        System.out.println("Input : ");
        System.out.println(Arrays.toString(arr));
        nextCompute1(arr);
        nextCompute2(arr);
        previousCompute1(arr);
        previousCompute2(arr);
    }

    static void nextCompute1(int arr[]){

        System.out.println("next greater element - non increasing :");

        Stack<Integer> stack = new Stack<>();

        int n = arr.length;

        int sol[] = new int[n];
        Arrays.fill(sol, -1);

        for (int i = 0; i < n; i++) {
            int current = i;
            while (!stack.isEmpty() &&  arr[current] > arr[stack.peek()]){
                int idx = stack.pop();
                sol[idx] = arr[i];
            }

            stack.push(i);
        }

        System.out.println(Arrays.toString(sol));
    }

    static void nextCompute2(int arr[]){

        System.out.println("next greater element - strictly decreasing : ");

        Stack<Integer> stack = new Stack<>();

        int n = arr.length;

        int sol[] = new int[n];
        Arrays.fill(sol, -1);

        for (int i = 0; i < n; i++) {
            int current = i;
            // monotonic strictly decreasing
            while (!stack.isEmpty() &&  arr[current] >= arr[stack.peek()]){
                int idx = stack.pop();
                sol[idx] = arr[i];
            }

            stack.push(i);
        }

        System.out.println(Arrays.toString(sol));
    }


    static void previousCompute1(int arr[]){

        System.out.println("previous");

        Stack<Integer> stack = new Stack<>();

        int n = arr.length;

        int sol[] = new int[n];
        Arrays.fill(sol, -1);

        for (int i = 0; i < n; i++) {
            int current = i;
            //greater or equal, we do not remove the equal
            while (!stack.isEmpty() &&  arr[current] > arr[stack.peek()]){
                stack.pop();

            }

            if (!stack.isEmpty()){
                sol[i] = arr[stack.peek()];
            }

            stack.push(i);
        }

        System.out.println(Arrays.toString(sol));

    }

    static void previousCompute2(int arr[]){

        System.out.println("previous");

        Stack<Integer> stack = new Stack<>();

        int n = arr.length;

        int sol[] = new int[n];
        Arrays.fill(sol, -1);

        for (int i = 0; i < n; i++) {
            int current = i;
            // greater, we pop the equal
            // monotonic strictly decreasing
            while (!stack.isEmpty() &&  arr[current] >= arr[stack.peek()]){
                stack.pop();

            }

            if (!stack.isEmpty()){
                sol[i] = arr[stack.peek()];
            }

            stack.push(i);
        }

        System.out.println(Arrays.toString(sol));

    }


}
