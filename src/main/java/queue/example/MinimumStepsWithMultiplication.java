package queue.example;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumStepsWithMultiplication {
    /*
      https://www.geeksforgeeks.org/minimum-steps-to-reach-end-from-start-by-performing-multiplication-and-mod-operations-with-array-elements/

    you need :
    a visited because you may visit an element multiple time, visited size is equal to modulo
    a modulo because the numbers can be huge
    add in the queue, you mark visited

    1/ start at the first position
    2/ take out the front element
    3/ try to go all the possible ways from the element you took out
    4/ mark visited that particular index you are at and push in the queue
     */
    public static void main(String[] args) {
        int start = 4;
        int dest = 244;
        int arr[] = {2, 3, 4};
        int mod = 10_000;


        Queue<int []> q = new LinkedList<>();

        q.add(new int[]{start, 0});
        Set<Integer> set = new HashSet<>();
        set.add(start);
        int ans = -1;
        while(q.isEmpty()){
            int [] current = q.remove();

            int current_node = current[0];
            int current_level = current[1];

            if(current_node == dest){
                ans = current_level;
                break;
            }

            for (int i = 0; i < arr.length; i++) {
                int next_node = (current_node* arr[i])%mod;
                if (!set.contains(next_node)){
                    set.add(next_node);
                    q.add(new int[]{next_node, current_level+1});
                }

            }
        }
        System.out.println(ans);
    }
}
