package bai_tap;
import java.util.Scanner;
public class Sum_in_matrix {
//    Bước 1: tính tổng các phần tử của một ma trận vuông có sẵn
//
//Dùng một mảng hai chiều để phản ánh ma trận.
//
//Dùng phương pháp khởi tạo nhanh để tạo ra một mảng có sẵn các phần tử.
// Sử dụng vòng lặp để tính tổng tất cả các phần tử có tọa độ ở hàng ngang và cột dọc bằng nhau. Thông báo cho người dùng.
//
//Thực thi chương trình để kiểm tra kết quả, thử với một số giá trị khác nhau để xác nhận rằng chương trình chạy đúng.
//
//Bước 2: thu thập mảng thực từ nhập liệu của người dùng và hoàn thành yêu cầu
//
//Viết mã để thay thế mảng được tạo nhanh bằng mảng được tạo ra từ nhập liệu của người dùng.
// Trước tiên hỏi để biết kích thước ma trận, sau đó sử dụng vòng lặp để lần lượt hỏi từng giá trị của mảng.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số cột:");
        int cot = scanner.nextInt();
        System.out.println("Nhập số hàng:");
        int hang = scanner.nextInt();
        while (cot != hang){
            System.out.println("Nhập lại số cột:");
            cot = scanner.nextInt();
            System.out.println("Nhập lại số hàng:");
            hang = scanner.nextInt();
        }
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
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("Tổng đường chéo của ma trận là: " + sum);
    }
}
