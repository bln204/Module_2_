package bai_tap;
import java.util.Scanner;
public class Print_20_SNT {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 0;
        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);
                count++;
                if (count == 20) {
                    break;
                }
            }
        }
    }
}