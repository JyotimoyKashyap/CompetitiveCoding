package HackerEarth;

import java.util.Arrays;
import java.util.Scanner;

public class CountTheSubArrays {

    public static long countTheSubArray(long[] arr, long k){
        long ans = 0;

        //now I want the prefix sum
        for(long i=1; i<arr.length; i++){
            arr[(int) i] += arr[(int) (i-1)];
            if(arr[(int) i] > k || arr[(int) i] < -1 * k)
                ans++;
        }

        if(arr[0] > k || arr[0] < -1*k)
            ans++;

        Arrays.sort(arr);

        //after calculating the prefix sum we have to get the remaining sub array
        /*
        Here the logic would be like, we will check if a[i]+k and find the upper bound for this, then we will
        get the element right of my searched one. Thus if we have found the element which has a value greater than a[i]+K
        then obviously as array is sorted the other elements would have a sum greater then that.

        And if the sum is greater than obviously, there must be an array between that which would have sum greater than K
        so if we take all the elements from upper bound, we will get all the elements which has a sub array and a sum greater than that of k
         */
        for(int i=0; i<arr.length; i++){
            ans += arr.length - upperbound(arr, 0, arr.length, arr[i]+k);
        }

        return ans;
    }

    public static long upperbound(long[] arr, long low, long high, long element){
        while(low < high){
            long middle = low + (high - low)/2;
            if(arr[(int) middle] > element)
                high = middle;
            else low = middle + 1;

        }
        return low;
    }

    public static void main(String[]  args){
        //scanner class
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        while(T-- > 0){
            long N = scanner.nextInt(), K = scanner.nextInt();
            long[] a = new long[(int) N];

            for(long i=0; i<a.length; i++){
                a[(int)i] = scanner.nextLong();
            }

            System.out.println(countTheSubArray(a,K));


        }


        scanner.close();

    }
}
