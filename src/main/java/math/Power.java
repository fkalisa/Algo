package math;

public class Power {
    public static void main(String[] args) {
        int mod = 1_000_000_007;

        System.out.println(power(5, 3, mod));
        System.out.println(power2(5, 3, mod));
    }

    static long  power2(long  b, long  p, long mod) {

        if(p == 0){
            return 1;
        }

        if(p % 2 == 0){
            return power2(  b,   p/2,  mod) *power2(  b,   p/2,  mod) % mod;
        }else{
            return (b* (power2(  b,   (p-1)/2,  mod) *power2(  b,   (p-1)/2,  mod))%mod)%mod;
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


}
