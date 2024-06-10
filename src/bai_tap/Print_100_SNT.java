package bai_tap;

public class Print_100_SNT {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 2; i <= 1000; i++) {
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
                if (count == 100) {
                    break;
                }
            }
        }
    }
}
