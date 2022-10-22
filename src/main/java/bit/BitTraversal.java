package bit;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BitTraversal {
    /*
    contrary to array, bit are traversed from right to left
     */

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();



        AtomicInteger counter = new AtomicInteger();
        counter.set(counter.get()+map.get(""));

        int m = 8;
        int dup = m;
        while (dup != 0){
           if( (dup&1) == 1){
               System.out.print(1);
           }else{
               System.out.print(0);
           }
            dup = dup >> 1;
        }
    }
}
