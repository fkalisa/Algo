package math;

public class GCD {

    /*
    time complexity : log(n)
     */

    public static void main(String[] args) {
        int a = 100;
        int b = 40;


        while(a!= 0 && b!= 0){
            if(b> a){
                b = b%a;
            } else{
                a = a%b;
            }
        }

        if(a!= 0)
            System.out.println(a);
        else
            System.out.println(b);
    }
}
