package HackerEarth;

import java.util.Scanner;

public class FuriousFive {
    public static long furious(long n){
        long r = 0;
        while(n != 0){
            r += n/5;
            n = n/5;
        }
        return r;
    }
    public static void main(String[] args) throws Exception{
       //scanner class
        Scanner scanner = new Scanner(System.in);
        long T = scanner.nextLong();
        long res = 0;
        while(T-- > 0){
            long low = 5, high = Long.MAX_VALUE;
            long N = scanner.nextLong();
            res = high;

            while(low <= high){
                long mid = low + (high - low)/2;
                long val = furious(mid);
                if(val >= N){
                    high = mid - 1;
                    res = high;
                }else{
                    low = mid + 1;
                }

            }
            System.out.println(res+1);

        }



        //scanner
        scanner.close();
    }
}
