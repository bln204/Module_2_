package thuc_hanh;

import java.util.Scanner;
public class Interest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền cần gửi: ");
        double money_in = scanner.nextDouble();
        System.out.println("Nhập số tháng gửi:");
        int month = scanner.nextInt();
        System.out.println("Nhập số lãi suất:");
        double interestRate = scanner.nextDouble();
        double money_out = 0;
        for (int i = 0; i < month; i++) {
            money_out += money_in * (interestRate / 100)/ 12 * month;
        }
        System.out.println("Số tiền nhận được sau " + month + " là: " + money_out);

    }
}
