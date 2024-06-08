package bai_tap;
import java.util.Scanner;
public class Print_Hello {
    public static void main(String[] args) {
        System.out.println("Nhập tên của bạn:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Xin chào " + name);
    }
}
