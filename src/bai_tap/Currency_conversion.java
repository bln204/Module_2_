package bai_tap;
import java.util.Scanner;
public class Currency_conversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền muốn đổi:");
        int uSD = scanner.nextInt();
        int rate = uSD * 23000;
        System.out.println(uSD + " USD = " + rate + " VND");
    }
}
