package string.concept;

public class HashingSlidingWindows {

    public static final int prime = 31;

    public static void main(String[] args) {

        int mod= 1_000_000_007;

        String haystack = "aaabcdddbbddddabcdefghi";
        String needle = "abc";

        int n_needle = needle.length();
        int n_haystack =haystack.length();

        long needle_hash = 0;
        long p = 1;
        // calculate the hash of needle
        for(int i = 0; i < n_needle; i++){
            int current = needle.charAt(i);
            needle_hash = (needle_hash + (current*p)%mod)%mod;
            p = (p* prime)%mod;
        }

        // calculate the first fixed window in haystack
        int left = 0;
        int right = n_needle-1;
        p =1;
        long haystack_hash = 0;
        for(int i = 0; i <= right; i++){
            int current = haystack.charAt(i);
            haystack_hash = (haystack_hash + (current*p)%mod)%mod;
            p = (p* prime)%mod;
        }


        if(haystack_hash == needle_hash){
            System.out.println("index : " +left);

        }
        p = prime;
        // go until n_haystack-1
        while(right < n_haystack-1){

            int char_left = haystack.charAt(left);

            haystack_hash = (haystack_hash - (char_left* power(p, left, mod)%mod) + mod)%mod;
            left++;
            right++;
            int char_right = haystack.charAt(right);

            haystack_hash = (haystack_hash + (char_right* power(p, right, mod))%mod)%mod;

            long tmp = (haystack_hash* moduloInverse(power(p, left, mod), mod))%mod;

            if(tmp  == needle_hash){
                System.out.println("res2 : " + left);
            }

        }
    }

    static long  power(long  b, long  p, long mod) {

        long res = 1;

        while (p != 0) {
            if (p % 2 == 0) {
                b = (b * b) % mod;
                p = p / 2;
            } else {
                res = (b * res) % mod;
                p = p - 1;
            }
        }
        return res;
    }

    // module inverse because division is not precise
    static long moduloInverse(long n, long mod)
    {
        return power(n, mod - 2, mod);
    }
}
