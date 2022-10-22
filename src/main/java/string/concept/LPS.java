package string.concept;

import java.util.Arrays;

public class LPS {
    /*
    LPS : longest Prefix Suffix
    Time : O(N)
     */
    public static void main(String[] args) {

        String s = "AABAACAADAABAABA";
        int[] LPS = compute(s);
        System.out.println(Arrays.toString(LPS));
    }

    public static  int[] compute(String s) {
        int i = 1;
        int len = 0;
        int n = s.length();

        int[] LPS = new int[n];

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)){
                LPS[i] =  len+1;
                i++;
                len++;
            }else{
                if(len!=0){
                    len = LPS[len-1];
                }else {
                    LPS[i]=0;
                    i++;
                }
            }

        }
        return LPS;
    }
}
