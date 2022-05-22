package string;

import java.util.Arrays;

public class KMP_Algo {

    public static void main(String[] args) {

        String s ="acacabacacabacacacac";
        int n1 = s.length();
        String pattern = "acac";
        int n2 = pattern.length();
        //
        StringBuilder sb = new StringBuilder();
        sb.append(pattern);
        sb.append("$");
        sb.append(s);

        System.out.println(sb);

        int lps [] = LPS.compute(sb.toString());


        System.out.println(Arrays.toString(lps));
        int count = 0;
        for (int i = 0; i < lps.length; i++) {
            if(lps[i] ==n2){
                count++;
                System.out.println("pattern start created string : " +(i-n2+1));
            }
        }

        System.out.println(count);
    }
}
