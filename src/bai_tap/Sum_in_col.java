package bai_tap;
import java.util.Scanner;
public class Sum_in_col {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số cột:");
        int cot = scanner.nextInt();
        System.out.println("Nhập số hàng:");
        int hang = scanner.nextInt();
        int[][] arr = new int[cot][hang];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Nhập phần tử [" + i + "][" + j + "]: ");
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Nhập cột muốn tính tổng: ");
        int col = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][col];
        }
        System.out.println("Tổng của cột " + col + " là: " + sum);
    }
}
