package string.concept;

import java.util.Arrays;

public class KMP_Algo {

    public static void main(String[] args) {

        String s ="aaabcdddbbddddabcdefghi";
        String pattern = "abc";
        int n2 = pattern.length();
        //
        StringBuilder sb = new StringBuilder();
        sb.append(pattern);
        sb.append("$");
        sb.append(s);

        System.out.println(sb);

        int lps [] = compute(sb.toString());

        System.out.println(Arrays.toString(lps));
        int count = 0;
        for (int i = 0; i < lps.length; i++) {
            if(lps[i] ==n2){
                count++;
                System.out.println("pattern start created string : " +(i-2*n2));
            }
        }
        System.out.println(count);
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
