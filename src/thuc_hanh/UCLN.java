package thuc_hanh;
import java.util.Scanner;
public class UCLN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số thứ nhất: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số thứ hai: ");
        int b = scanner.nextInt();

        if (a == 0 || b == 0) {
            System.out.println("Không có UCLN!");
        }

        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        System.out.println("Ước chung lớn nhất là: " + a);
    }
}
