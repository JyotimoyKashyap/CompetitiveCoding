package HackerEarth;

import java.util.Scanner;

public class MonkEncuonterWithPolynimial {
    public static void main(String[] args) throws Exception{
        //scanner
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while(t-- > 0){
            long A = scanner.nextLong(), B = scanner.nextLong(), C = scanner.nextLong(), K = scanner.nextLong();

            long sum = 0;
            long i = 0;
            while(sum < K){
                sum = A*i*i + B*i + C;
                i++;
            }
            System.out.println(i-1);

        }

        scanner.close();
    }
}
