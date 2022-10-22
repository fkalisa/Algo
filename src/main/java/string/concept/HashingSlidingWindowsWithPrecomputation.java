package string.concept;

public class HashingSlidingWindowsWithPrecomputation {

    public static void main(String[] args) {
        int mod= 1_000_000_007;


        String haystack = "ababcabcdefghi";
        String needle = "ab";

        int n_needle = needle.length();
        int n_haystack =haystack.length();

//


        long prime[] = new long[n_haystack];
        long preHash[] = new long[n_haystack];
        long modInv[] = new long[n_haystack];

        long h = 0;
        long p = 1;

        for (int i = 0; i < n_haystack; ++i)
        {
            char c = haystack.charAt(i);
            h = ((h + (c - 'a' + 1) * p) % mod) % mod;
            prime[i] = p;
            preHash[i] = h;
            modInv[i] = moduloInverse(prime[i], mod);
            p = ( p * 31) % mod;
        }



        int z = 0;
        int b = 1;

        long hash1 =  preHash[b];
        if (z > 0) {
            hash1  = (hash1  - preHash[z - 1] + mod) % mod;
            hash1 =  (hash1 *  modInv[z]) % mod;
        }


        int k = 5;
        int t = 6;
        long hash2 = preHash[t];
        if (k > 0) {
            hash2 = (hash2 - preHash[k - 1] + mod) % mod;
            hash2 = (hash2 * modInv[k]) % mod;
        }


        System.out.println("hash2: " + hash2);
        System.out.println("hash1: " + hash1);
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

    static long moduloInverse(long n, long mod)
    {
        return power(n, mod - 2, mod);
    }

}
